package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var num1:Int
        var num2:Int
        var result:Int
        binding.B0.setOnClickListener(this)
        binding.B1.setOnClickListener(this)
        binding.B2.setOnClickListener(this)
        binding.B3.setOnClickListener(this)
        binding.B4.setOnClickListener(this)
        binding.B5.setOnClickListener(this)
        binding.B6.setOnClickListener(this)
        binding.B7.setOnClickListener(this)
        binding.B8.setOnClickListener(this)
        binding.B9.setOnClickListener(this)

        binding.add.setOnClickListener{
            try {
                num1 = binding.num1.text.toString().toInt()
                num2 = binding.num2.text.toString().toInt()
                result = num1 + num2
                binding.result.text = getString(R.string.results, result.toString())
            }catch (e: NumberFormatException) {
                Toast.makeText(applicationContext, "숫자를 입력하세요", Toast.LENGTH_SHORT).show()
            }
        }
        binding.sub.setOnClickListener{
            try {
                num1 = binding.num1.text.toString().toInt()
                num2 = binding.num2.text.toString().toInt()
                result = num1 - num2
                binding.result.text = getString(R.string.results, result.toString())
            }catch (e: NumberFormatException) {
                Toast.makeText(applicationContext, "숫자를 입력하세요", Toast.LENGTH_SHORT).show()
            }
        }
        binding.mul.setOnClickListener{
            try {
                num1 = binding.num1.text.toString().toInt()
                num2 = binding.num2.text.toString().toInt()
                result = num1 * num2
                binding.result.text = getString(R.string.results, result.toString())
            }catch (e: NumberFormatException) {
                Toast.makeText(applicationContext, "숫자를 입력하세요", Toast.LENGTH_SHORT).show()
            }
        }
        binding.div.setOnClickListener{
            try {
                num1 = binding.num1.text.toString().toInt()
                num2 = binding.num2.text.toString().toInt()
                result = num1 / num2
                binding.result.text = getString(R.string.results, result.toString())
            }catch (e: NumberFormatException) {
                Toast.makeText(applicationContext, "숫자를 입력하세요", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if(currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onClick(V: View?) {
        var input:String = (V as Button).text.toString()
        if(binding.num1.isFocused){
            input = binding.num1.text.toString() + input
            binding.num1.setText(input)
        }
        else if(binding.num2.isFocused){
            input = binding.num2.text.toString() + input
            binding.num2.setText(input)
        }
        else{
            Toast.makeText(applicationContext,"Please Click",Toast.LENGTH_SHORT).show()
        }
    }


}