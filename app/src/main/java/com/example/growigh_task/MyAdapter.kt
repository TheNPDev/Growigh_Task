package com.example.growigh_task

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(val context: Context, val articleList: List<ArticleX>):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        var author:TextView
        var title: TextView
        var image : ImageView

        init {
            author  = itemView.findViewById(R.id.author)
            title = itemView.findViewById(R.id.title)
            image = itemView.findViewById(R.id.image)
        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.rowitem,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.author.text = articleList[position].author
        holder.title.text = articleList[position].title
        Glide.with(context).load(articleList[position].urlToImage).into(holder.image)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }
}