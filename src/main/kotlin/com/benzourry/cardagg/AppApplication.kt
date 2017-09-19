package com.benzourry.cardagg

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class AppApplication

fun main(args: Array<String>) {
    SpringApplication.run(AppApplication::class.java, *args)
}
