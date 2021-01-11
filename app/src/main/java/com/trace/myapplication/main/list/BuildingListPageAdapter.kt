package com.trace.myapplication.main.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trace.myapplication.R

class BuildingListPageAdapter(private val context: Context): RecyclerView.Adapter<BuildingListPageViewHolder>(){
    //private lateinit var binding: ActivityMainBinding
    var datas= mutableListOf<BuildingListPageData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuildingListPageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_building_list,parent,false)
        return BuildingListPageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holderBuilding: BuildingListPageViewHolder, position: Int) {
        holderBuilding.bind(datas[position])
    }

}