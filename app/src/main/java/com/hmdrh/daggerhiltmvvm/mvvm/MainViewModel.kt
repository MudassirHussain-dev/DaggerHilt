package com.hmdrh.daggerhiltmvvm.mvvm

import androidx.lifecycle.*
import com.hmdrh.daggerhiltmvvm.models.GSRegister
import com.hmdrh.daggerhiltmvvm.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val myRepository: MyRepository, private val savedStateHandle: SavedStateHandle) : ViewModel() , LifecycleObserver {

    val vm_ResponseRegister: MutableLiveData<Response<GSRegister>> = MutableLiveData()

     fun Register(UserName: String, Email: String, Password: String) {
        viewModelScope.launch {
            val response = myRepository.Register(UserName, Email, Password)
            vm_ResponseRegister.value = response
        }
    }
}