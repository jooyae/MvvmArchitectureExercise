package com.example.mvvmexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmexercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this@MainActivity
        setRcv()
        setObserv()
    }

    fun btnClick(view : View) {
        Toast.makeText(this, "Button Click", Toast.LENGTH_SHORT).show()
    }

    fun setRcv() {
        val profileAdapter = ProfileAdapter(this)
        binding.mainRcv.layoutManager = LinearLayoutManager(this)
        binding.mainRcv.adapter = profileAdapter
        profileAdapter.data = listOf(
                ProfileData("@drawable/ic_home_img_step_five",name = "PARK", age = 4),
                ProfileData("@drawable/ic_home_img_step_three",name = "JuYae", age = 24)
        )
        profileAdapter.notifyDataSetChanged()
    }

    fun setObserv() {
        var item : ObservableData = ObservableData()
        item.site = "Apple"
        binding.site = item
        Handler().postDelayed(Runnable {
            run{
                item.site = "Google"
            }
        },3000)

    }
}