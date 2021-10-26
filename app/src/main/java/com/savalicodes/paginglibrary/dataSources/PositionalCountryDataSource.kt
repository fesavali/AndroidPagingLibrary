package com.savalicodes.paginglibrary.dataSources

import androidx.paging.PositionalDataSource
import com.savalicodes.paginglibrary.models.Country

class PositionalCountryDataSource: PositionalDataSource<Country>() {
    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Country>) {
        TODO("Not yet implemented")
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Country>) {
        TODO("Not yet implemented")
    }
}