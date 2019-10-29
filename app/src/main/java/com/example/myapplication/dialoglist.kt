package com.example.myapplication

import kotlin.random.Random

data class Content(
    val name: String,
    val chatcontent: String,
    val image: Int,
    val time: String,
    var number: Int,
    var ischosen: Boolean = false
)
//以下建議只寫在相關的acttivity.fragment裡
val musicclass = "${"音樂教室" + Random.nextInt(1, 50)}"
val dialog = "dialog" + Random.nextInt(1, 50).toString()
val time =" ${String.format("%02d", Random.nextInt(0,23))}:${ String.format("%02d",Random.nextInt(0,60))}"

//%02d 至少兩位十進制整數
var number = Random.nextInt(1, 100)


val list = mutableListOf(
    Content(
        musicclass,
        dialog,
        R.drawable.ic_music_note_black_24dp,
        time,
        number
    )

)