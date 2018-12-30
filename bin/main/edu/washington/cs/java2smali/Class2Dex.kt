package edu.washington.cs.java2smali

import com.android.dx.command.dexer.Main

import java.io.IOException

object Class2Dex {
    @Throws(IOException::class)
    fun dexClassFile(inputClassFilePaths: Array<String>, outputDexPath: String) {
        val arguments = Main.Arguments()
        arguments.outName = outputDexPath
        arguments.strictNameCheck = false
        arguments.fileNames = inputClassFilePaths

        Main.run(arguments)
    }
}