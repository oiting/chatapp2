package com.example.lime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        toolbarDelete.title = "編輯聊天列表"
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_keyboard_arrow_left_white_24dp)

        val adapter = ChatListAdapter(ChatListAdapter.DELETE)
        adapter.update(Data.list)
        rvDelete.adapter = adapter
        rvDelete.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        adapter.setOnItemClickListener(object: ChatListAdapter.ItemClickListener {
            override fun itemClick(person: Person) {
                person.isSelected = !person.isSelected
            }

        })

        btnDelete.setOnClickListener {
            val readyToDelete = Data.list.filter { it.isSelected }
            Data.list.removeAll(readyToDelete)
            Log.d("*****", Data.list.toString())
            finish()
        }
    }
}
