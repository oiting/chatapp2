package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_fragment_dialog.*
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 */
class fragment_dialog : Fragment() {

    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_fragment_dialog, container, false)
        for (i in 0 until 49) {
            val content = Content(
                "${"音樂教室" + Random.nextInt(1, 50)}",
                "${"dialog" + Random.nextInt(1, 50)}",
                R.drawable.ic_music_note_black_24dp,
                " ${String.format("%02d", Random.nextInt(0,23))}:${ String.format("%02d",Random.nextInt(0,60))}",
                Random.nextInt(1, 100)
            )


            list.add(content)
        }
        setHasOptionsMenu(true)//有使用到toolbar,action bar
        return rootView

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

    }


    val adapter = Dadapter(list)
    val list_item = arrayOf("收到的時間", "未讀訊息")

    override fun onResume() {   //更新fragment畫面
        adapter.notifyDataSetChanged()
        super.onResume()//保留原onResume功能
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.arrange -> {
                AlertDialog.Builder(context!!)

                    .setItems(list_item) { _, i ->
                        if (list_item[i] == list_item[0]) {
                            list.sortBy { it.time }
                            adapter.notifyDataSetChanged()

                        } else {
                            list.sortBy { it.number }
                            adapter.notifyDataSetChanged()

                        }
                    }
                    .show()
            }

            //itemlist.sortwith(comby({it.time},{}) 按先後排序
            //      Toast.makeText(this, "你選的是" + list_item[i], Toast.LENGTH_SHORT).show()
            //   }.show()
            R.id.read -> {
                AlertDialog.Builder(context!!)
                    .setTitle("要將所有訊息標示為已讀嗎?")
                    .setNeutralButton("取消", null)
                    .setPositiveButton("標為已讀") { _, _ ->
                        for (o in 0 until list.size) {
                            list[o].number = 0

                            adapter.notifyDataSetChanged()//更新


                        }
                    }.show()
            }
            R.id.edit ->
                startActivityForResult(Intent(context, Main2Activity::class.java), 1)

        }
        ; return super.onOptionsItemSelected(item)


    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.main, menu)
    }


}




