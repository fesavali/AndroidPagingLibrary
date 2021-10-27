package com.savalicodes.paginglibrary.dataSources

import android.util.Log
import androidx.paging.ItemKeyedDataSource
import com.savalicodes.paginglibrary.models.Country
import com.savalicodes.paginglibrary.utils.CountriesDb

class KeyedCountriesDataSource : ItemKeyedDataSource<Int, Country>() {
    private val TAG: String = "PagedCountriesDataSource"
    private val source = CountriesDb.getCountries()
    override fun getKey(item: Country): Int {
        return  item.id
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Country>
    ) {
       Log.i(TAG, "loadInitial called")
        val list = mutableListOf<Country>()
        for (i in 0..params.requestedLoadSize){
            if (i > source.size){
                break
            }
            list.add(source.get(i))
        }
        Log.v(TAG, "loadInitial contains ${list.size} countries, from ${list.first().name} to ${list.last().name}")
        callback.onResult(list,0,list.size)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Country>) {
        Log.i(TAG, "loadAfter called")
        val key = params.key
        val list = mutableListOf<Country>()
        if(key == source.size){
            callback.onResult(list.orEmpty())
            return
        }
        val lastCountry = source.get(key)
        Log.i(TAG, "loadAfter reading from id $key (countryId: ${lastCountry.id}), requestedSize: ${params.requestedLoadSize}")
        for(i in lastCountry.id..(lastCountry.id + params.requestedLoadSize) ){
            if(i == list.size){
                break
            }
            list.add(source.get(i))
        }
        Log.i(TAG, "loadAfter created a list of ${list.size} size..")
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Country>) {
        TODO("Not yet implemented")
    }
}