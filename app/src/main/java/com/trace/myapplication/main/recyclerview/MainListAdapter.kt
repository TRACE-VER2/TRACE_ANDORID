package com.trace.myapplication.main.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trace.myapplication.R
import com.trace.myapplication.databinding.ActivityLoginBinding
import com.trace.myapplication.databinding.ActivityMainBinding
import com.trace.myapplication.databinding.FragmentKingoFirstBinding

class MainListAdapter(private val context: Context): RecyclerView.Adapter<MainListViewHolder>(){
    //private lateinit var binding: ActivityMainBinding
    var datas= mutableListOf<MainListData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_mainlist,parent,false)
        return MainListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        holder.bind(datas[position])
    }

}