package com.giorgi.teacherdiary.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
// beafore student come to lesson
@Entity(tableName = "student_lessons_date")
data class StudLessonsDate(
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo
    var lessonTimeSave: String,

    @ColumnInfo
    var lessonDataSave: String,

    @ColumnInfo
    var studentName: String,

    @ColumnInfo
     var lessonsNumber: Int = 1
        )