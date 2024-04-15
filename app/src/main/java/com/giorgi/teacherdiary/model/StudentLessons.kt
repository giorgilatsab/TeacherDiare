package com.giorgi.teacherdiary.model

import androidx.room.*

//After the student arrived at the lesson

@Entity(tableName = "student_lessons")
data class StudentLessons(

    @PrimaryKey(autoGenerate = true)

    @ColumnInfo
    var lessonTime: Int,

    @ColumnInfo
    var lessonData: Int,

    @ColumnInfo
    var studentName: String,

    @ColumnInfo
    var come: Boolean = false,

    @ColumnInfo
    var lessonsNumber: Int = 1,


    )