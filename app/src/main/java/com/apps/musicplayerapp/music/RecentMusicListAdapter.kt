package com.apps.newsapp.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apps.musicplayerapp.R
import com.apps.musicplayerapp.RecentMusic

import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.listitem.view.*

class RecentMusicListAdapter(private  val RecentMusicList:ArrayList<RecentMusic>): RecyclerView.Adapter<RecentMusicListAdapter.ViewHolder>() {

    class ViewHolder( itemView:View) :RecyclerView.ViewHolder(itemView){

        fun bind(RecentMusic: RecentMusic)
        {
            itemView.txtSongName.text=RecentMusic.name
            itemView.txtSongArtist.text=RecentMusic.artist
            Glide.with(itemView.imageViewAvatar.context)
                    .load(RecentMusic.imageUrl)
                    .circleCrop()
                    .into(itemView.imageViewAvatar)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).
    inflate(R.layout.listitem,parent,false))

    override fun getItemCount()=RecentMusicList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =holder.bind(RecentMusicList[position])
    fun addData(newList: List<RecentMusic>) {
        RecentMusicList.addAll(newList)
    }
}