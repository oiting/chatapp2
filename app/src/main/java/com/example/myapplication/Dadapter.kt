package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Dadapter(val contentList: List<Content>) : RecyclerView.Adapter<Dadapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Dadapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dialogimage, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount() = this.contentList.count()


    override fun onBindViewHolder(holder: Dadapter.ViewHolder, position: Int) {
        holder.bind(contentList[position])

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.name)
        val chatcontent = itemView.findViewById<TextView>(R.id.chatcontent)
        val image = itemView.findViewById<ImageView>(R.id.image)
        val time = itemView.findViewById<TextView>(R.id.time)
        var number2 = itemView.findViewById<TextView>(R.id.number2)

        fun bind(content: Content) {
            name.setText(content.name)
            chatcontent.setText(content.chatcontent)
            image.setImageResource(content.image)
            time.text = content.time
            number2.text = content.number.toString()


            if (number2.text == "0") {
                number2.visibility = View.INVISIBLE
            } else {
                number2.text = content.number.toString()
            }
        }


    }

}






