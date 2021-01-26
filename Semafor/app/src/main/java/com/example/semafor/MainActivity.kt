package com.example.semafor

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import java.util.*

class MainActivity : Activity() {
    var imSemaphor: ImageView? = null
    var counter:Int = 0
    var timer:Timer? = null
    var is_run = false
    var imageArray:IntArray = intArrayOf(R.drawable.semafor_red,R.drawable.semafor_yellow,R.drawable.semafor_green)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imSemaphor=findViewById(R.id.imSemafor)
    }
    fun onClickStartStop(view: View)
    {
        view as ImageView
        if (!is_run){

            StartStop()
            view.setImageResource(R.drawable.button_stop)
            is_run=true
        }
        else{
            imSemaphor?.setImageResource(R.drawable.semafor_grey)
            view.setImageResource(R.drawable.button_start)
            timer?.cancel()
            is_run=false
            counter = 0
        }
    }
    fun StartStop()
    {   timer=Timer()
        timer?.schedule(object :TimerTask(){
            override fun run() {
                runOnUiThread {
                    imSemaphor?.setImageResource(imageArray[counter])
                    counter++
                    if (counter == 3) counter = 0
                }
            }

        },0,1000)
    }
}