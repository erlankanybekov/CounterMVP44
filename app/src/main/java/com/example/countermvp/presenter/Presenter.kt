package com.example.countermvp.presenter

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.countermvp.Injector
import com.example.countermvp.MainActivity
import com.example.countermvp.R
import com.example.countermvp.model.CounterModel
import com.example.countermvp.view.CounterView

class Presenter {

    lateinit var view:CounterView
    private   val model = Injector.getModel()

    fun increment(){
        model.increment()
        view.updateCount(model.count)

    }

    fun decrement(){
        model.decrement()
        view.updateCount(model.count)
    }


    fun attachView(counterView: CounterView){
        view = counterView
    }

    fun reaction(){
        if (model.count == 15 ){
            view.changeTextColor()
        }
        if (model.count == 10){
            view.ShortToast()
        }
    }


}