package com.savalicodes.paginglibrary.dataSources

import androidx.paging.ItemKeyedDataSource
import com.savalicodes.paginglibrary.models.Country

class KeyedCountriesDataSource : ItemKeyedDataSource<Int, Country>() {
    override fun getKey(item: Country): Int {
        TODO("Not yet implemented")
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Country>
    ) {
        TODO("Not yet implemented")
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Country>) {
        TODO("Not yet implemented")
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Country>) {
        TODO("Not yet implemented")
    }
}