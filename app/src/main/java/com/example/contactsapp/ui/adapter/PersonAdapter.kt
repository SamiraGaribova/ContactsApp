package com.example.contactsapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsapp.data.entity.Persons
import com.example.contactsapp.databinding.CardDesignBinding
import com.example.contactsapp.ui.fragments.HomeFragmentDirections
import com.google.android.material.snackbar.Snackbar

class PersonAdapter(var mContext: Context,var personsList:List<Persons>)
    : RecyclerView.Adapter<PersonAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var binding:CardDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding = CardDesignBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val person = personsList.get(position)
        val b = holder.binding

        b.textViewPersonInfo.text = "${person.name} - ${person.phone}"

        b.cardViewPerson.setOnClickListener {
            val transition = HomeFragmentDirections.toDetail(person = person)
            Navigation.findNavController(it).navigate(transition)
        }

        b.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"Do you want to delete ${person.name} ?",Snackbar.LENGTH_LONG)
                .setAction("YES"){
                    delete(person.id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return personsList.size
    }

    fun delete(id:Int){
       Log.e("Person Delete",id.toString())
    }
}

