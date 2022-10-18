package com.example.rikandmorti

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.rikandmorti.databinding.FragmentMainBinding

class MainFragment : Fragment() , CharacterAdapter.CharacterListener{
    private lateinit var binding: FragmentMainBinding
    private var data = ArrayList<Character>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CharacterAdapter(data,this)
        binding.recycleView.adapter = adapter
        data.add(Character("Rik Sanchez","Alive",R.drawable.rik))
        data.add(Character("Morti Smith","Alive",R.drawable.morti))
        data.add(Character("Albert Einstein", "Dead",R.drawable.scientist))
        data.add(Character("Jerry Smith", "Alive",R.drawable.man))
    }
    override fun OnClickCharacter(character: Character) {
        findNavController().navigate(R.id.secondFragment, args = bundleOf("key" to character.imagew,
            "key2" to character.isAlive, "key3" to character.name))
    }
}