package com.savalicodes.paginglibrary.models

import androidx.room.PrimaryKey

data class Contact(
    @PrimaryKey val id: Int,
    val name: String,
)
