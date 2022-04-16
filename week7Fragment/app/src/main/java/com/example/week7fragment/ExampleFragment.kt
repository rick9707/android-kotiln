package com.example.week7fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.week7fragment.databinding.ExamplefragmentBinding

class ExampleFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ExamplefragmentBinding.inflate(inflater, container, false).root
    }
}