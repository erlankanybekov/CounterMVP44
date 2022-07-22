package com.example.countermvp.view

import android.content.Context
import android.graphics.Color
import android.widget.Toast

interface CounterView {

    fun updateCount(count: Int)
    fun attachView(counterView: CounterView)
    fun changeTextColor()
    fun ShortToast()


}