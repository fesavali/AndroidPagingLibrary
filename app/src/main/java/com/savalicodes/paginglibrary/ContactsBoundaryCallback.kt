package com.savalicodes.paginglibrary

import android.util.Log
import androidx.paging.PagedList

import com.savalicodes.paginglibrary.models.Contact

class ContactsBoundaryCallback: PagedList.BoundaryCallback<Contact>() {
    private val TAG: String = "ContactsBoundaryCallback"

    override fun onZeroItemsLoaded() {
        Log.i(TAG, "onZeroItemsLoaded")
    }

    override fun onItemAtEndLoaded(itemAtEnd: Contact) {
        Log.i(TAG, "onItemAtEndLoaded")
    }

    override fun onItemAtFrontLoaded(itemAtFront: Contact) {
        Log.i(TAG, "onItemAtFrontLoaded")
    }
}