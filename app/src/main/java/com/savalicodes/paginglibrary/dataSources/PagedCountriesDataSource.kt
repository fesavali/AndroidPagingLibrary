package com.savalicodes.paginglibrary.dataSources

import androidx.paging.PageKeyedDataSource
import com.savalicodes.paginglibrary.models.Country

class PagedCountriesDataSource: PageKeyedDataSource<Int, Country>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Country>
    ) {
        TODO("Not yet implemented")
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Country>) {
        TODO("Not yet implemented")
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Country>) {
        TODO("Not yet implemented")
    }

}