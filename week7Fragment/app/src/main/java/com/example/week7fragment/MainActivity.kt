package com.example.week7fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import com.example.week7fragment.databinding.ActivityMainBinding
import com.example.week7fragment.databinding.FragmentlayoutBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: FragmentlayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentlayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        binding.button1.setOnClickListener { supportFragmentManager.beginTransaction()
            .replace(binding.fragView.id,ExampleFragment())
            .commit()
        }
        binding.button2.setOnClickListener { supportFragmentManager.beginTransaction()
            .replace(R.id.frag_view,ExampleFragmentTwo())
            .commit()
        }
        binding.button3.setOnClickListener { supportFragmentManager.beginTransaction()
            .replace(R.id.frag_view,ExampleFragmentThree())
            .commit()
        }
        binding.fragView.setOnClickListener{
            Toast.makeText(getApplicationContext(),"Click", Toast.LENGTH_LONG).show();
        }
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val TAG ="Debug"
//        Log.d(TAG, "Up Clicked")
////        onBackPressed()
//        return super.onSupportNavigateUp()
//    }

}