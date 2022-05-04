package com.example.week8

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import com.example.week8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPref= getPreferences(Context.MODE_PRIVATE)
        var sharedPref2 = getSharedPreferences("Pref_test1", Context.MODE_PRIVATE)
        sharedPref.edit(){
            putBoolean("HI", true)
            putString("Store","Emart everyday")
            putInt("Number", 10)
            apply()
        }
        sharedPref2.edit(){
            putBoolean("HI", true)
            putString("Store","Daiso")
            putInt("Number", 5)
            apply()
        }
    }
}