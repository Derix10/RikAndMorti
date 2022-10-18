package com.example.rikandmorti

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.rikandmorti.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

     private lateinit var binding:FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null){
            binding.image.setImageResource(arguments?.get("key") as Int)
            binding.text.text = arguments?.get("key2").toString()
            binding.secondNameSurname.text = arguments?.get("key3").toString()
        }
    }


}