package com.savalicodes.paginglibrary.utils;

import androidx.room.Database
import androidx.room.RoomDatabase

import com.savalicodes.paginglibrary.models.Contact
import com.savalicodes.paginglibrary.utils.ContactDao

@Database(entities = arrayOf(Contact::class), version = 1)
abstract class ContactDatabase: RoomDatabase() {
    abstract fun contactDao(): ContactDao
}