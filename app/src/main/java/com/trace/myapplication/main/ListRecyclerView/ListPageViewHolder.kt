package com.trace.myapplication.main.ListRecyclerView

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.trace.myapplication.R
import com.trace.myapplication.databinding.FragmentListBinding
import com.trace.myapplication.databinding.FragmentMainBinding
import com.trace.myapplication.main.mainRecyclerview.MainListData

class ListPageViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
    private lateinit var binding: FragmentListBinding
    val rv_address=itemView.findViewById<TextView>(R.id.item_tv_adress)

    val rv_star1=itemView.findViewById<ImageView>(R.id.img_star_1st)
    val rv_star2=itemView.findViewById<ImageView>(R.id.img_star_2nd)
    val rv_star3=itemView.findViewById<ImageView>(R.id.img_star_3rd)
    val rv_star4=itemView.findViewById<ImageView>(R.id.img_star_4th)
    val rv_star5=itemView.findViewById<ImageView>(R.id.img_star_5th)

    var stars = mutableListOf<ImageView>(rv_star1,rv_star2,rv_star3,rv_star4,rv_star5)

    fun bind(listPageData: ListPageData){
        rv_address.text=listPageData.address
        for (i in 0..4){
            if (listPageData.star-1>=i){
                stars[i].setImageResource(R.drawable.star_yes)
            }
            else{
                stars[i].setImageResource(R.drawable.star_blank)
            }
        }

    }

}
