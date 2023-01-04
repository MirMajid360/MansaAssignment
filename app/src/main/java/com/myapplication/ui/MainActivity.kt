package com.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieassignment.AdapterNumbers
import com.myapplication.R
import com.myapplication.databinding.ActivityMainBinding
import com.myapplication.models.NumberModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var list=ArrayList<NumberModel>()
    lateinit var adapterNumbers:AdapterNumbers
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        feedData()
        initAdapter()
    }

    private fun initAdapter() {
         adapterNumbers= AdapterNumbers(list,object :AdapterNumbers.IClickListener{
             override fun onItemClicked(pos: Int) {

                 binding.printValue.text=""+list.get(pos).value
             }

         })

        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        binding.recyclerView.adapter=adapterNumbers


    }

    private fun feedData() {
        for(i in 1..100)
        {
            var model=NumberModel()
            model.value=0
            list.add(model)

        }
    }
}