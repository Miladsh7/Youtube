package com.miladsh7.youtube.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.miladsh7.youtube.banner.BannerSliderAdapter
import com.miladsh7.youtube.common.convertDpToPixel
import com.miladsh7.youtube.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding?=null
    val binding:FragmentHomeBinding
    get() = _binding!!
    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(LayoutInflater.from(context),container,false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        homeViewModel.bannerLiveData.observe(viewLifecycleOwner){

            val bannerSliderAdapter = BannerSliderAdapter(this, it)
            _binding?.apply {
                bannerSliderViewpager.adapter = bannerSliderAdapter
                val viewPagerHeight = (((bannerSliderViewpager.measuredWidth - convertDpToPixel(
                    32f,
                    requireContext()
                )) * 103) / 234).toInt()
                bannerSliderViewpager.adapter = bannerSliderAdapter
                val layoutParams = bannerSliderViewpager.layoutParams
                layoutParams.height = viewPagerHeight
                bannerSliderViewpager.layoutParams = layoutParams

                sliderIndicator.setViewPager2(bannerSliderViewpager)
            }

        }

       

    }

}

