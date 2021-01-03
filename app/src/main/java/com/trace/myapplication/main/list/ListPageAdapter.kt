package com.trace.myapplication.main.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trace.myapplication.R

class ListPageAdapter(private val context: Context): RecyclerView.Adapter<ListPageViewHolder>(){
    //private lateinit var binding: ActivityMainBinding
    var datas= mutableListOf<ListPageData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_listpage,parent,false)
        return ListPageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: ListPageViewHolder, position: Int) {
        holder.bind(datas[position])
    }

}