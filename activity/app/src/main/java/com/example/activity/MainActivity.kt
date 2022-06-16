package com.example.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity () { override fun onCreate(savedInstanceState : Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView (binding.root)

    val reqLauncher = registerForActivityResult(
        ActivityResultContracts. StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            Log.d("TAG", "return")
            val intent = result.data
            val clickedBtn: String? = intent?.getStringExtra("res")
            "btn: $clickedBtn".also { binding.txtMainView1.text = it }
        }
    }
        binding.btnSub.setOnClickListener {
            val intent: Intent = Intent(this, SubActivity::class.java).apply {
                putExtra("next", "level")
            }
            intent.putExtra("num", 30)
            intent.putExtra("edit", binding.editTxt.text.toString())
            reqLauncher.launch(intent)
//            startActivity(intent)
        }
    }
}