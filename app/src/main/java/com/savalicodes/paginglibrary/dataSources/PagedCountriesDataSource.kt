package com.savalicodes.paginglibrary.dataSources

import android.text.PrecomputedText
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.savalicodes.paginglibrary.CountriesBoundaryCallback
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
        Log.i(TAG, "loadAfter called with key ${params.key}")
        val list = source.filter { country -> country.page == params.key  }
        Log.i(TAG, "loadAfter returning list for page ${params.key} with ${list.size} items..")
        callback.onResult(list, params.key +1)
    }

}
class PagedCountriesDataSourceFactory : DataSource.Factory<Int, Country>() {
    var dataSource = MutableLiveData<PagedCountriesDataSource>()
    lateinit var latestSource: PagedCountriesDataSource
    override fun create(): DataSource<Int, Country> {
        latestSource = PagedCountriesDataSource()
        dataSource.postValue(latestSource)

        return latestSource
    }

//    fun toLiveData(
//        config: PagedList.Config,
//        b: Boolean,
//        countriesBoundaryCallback: CountriesBoundaryCallback
//    ): LiveData<PagedList<Country>> {
//
//    }

}