package com.example.countermvp

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.countermvp.databinding.ActivityMainBinding
import com.example.countermvp.presenter.Presenter
import com.example.countermvp.view.CounterView
import java.util.concurrent.CountDownLatch

class MainActivity : AppCompatActivity(),CounterView {


    lateinit var binding: ActivityMainBinding

    val presenter = Injector.getPresenter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.attachView(this)

        initClickers()

    }

    private fun initClickers(){
        with(binding){
            btnIncrease.setOnClickListener {
                presenter.increment()
                presenter.reaction()
            }

            btnDecrease.setOnClickListener {
                presenter.decrement()
            }


        }
    }

    override fun updateCount(count: Int) {
        binding.txtCount.text = count.toString()
    }

    override fun attachView(counterView: CounterView) {

    }

    override fun changeTextColor() {
        binding.txtCount.setTextColor(Color.GREEN)
    }

    override fun ShortToast(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }


}