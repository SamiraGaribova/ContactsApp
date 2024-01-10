package com.example.contactsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.contactsapp.R
import com.example.contactsapp.data.entity.Persons
import com.example.contactsapp.databinding.FragmentDetailBinding
import com.example.contactsapp.databinding.FragmentHomeBinding
import com.example.contactsapp.ui.adapter.PersonAdapter

class HomeFragment : Fragment() , SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.toolbarHome.title = "Contacts"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarHome)

        binding.rv.layoutManager = LinearLayoutManager(requireContext())

        val personsList = ArrayList<Persons>()
        val p1 = Persons(1,"Ahmet","1111")
        val p2 = Persons(2,"Zeynep","2222")
        val p3 = Persons(3,"Beyza","3333")
        personsList.add(p1)
        personsList.add(p2)
        personsList.add(p3)

        val adapter = PersonAdapter(requireContext(),personsList)
        binding.rv.adapter = adapter

        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)

                val item = menu.findItem(R.id.action_search)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@HomeFragment)
            }
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        },viewLifecycleOwner,Lifecycle.State.RESUMED)

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.toSave)
        }

        return binding.root
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        search(newText)
        return true
    }

    fun search(searchKeyword:String){
        Log.e("Person Search",searchKeyword)
    }
}