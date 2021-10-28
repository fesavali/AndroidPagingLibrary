package com.savalicodes.paginglibrary

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.savalicodes.paginglibrary.dataSources.PagedCountriesDataSourceFactory
import com.savalicodes.paginglibrary.models.Contact
import com.savalicodes.paginglibrary.models.Country

class MainActivityViewModel : ViewModel() {

    val pageSize = 15
    var config = PagedList.Config.Builder()
        .setPageSize(pageSize)
        .setInitialLoadSizeHint(15)
        .setPrefetchDistance(5)
        .setEnablePlaceholders(false)
        .build()
    var dataSource = PagedCountriesDataSourceFactory()

    var countries : LiveData<PagedList<Country>> = LivePagedListBuilder(dataSource, config)
        .setBoundaryCallback(CountriesBoundaryCallback())
        .build()

//
//    use this when using paging.runtime-kxt on gradle
//    var countries : LiveData<PagedList<Country>> = dataSource
//        .toLiveData(config,
//        false,
//        CountriesBoundaryCallback()
//    )
//using dao
//class MainActivityViewModel(db: ContactDatabase): ViewModel() {
//    val pageSize = 15
//    var config = PagedList.Config.Builder()
//        .setPageSize(pageSize)
//        .setInitialLoadSizeHint(15)
//        .setPrefetchDistance(5)
//        .setEnablePlaceholders(false)
//        .build()
//    var dataSource = db.contactDao()
//
//        var countries : LiveData<PagedList<Contact>> = LivePagedListBuilder(dataSource, config)
//        .setBoundaryCallback(ContactsBoundaryCallback)
//        .build()

//    var contacts: LiveData<PagedList<Contact>> = dataSource.getContacts()
//        .toLiveData(config,
//            null,
//            ContactsBoundaryCallback()
//        )

}