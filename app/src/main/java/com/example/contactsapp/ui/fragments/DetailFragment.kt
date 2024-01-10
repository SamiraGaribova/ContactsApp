package com.example.contactsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.contactsapp.R
import com.example.contactsapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        binding.toolbarDetail.title = "Person Detail"

        val bundle:DetailFragmentArgs by navArgs()
        val resultPerson = bundle.person

        binding.editTextName.setText(resultPerson.name)
        binding.editTextPhone.setText(resultPerson.phone)

        binding.buttonUpdate.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val phone = binding.editTextPhone.text.toString()

            update(resultPerson.id,name,phone)
        }

        return binding.root
    }

    fun update(id:Int,name:String,phone:String){
        Log.e("Person Update","$id - $name - $phone")
    }
}