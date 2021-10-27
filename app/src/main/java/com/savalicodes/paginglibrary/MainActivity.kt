package com.savalicodes.paginglibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.savalicodes.paginglibrary.models.Country
import com.savalicodes.paginglibrary.utils.CountriesDb

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CountriesDb.initialize(this)

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