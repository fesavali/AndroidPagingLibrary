package com.afzaalahmadzeeshan.android.paging.data

import androidx.room.Database
import androidx.room.RoomDatabase

import com.savalicodes.paginglibrary.models.Contact

@Database(entities = arrayOf(Contact::class), version = 1)
abstract class ContactDatabase: RoomDatabase() {
    abstract fun contactDao(): ContactDao
}