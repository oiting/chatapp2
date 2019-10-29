package com.example.lime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        toolbar.title = "聊天"
//        toolbar.inflateMenu(R.menu.menu)

        val adapter = FragmentAdapter(supportFragmentManager)
        viewPager.adapter = adapter
        bottomNavigation.setOnNavigationItemSelectedListener {
            viewPager.currentItem = it.order
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
//        return super.onCreateOptionsMenu(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menuEdit -> {
                startActivity(Intent(this, EditActivity::class.java))
            }
            R.id.menuRead -> {
                AlertDialog.Builder(this)
                    .setMessage("要不要已讀拉")
                    .setPositiveButton("要拉幹") { dialog, which ->
                        Data.list.forEach { it.unread = 0 }
                        val fragment =
                            supportFragmentManager.findFragmentByTag("android:switcher:" + R.id.viewPager + ":" + viewPager.currentItem)
                        (fragment as FragmentChat).onResume()
                    }
                    .setNegativeButton("NNOOOOOOOOOOOOOOOOO") { dialog, which ->
                        dialog.dismiss()
                    }
                    .show()
            }
            R.id.menuSort -> {
                val arr = arrayOf("收到的時間", "未讀訊息", "我的最愛")
                val fragment =
                    supportFragmentManager.findFragmentByTag("android:switcher:" + R.id.viewPager + ":" + viewPager.currentItem)
                AlertDialog.Builder(this)
                    .setItems(arr) { dialog, which ->
                        when (arr[which]) {
                            "收到的時間" -> {
                                Data.list.sortWith(compareBy({ it.time }, { it.unread }))
                                Data.list.sortBy { it.time }
                                (fragment as FragmentChat).onResume()
                            }
                            "未讀訊息" -> {
                                Data.list.sortBy { it.unread }
                                (fragment as FragmentChat).onResume()
                            }
                        }
                    }
                    .show()

            }
        }
        return super.onOptionsItemSelected(item)
    }
}
