package com.example.rikandmorti

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import com.example.rikandmorti.databinding.ViewCharactersBinding
import javax.net.ssl.SSLSessionBindingEvent

class CharacterAdapter(private val data:ArrayList<Character>, val listener:CharacterListener) :
    RecyclerView.Adapter<CharacterAdapter.ViewHolderCharacter>() {

    inner class ViewHolderCharacter(private val binding: ViewCharactersBinding) :
        RecyclerView.ViewHolder(binding.root){
            fun bind(character: Character, listener: CharacterListener){
                itemView.setOnClickListener(){
                    listener.OnClickCharacter(character)
                }
                val item = data[adapterPosition]
                binding.image.setImageResource(item.imagew)
                binding.isAlive.text = item.isAlive
                binding.nameSurname.text = item.name
            }
        }
    interface CharacterListener{
        fun OnClickCharacter(character: Character)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCharacter {
        return ViewHolderCharacter(ViewCharactersBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolderCharacter, position: Int) {
        holder.bind(data[position],listener)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}