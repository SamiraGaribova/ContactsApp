package com.example.contactsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contactsapp.R
import com.example.contactsapp.databinding.FragmentHomeBinding
import com.example.contactsapp.databinding.FragmentSaveBinding

class SaveFragment : Fragment() {
    private lateinit var binding: FragmentSaveBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, container, false)

        binding.toolbarSave.title = "Person Save"

        binding.buttonSave.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val phone = binding.editTextPhone.text.toString()

            save(name,phone)
        }

        return binding.root
    }

    fun save(name:String,phone:String){
        Log.e("Person Save","$name - $phone")
    }
}