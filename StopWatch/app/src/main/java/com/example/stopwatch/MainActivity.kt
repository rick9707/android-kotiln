package com.example.stopwatch

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.view.inputmethod.InputBinding
import com.example.stopwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var strArray = Array<String>(5){""}
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calenderView.visibility = View.INVISIBLE
        binding.timepicker.visibility = View.INVISIBLE
        binding.rdoTime.visibility=View.INVISIBLE
        binding.rdoCal.visibility = View.INVISIBLE
        binding.rdoCal.setOnClickListener {
            binding.calenderView.visibility = View.VISIBLE
            binding.timepicker.visibility = View.INVISIBLE
        }
        binding.rdoTime.setOnClickListener{
            binding.calenderView.visibility=View.INVISIBLE
            binding.timepicker.visibility = View.VISIBLE
        }
        binding.chrono.setOnClickListener{
            binding.chrono.base = SystemClock.elapsedRealtime()
            binding.chrono.start()
            binding.chrono.setTextColor(Color.RED)
            binding.rdoTime.visibility=View.VISIBLE
            binding.rdoCal.visibility = View.VISIBLE
        }
        binding.res.setOnClickListener{
            binding.chrono.stop()
            binding.calenderView.visibility = View.INVISIBLE
            binding.timepicker.visibility = View.INVISIBLE
            binding.rdoTime.visibility=View.INVISIBLE
            binding.rdoCal.visibility = View.INVISIBLE
            binding.chrono.setTextColor(Color.BLUE)
            binding.res.text=getString(R.string.done,strArray[0],strArray[1],strArray[2],strArray[3],strArray[4])
        }
//        binding.btnEnd.setOnClickListener{
//            binding.chrono.stop()
//            binding.chrono.setTextColor(Color.BLUE)
//            binding.res.text=getString(R.string.done,strArray[0],strArray[1],strArray[2],strArray[3],strArray[4])
//        }
        binding.calenderView.setOnDateChangeListener{ calendarView,year, month, day ->
            strArray[0]= year.toString()
            strArray[1] = (month+1).toString()
            strArray[2] = day.toString()
        }
        binding.timepicker.setOnTimeChangedListener{timepicker, hour, min ->
            strArray[3] = hour.toString()
            strArray[4] = min.toString()
        }
    }
}