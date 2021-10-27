package com.savalicodes.paginglibrary.dataSources

import android.text.PrecomputedText
import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.savalicodes.paginglibrary.models.Country
import com.savalicodes.paginglibrary.utils.CountriesDb

class PagedCountriesDataSource: PageKeyedDataSource<Int, Country>() {
    private val TAG: String = "PagedCountriesDataSource"
    private val source = CountriesDb.getCountries()

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Country>
    ) {
        Log.i(TAG, "loadInitialCalled")
        val pagedCountries = source.filter{ country -> country.page == 1 }
        Log.i(TAG, "loadInitial created a list of ${pagedCountries.size} size...")
        callback.onResult(pagedCountries, null, 2)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Country>) {
        Log.i(TAG, "loadBefore called with key ${params.key}")
        val list = source.filter { country -> country.page == params.key  }
        Log.i(TAG, "loadBefore returning list for page ${params.key} with ${list.size} items..")
        callback.onResult(list, params.key -1)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Country>) {
        TODO("Not yet implemented")
    }

}