package com.yzp.androidxkotlin.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yzp.androidxkotlin.R
import kotlinx.coroutines.*


/**
 * 协程的学习
 */
class CoroutinesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)
        main9()


    }

    fun main9() = runBlocking {
        GlobalScope.launch {
            repeat(10) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        }
        delay(1300L) // 在延迟后退出
    }

    fun main8() = runBlocking {
        println("Hello,")
        repeat(1000) { // 启动大量的协程
            launch {
                delay(1000L)
                println("=====.")
            }
        }
    }

    fun main7() = runBlocking {
        launch { doWorld() }
        println("Hello,")
    }

    // 这是你的第一个挂起函数
    suspend fun doWorld() {
        delay(1000L)
        println("World!")
    }



    fun main6() = runBlocking {
        launch {
            delay(200L)
            println("Task from runBlocking")
        }
        coroutineScope { // 创建一个协程作用域
            launch {
                delay(500L)
                println("Task from nested launch")
            }
            delay(100L)
            println("Task from coroutine scope") // 这一行会在内嵌 launch 之前输出
        }
        println("Coroutine scope is over") // 这一行在内嵌 launch 执行完毕后才输出
    }


    fun main5() = runBlocking {
        launch {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
    }


    fun main4() = runBlocking {
        val job = GlobalScope.launch { // 启动一个新协程并保持对这个作业的引用
            delay(1000L)
            println("World!")
        }
        println("Hello,")
        job.join() // 等待直到子协程执行结束
        println("He,")
    }

    fun main() {
        GlobalScope.launch { // 在后台启动一个新的协程并继续
            delay(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
            println("World!") // 在延迟后打印输出
        }
        println("Hello,") // 协程已在等待时主线程还在继续
        Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活
    }

    fun main2() {
        GlobalScope.launch { // 在后台启动一个新的协程并继续
            delay(1000L)
            println("World!")
        }
        println("Hello,") // 主线程中的代码会立即执行
        runBlocking {     // 但是这个表达式阻塞了主线程
            delay(2000L)  // ……我们延迟 2 秒来保证 JVM 的存活
        }
    }

    fun main3() = runBlocking {
        GlobalScope.launch { // 在后台启动一个新的协程并继续
            delay(1000L)
            println("World!")
        }
        println("Hello,") // 主协程在这里会立即执行
        delay(2000L)      // 延迟 2 秒来保证 JVM 存活
    }


}