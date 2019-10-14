package com.example.viewmodelandlivedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var counterViewModel: CounterViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterViewModel = ViewModelProviders.of(this).get(CounterViewModel::class.java)
        setNumber(counterViewModel.count)
        btnCount.setOnClickListener {
            counterViewModel.count = counterViewModel.count + 1
            setNumber(counterViewModel.count)
        }
    }

    private fun setNumber(count: Int) {
        textCount.text = count.toString()
    }
}
