package com.miladsh7.youtube.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miladsh7.youtube.databinding.ItemVideoBinding
import com.miladsh7.youtube.model.VideoItem

class VideoAdapter(
    private var context: Context,
    private var video: MutableList<VideoItem>,
    private var channel: MutableList<Channel>
) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(
            ItemVideoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bindVideo(video[position])
        holder.bindChannel(channel[position])
    }

    override fun getItemCount(): Int {
        return video.size
    }

    inner class VideoViewHolder(private var videoBinding: ItemVideoBinding) :
        RecyclerView.ViewHolder(videoBinding.root) {

        fun bindVideo(videoItem: VideoItem) {
            videoBinding.apply {
                txtTitleVideo.text = videoItem.title
                Glide.with(context).load(videoItem.icon).into(imgVideo)

                imgMoreItem.setOnClickListener {


                }
            }
        }

        fun bindChannel(channel: Channel) {
            videoBinding.apply {
                txtTitleChannel.text = channel.titleChannel
                Glide.with(context).load(channel.imageChannel).into(imgChannel)
            }
        }

    }
}