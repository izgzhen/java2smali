package edu.washington.cs.java2smali

import org.jf.baksmali.Baksmali
import org.jf.baksmali.BaksmaliOptions
import org.jf.dexlib2.DexFileFactory
import org.jf.dexlib2.Opcodes
import java.io.File
import java.io.IOException

object Dex2Smali {
    @Throws(IOException::class)
    fun disassembleDexFile(dexFilePath: String, outputDir: String) {
        val opCodes = Opcodes.getDefault()
        val dexBackedDexFile = DexFileFactory.loadDexFile(dexFilePath, opCodes)

        val options = BaksmaliOptions()
        options.apiLevel = opCodes.api
        Baksmali.disassembleDexFile(dexBackedDexFile, File(outputDir), 6, options)
    }
}