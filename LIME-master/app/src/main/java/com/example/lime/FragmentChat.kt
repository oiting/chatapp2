package com.example.lime


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_chat.view.*


class FragmentChat : Fragment() {

//    companion object {
//        val list = mutableListOf<Person>()
//    }

    lateinit var rootView: View
    val adapter = ChatListAdapter(ChatListAdapter.CHAT)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_chat, container, false)

        rootView.rv_ChatList.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rootView.rv_ChatList.adapter = adapter

        Data.generate()
        adapter.update(Data.list)
        return rootView
    }

    override fun onResume() {
        super.onResume()
        adapter.update(Data.list)
    }
}
