package com.savalicodes.paginglibrary

import android.util.Log
import androidx.paging.PagedList
import com.savalicodes.paginglibrary.models.Country

class CountriesBoundaryCallback : PagedList.BoundaryCallback<Country>() {
    private val TAG: String = "CountriesBoundaryCallback"

    override fun onZeroItemsLoaded() {
        Log.i(TAG, "onZeroItemsLoaded")
    }

    override fun onItemAtFrontLoaded(itemAtFront: Country) {
        Log.i(TAG, "onItemAtFrontLoaded")
    }

    override fun onItemAtEndLoaded(itemAtEnd: Country) {
        Log.i(TAG, "onItemAtEndLoaded")
    }
}