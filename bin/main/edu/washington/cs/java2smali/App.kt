package edu.washington.cs.java2smali

import org.apache.commons.io.FileUtils
import java.io.File
import java.lang.Exception
import java.lang.RuntimeException
import java.nio.file.Files
import java.util.stream.Collectors.toList
import javax.tools.ToolProvider
import kotlin.system.exitProcess

object App {
    @JvmStatic
    fun main(args: Array<String>) {
        val javaPath = args[0]
        val smaliPath = args[1]
        val compiler = ToolProvider.getSystemJavaCompiler()
        val classpath = System.getProperty("java.class.path")
        val optionList = listOf("-classpath", classpath)
        try {
            val fileManager = compiler.getStandardFileManager(null, null, null)
            val fileObjects = fileManager.getJavaFileObjectsFromStrings(listOf(javaPath))
            val task = compiler.getTask(null, null, null, optionList, null, fileObjects)
            val result = task.call()
            if (result == null || !result) {
                throw RuntimeException("Compilation failed")
            }
        } catch (e : Exception) {
            e.printStackTrace()
            exitProcess(-1)
        }
        val classPath = javaPath.replace(".java", ".class")
        val tempFile = File.createTempFile("java2smali-", ".dex")
        Class2Dex.dexClassFile(arrayOf(classPath), tempFile.absolutePath)
        val tempDir = Files.createTempDirectory("java2smali-")
        Dex2Smali.disassembleDexFile(tempFile.absolutePath, tempDir.toString())
        val list = Files.walk(tempDir).filter { f -> Files.isRegularFile(f) }.collect(toList())
        FileUtils.deleteQuietly(File(classPath))
        FileUtils.copyFile(File(list[0].toString()), File(smaliPath))
        FileUtils.deleteDirectory(tempDir.toFile())
        tempFile.deleteOnExit()
    }
}