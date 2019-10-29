package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Dadapter2(val contentList: List<Content>) : RecyclerView.Adapter<Dadapter2.ViewHolder2>() {

    var itemClickListenerImp: ItemClickListener? = null

    interface ItemClickListener {
        fun itemClick(Content: Content)
    }

    fun setOnItemClick(itemClickListener: ItemClickListener) {
        itemClickListenerImp = itemClickListener//由Main2Activity傳進來
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Dadapter2.ViewHolder2 {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_main2, parent, false)


        return ViewHolder2(view)

    }

    override fun getItemCount() = this.contentList.count()


    override fun onBindViewHolder(holder: Dadapter2.ViewHolder2, position: Int) {
        holder.bind(contentList[position]);

    }

    inner class ViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {//class裡如果有class需要加inner才可以抓到外面class的變數
        val name = itemView.findViewById<TextView>(R.id.name2)
        val chatcontent = itemView.findViewById<TextView>(R.id.chatcontent2)
        val image = itemView.findViewById<ImageView>(R.id.image2)
        val time = itemView.findViewById<TextView>(R.id.time2)
        var number2 = itemView.findViewById<TextView>(R.id.number3)
        val checkbox = itemView.findViewById<CheckBox>(R.id.checkBox2)

        fun bind(Content: Content) {
            name.setText(Content.name)
            chatcontent.setText(Content.chatcontent)
            image.setImageResource(Content.image)
            time.text = Content.time
            number2.text = Content.number.toString()

            checkbox.isChecked = Content.ischosen

            checkbox.setOnClickListener {
                itemClickListenerImp?.itemClick(Content)
            }


        }

    }


}

