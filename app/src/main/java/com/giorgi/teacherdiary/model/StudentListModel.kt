package com.giorgi.teacherdiary.model

import androidx.room.ColumnInfo
import java.io.Serializable

// we must request only 3 columns in the Entity Studentinfo

data class StudentListModel (

    var studentName: String,

    var whichClass: Int,

    var telNumber: Int,

        ) : Serializable