package com.test.task

import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit

fun main() {
    print("Enter python executable path: ")
    val pythonExecutable = readLine()

    val executor = ScheduledThreadPoolExecutor(1)
    var counter = 0
    val future = executor.scheduleAtFixedRate({
        println(counter)
        counter += 1
    }, 0, 1, TimeUnit.SECONDS)


    val process = Runtime.getRuntime().exec("$pythonExecutable -m timeit -r 10")
    process.waitFor()
    future.cancel(true)

    executor.execute() {
        println("OUTPUT:")
        process.inputStream.bufferedReader().readLines().forEach { println(it) }
        val errorStreamOutput = process.errorStream.bufferedReader().readLines()
        if (errorStreamOutput.isNotEmpty()) {
            println("ERROR:")
            errorStreamOutput.forEach { println(it) }
        }
    }

    executor.shutdown()
}