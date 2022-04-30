package com.miladsh7.youtube.banner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.miladsh7.youtube.R
import com.miladsh7.youtube.common.EXTRA_KEYS_DATA
import com.miladsh7.youtube.model.VideoItem
import com.miladsh7.youtube.service.ImageLoadingService
import com.miladsh7.youtube.view.YoutubeImageView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BannerFragment : Fragment() {
    @Inject lateinit var imageLoadingService:ImageLoadingService
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val imageView =
            inflater.inflate(R.layout.fragment_banner, container, false) as YoutubeImageView
        val banner =
            requireArguments().getParcelable<VideoItem>(EXTRA_KEYS_DATA) ?: throw IllegalStateException(
                "Banner cannot be null"
            )
        imageLoadingService.load(imageView,banner.icon)
        return imageView
    }

    companion object {
        fun newInstance(videoItem: VideoItem): BannerFragment {
            return BannerFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(EXTRA_KEYS_DATA, videoItem)
                }
            }
        }
    }
}