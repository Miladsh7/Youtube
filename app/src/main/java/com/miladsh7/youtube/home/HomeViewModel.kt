package com.miladsh7.youtube.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miladsh7.youtube.model.VideoItem
import com.miladsh7.youtube.repo.BannerRepository
import com.miladsh7.youtube.repo.BestRepository
import com.miladsh7.youtube.repo.SpecialRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bannerRepository: BannerRepository,
    private val specialRepository: SpecialRepository,
    private val bestRepository: BestRepository
) : ViewModel() {

    private var _bannersLiveData = MutableLiveData<List<VideoItem>>()
    val bannerLiveData: LiveData<List<VideoItem>>
        get() = _bannersLiveData

    private var _specialLiveData = MutableLiveData<List<VideoItem>>()
    val specialLiveData: LiveData<List<VideoItem>>
        get() = _specialLiveData

    private var _bestLiveData = MutableLiveData<List<VideoItem>>()
    val bestLiveData: LiveData<List<VideoItem>>
        get() = _bestLiveData


    init {
        viewModelScope.launch(Dispatchers.IO) {
            bannerRepository.getBanner().let {
                _bannersLiveData.postValue(it)
            }
        }

        viewModelScope.launch(Dispatchers.IO) {
            specialRepository.getSpecialVideo().let {
                _specialLiveData.postValue(it)
            }
        }

        viewModelScope.launch(Dispatchers.IO) {
            bestRepository.getBestVideo().let {
                _bestLiveData.postValue(it)

            }
        }
    }
}