package com.test.task

import java.io.IOException
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit

fun main() {
    print("Enter python executable path: ")
    val pythonExecutable = readLine()

    val executor = ScheduledThreadPoolExecutor(1)
    var counter = 0
    val future = executor.scheduleAtFixedRate({
        println("Seconds since start: $counter")
        counter += 1
    }, 0, 1, TimeUnit.SECONDS)


    try {
        val process = Runtime.getRuntime().exec("$pythonExecutable -m timeit -r 10")
        process.waitFor()
        executor.execute() {
            println("OUTPUT:")
            process.inputStream.bufferedReader().readLines().forEach { println(it) }
            val errorStreamOutput = process.errorStream.bufferedReader().readLines()
            if (errorStreamOutput.isNotEmpty()) {
                println("ERROR:")
                errorStreamOutput.forEach { println(it) }
            }
        }
    } catch (e: IOException) {
      println("Exception occurred: ${e.message}")
    } finally {
        future.cancel(true)
        executor.shutdown()
    }


}