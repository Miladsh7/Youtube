package com.miladsh7.youtube.home


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miladsh7.youtube.databinding.ItemVideoBinding
import com.miladsh7.youtube.model.VideoItem

class VideoAdapter(
    private var context: HomeFragment,
    private var video: List<VideoItem>,

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

    }

    override fun getItemCount(): Int {
        return video.size
    }

    inner class VideoViewHolder(private var videoBinding: ItemVideoBinding) :
        RecyclerView.ViewHolder(videoBinding.root) {

        fun bindVideo(videoItem: VideoItem) {
            videoBinding.apply {

                txtTitle.text = videoItem.title
                txtView.text = videoItem.view


            }
        }


    }


}