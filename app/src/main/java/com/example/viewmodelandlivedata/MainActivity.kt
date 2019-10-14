package com.example.viewmodelandlivedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var counterViewModel: CounterViewModel

    private lateinit var counterLiveData: CounterLiveData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        counterViewModel = ViewModelProviders.of(this).get(CounterViewModel::class.java)

        counterLiveData = ViewModelProviders.of(this).get(CounterLiveData::class.java)
        counterLiveData.counter.observe(this, Observer { conut ->
            setNumber(conut)
        })
//        setNumber(counterViewModel.count)

        btnCount.setOnClickListener {
            //            counterViewModel.count = counterViewModel.count + 1
//            setNumber(counterViewModel.count)
            counterLiveData.counter.value = counterLiveData.counter.value?.plus(1)
        }
    }

    private fun setNumber(count: Int) {
        textCount.text = count.toString()
    }
}
