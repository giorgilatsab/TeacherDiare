package com.giorgi.teacherdiary.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "student_info")
data class StudentInfo(
    @PrimaryKey(autoGenerate = false)

    @ColumnInfo
    var studentName: String,

    @ColumnInfo
    var telNumber: Int,

    @ColumnInfo
    var subject: String,

    @ColumnInfo
    var lessonsWeek: Int,

    @ColumnInfo
    var whichClass: Int,

    @ColumnInfo
    var price: Int,

    @ColumnInfo
    var lessonsStile: Boolean = false,

)