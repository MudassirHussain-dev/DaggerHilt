package com.hmdrh.daggerhiltmvvm.mvvm

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.hmdrh.daggerhiltmvvm.repository.MyRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    owner: SavedStateRegistryOwner,
    val myRepository: MyRepository, defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(myRepository,handle) as T
        }
        throw IllegalArgumentException("wrong ViewModel class")
     //   return MainViewModel(myRepository, handle) as T
    }

/*class MainViewModelFactory( val myRepository: MyRepository):ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //return MainViewModel(myRepository) as T
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(myRepository) as T
        }
        throw IllegalArgumentException("wrong ViewModel class")
    }*/





    //Demo Test pending
 /*   class MainViewModelFactory @Inject constructor(  owner: SavedStateRegistryOwner,
    private val repository: Repository,
    defaultArgs: Bundle? = null
    ) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
        override fun <T : ViewModel> create(
            key: String, modelClass: Class<T>, handle: SavedStateHandle
        ): T {
            return MyViewModel(
                repository, handle
            ) as T
        }*/
}