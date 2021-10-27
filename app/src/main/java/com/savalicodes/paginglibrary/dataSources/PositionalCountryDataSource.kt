package com.savalicodes.paginglibrary.dataSources

import androidx.paging.PositionalDataSource
import com.savalicodes.paginglibrary.models.Country
import com.savalicodes.paginglibrary.utils.CountriesDb

class PositionalCountryDataSource: PositionalDataSource<Country>() {
    private val TAG: String = "KeyedCountriesDataSource"
    private val source = CountriesDb.getCountries()
    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Country>) {
        TODO("Not yet implemented")
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Country>) {
        TODO("Not yet implemented")
    }
}