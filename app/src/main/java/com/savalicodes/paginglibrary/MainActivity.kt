package com.savalicodes.paginglibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.savalicodes.paginglibrary.utils.CountriesDb

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CountriesDb.initialize(this)
    }
}