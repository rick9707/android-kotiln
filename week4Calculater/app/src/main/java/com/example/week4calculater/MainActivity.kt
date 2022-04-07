package com.example.week4calculater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Toast
import com.example.week4calculater.databinding.ActivityMainBinding
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        var num1:Int
        var num2:Int
        var result:Int
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.add.setOnClickListener{
            try {
            num1 = binding.num1.text.toString().toInt()
            num2 = binding.num2.text.toString().toInt()
                result = num1 + num2
                binding.result.text= getString(R.string.results,result.toString())
            } catch (e: NumberFormatException) {
                Toast.makeText(applicationContext, "숫자를 입력해주세요", Toast.LENGTH_LONG).show()
            }
        }
        binding.sub.setOnClickListener{
            try {
                num1 = binding.num1.text.toString().toInt()
                num2 = binding.num2.text.toString().toInt()
                result = num1 - num2
                binding.result.text= getString(R.string.results,result.toString())
            } catch (e: NumberFormatException) {
                Toast.makeText(applicationContext, "숫자를 입력해주세요", Toast.LENGTH_LONG).show()
            }
        }
        binding.div.setOnClickListener{
            try {
                num1 = binding.num1.text.toString().toInt()
                num2 = binding.num2.text.toString().toInt()
                if (num2 == 0) {
                    Toast.makeText(applicationContext, "ERROR", Toast.LENGTH_LONG).show()
                }
                else {
                    result = num1 / num2
                    binding.result.text= getString(R.string.results,result.toString())
                }
            } catch (e: NumberFormatException) {
                Toast.makeText(applicationContext, "숫자를 입력해주세요", Toast.LENGTH_LONG).show()
            }
        }
        binding.mul.setOnClickListener{
            try {
                num1 = binding.num1.text.toString().toInt()
                num2 = binding.num2.text.toString().toInt()
                result = num1*num2
                binding.result.text= getString(R.string.results,result.toString())
            } catch (e: NumberFormatException) {
                Toast.makeText(applicationContext, "정수를 입력해주세요", Toast.LENGTH_LONG).show()
            }
        }
    }
}

