package com.example.lime

import kotlin.random.Random

data class Person(
    val id: Int,
    val name: String,
    val message: String,
    val time: String,
    var unread: Int,
    var isSelected: Boolean = false
)

class Data {
    companion object {
        val list = mutableListOf<Person>()
        fun generate() {
            var size = (Math.random() * 100).toInt()
            while (size < 50) size = (Math.random() * 100).toInt()
            for (i in 0..size) {
                val hour = Random.nextInt(23)
                val min = Random.nextInt(60)
//                var hour = (Math.random() * 10).toInt()
//                var min = (Math.random() * 10).toInt()
                var unread = (Math.random() * 10000).toInt() - 4000
                if (unread > 5000 || unread < 0) {
                    unread = 0
                }
                val person = Person(
                    i,
                    i.toString(),
                    i.toString(),
                    "$hour : $min",
                    unread
                )
                list.add(person)
            }
        }
    }
}