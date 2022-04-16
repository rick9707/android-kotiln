package com.example.week7fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.week7fragment.databinding.ExamplefragmenttwoBinding

class ExampleFragmentTwo : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ExamplefragmenttwoBinding.inflate(inflater, container, false).root
    }
}

