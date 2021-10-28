package com.savalicodes.paginglibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.afzaalahmadzeeshan.android.paging.data.ContactDatabase
import com.savalicodes.paginglibrary.models.Country
import com.savalicodes.paginglibrary.utils.CountriesDb

class MainActivity : AppCompatActivity() {
    private var topId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CountriesDb.initialize(this)

        val del = findViewById<Button>(R.id.delete_btn)
        del.setOnClickListener(View.OnClickListener {
            fun deleteTop(view : View){
                val viewModel = MainActivityViewModel()
                viewModel.dataSource.deleteById(topId)
                topId++
            }
        })


        // Ready the database dao
//        val db = Room.databaseBuilder(this, ContactDatabase::class.java, "contacts.sqlite")
//            .allowMainThreadQueries()
//            .build()
//        viewModel = MainActivityViewModel(db)

        val countryRV = findViewById<RecyclerView>(R.id.countrier_rv)
        val adapter = CountryAdapter()
         countryRV.layoutManager = LinearLayoutManager(this)
        countryRV.adapter = adapter

       var viewModel = MainActivityViewModel()
        viewModel.countries.observe(this, { countries->
                Log.i("Main data", "Observed ${countries.size} countries from ViewModel...")
            adapter.submitList(countries)
        })
    }

}