package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.edit.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit)



        setTitle("編輯聊天列表")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)//返回鍵


        val adapter = Dadapter2(list)
        recyclerView2.adapter = adapter
        recyclerView2.layoutManager = LinearLayoutManager(this)

        adapter.setOnItemClick(object : Dadapter2.ItemClickListener {
            override fun itemClick(Content: Content) {
                Content.ischosen = !Content.ischosen//若沒設置點擊會只有介面上的改變
            }
        })

        btn_remove.setOnClickListener {
            val delete = list.filter { it.ischosen == true }
            delete.forEach { list.remove(it) }
            adapter.notifyDataSetChanged()
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)

    }


}
