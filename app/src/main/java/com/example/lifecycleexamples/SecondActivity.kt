package com.example.lifecycleexamples

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.lifecycleexamples.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySecondBinding
            = DataBindingUtil.setContentView(this, R.layout.activity_second)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.countLiveData.observe(this, {
            Log.v("TAG", "Data changed")
        })

        binding.buttonCount.setOnClickListener {
            viewModel.doCount()
        }

    }
}