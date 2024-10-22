package com.example.pr222

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity
data class Money(
    @PrimaryKey val id: UUID,
    var title: String = "",
    var date: Date = Date(),
    var isSolved: Boolean = false
)
