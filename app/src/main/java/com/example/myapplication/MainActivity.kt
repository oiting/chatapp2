package com.example.myapplication

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialogimage.*
import kotlinx.android.synthetic.main.dialogimage.view.*
import kotlinx.android.synthetic.main.fragment_fragment_dialog.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    val fragmentDialog=fragment_dialog()
//若不先定變數,把實例化放在replace方法裡,會使每一次呼叫都產生新的fragment
    val mOnNavigationSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.article -> {
                    replaceFragment(fragment_article())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.friend -> {
                    replaceFragment(fargment_friend())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.today -> {
                    replaceFragment(fragment_today())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.dialog -> {
                    replaceFragment(fragmentDialog)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.wallet -> {
                    replaceFragment(fragment_wallet())
                    return@OnNavigationItemSelectedListener true
                }

            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationSelectedListener)


    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentcontainer, fragment).commit()

    }


}






