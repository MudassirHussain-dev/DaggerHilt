package com.hmdrh.daggerhiltmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.hmdrh.daggerhiltmvvm.databinding.ActivityMainBinding
import com.hmdrh.daggerhiltmvvm.mvvm.MainViewModel
import com.hmdrh.daggerhiltmvvm.mvvm.MainViewModelFactory
import com.hmdrh.daggerhiltmvvm.repository.MyRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var myRepository: MyRepository
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory(this, myRepository)
    }


    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {

            BackgroundSingupTask()
        }


    }

    private fun BackgroundSingupTask() {
        mainViewModel.Register(
            binding.etUserName.text.toString(),
            binding.etEmail.text.toString(),
            binding.etPassword.text.toString()
        )
        mainViewModel.vm_ResponseRegister.observe(this@MainActivity, Observer {
            Toast.makeText(this@MainActivity, "${it.body()?.message}", Toast.LENGTH_SHORT).show()
        })
    }
}