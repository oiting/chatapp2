package com.example.lime

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.view_chat.view.*
import kotlinx.android.synthetic.main.view_delete.view.*

class ChatListAdapter(val type: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val CHAT = 1
        const val DELETE = 2
    }

    var personList = listOf<Person>()
    var itemClickListenerImp: ItemClickListener? = null

    interface ItemClickListener {
        fun itemClick(person: Person)
    }

    fun setOnItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListenerImp = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (type == CHAT) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.view_chat, parent, false)
            return ViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.view_delete, parent, false)
            return DeleteViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (type == CHAT) (holder as ViewHolder).bind(personList[position])
        else (holder as DeleteViewHolder).bind(personList[position])

    }

    inner class DeleteViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imgDeleteAvatar = view.imgDeleteAvatar
        val tvDeleteName = view.tvDeleteName
        val tvDeleteMessage = view.tvDeleteMessage
        val tvDeleteTime = view.tvDeleteTime
        val cbDelete = view.cbDelete

        fun bind(person: Person) {
            tvDeleteName.text = person.name
            tvDeleteMessage.text = person.message
            tvDeleteTime.text = person.time
            cbDelete.isChecked = person.isSelected

            Glide
                .with(itemView.context)
                .load(R.drawable.avatar)
                .apply(RequestOptions.circleCropTransform())
                .into(imgDeleteAvatar)

            cbDelete.setOnClickListener {
                itemClickListenerImp?.itemClick(Data.list[adapterPosition])
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgAvatar = view.imgAvatar
        val tvName = view.tvName
        val tvMessage = view.tvMessage
        val tvTime = view.tvTime
        val tvUnread = view.tvUnread

        fun bind(person: Person) {
            tvName.text = person.name
            tvMessage.text = person.message
            tvTime.text = person.time
            tvUnread.text = if (person.unread > 999) "999+" else person.unread.toString()
            if (person.unread == 0) tvUnread.visibility = View.INVISIBLE
            else tvUnread.visibility = View.VISIBLE


            Glide
                .with(itemView.context)
                .load(R.drawable.avatar)
                .apply(RequestOptions.circleCropTransform())
                .into(imgAvatar)
        }
    }

    fun update(list: List<Person>) {
        Log.d("*****", list.toString())
        personList = list
        this.notifyDataSetChanged()
    }
}