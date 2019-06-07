package com.example.codechallenge060619.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codechallenge060619.R
import com.example.codechallenge060619.Util
import com.example.codechallenge060619.network.ImgDetail
import kotlinx.android.synthetic.main.card_layout.view.*

class CustomAdapter(private val imgDetailList: List<ImgDetail>,val context: Context) :
    RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val card = layoutInflater.inflate(R.layout.card_layout, parent, false)
        return CustomViewHolder(card)
    }

    override fun getItemCount(): Int {
        return imgDetailList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.tvId.text = imgDetailList[position].id.toString()
        holder.itemView.setOnClickListener{
            startDetailActivity(imgDetailList[position])
        }
    }


    fun startDetailActivity(imgDetail: ImgDetail){
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(Util.IMG_DETAIL, imgDetail)
        context.startActivity(intent)
    }



    class CustomViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvId = view.tv_id!!
    }

}