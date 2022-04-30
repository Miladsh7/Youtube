package com.miladsh7.youtube.banner

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.miladsh7.youtube.model.VideoItem

class BannerSliderAdapter(fragment:Fragment,val banners:List<VideoItem>):FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
       return banners.size
    }

    override fun createFragment(position: Int): Fragment {
       return BannerFragment.newInstance(banners[position])
    }
}