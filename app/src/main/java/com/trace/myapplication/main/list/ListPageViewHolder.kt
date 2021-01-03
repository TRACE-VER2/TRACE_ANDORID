package com.trace.myapplication.main.list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.trace.myapplication.R
import com.trace.myapplication.databinding.FragmentListBinding

class ListPageViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
    private lateinit var binding: FragmentListBinding
    val list_rv_address=itemView.findViewById<TextView>(R.id.list_item_tv_adress)

    val list_rv_star1=itemView.findViewById<ImageView>(R.id.list_img_star_1st)
    val list_rv_star2=itemView.findViewById<ImageView>(R.id.list_img_star_2nd)
    val list_rv_star3=itemView.findViewById<ImageView>(R.id.list_img_star_3rd)
    val list_rv_star4=itemView.findViewById<ImageView>(R.id.list_img_star_4th)
    val list_rv_star5=itemView.findViewById<ImageView>(R.id.list_img_star_5th)

    var list_stars = mutableListOf<ImageView>(list_rv_star1,list_rv_star2,list_rv_star3,list_rv_star4,list_rv_star5)

    fun bind(listPageData: ListPageData){
        list_rv_address.text=listPageData.address
        for (i in 0..4){
            if (listPageData.star-1>=i){
                list_stars[i].setImageResource(R.drawable.star_yes)
            }
            else{
                list_stars[i].setImageResource(R.drawable.star_blank)
            }
        }

    }

}
