package com.giorgi.teacherdiary.db.repository

import androidx.lifecycle.LiveData
import com.giorgi.teacherdiary.model.*

interface DiaryRepository {

    val studentList : LiveData<List<StudentListModel>>

    val studentName : LiveData<List<StudentName>>

    val studentLessons : LiveData<List<StudentLessons>>

    val studentLessonsDate : LiveData<List<StudLessonsDate>>

    val lessonsForCurrentDate: LiveData<List<StudentLessons>>

    suspend fun insertStudent (studentInfo: StudentInfo, onSuccess: () -> () -> Unit)
    suspend fun updateStudent (studentInfo: StudentInfo, onSuccess: () -> () -> Unit)
    suspend fun deleteStudent (studentInfo: StudentInfo, onSuccess: () -> () -> Unit)


    suspend fun insertStudentLessonsDate (studLessDate:StudLessonsDate, onSuccess: () -> () -> Unit)
    suspend fun updateStudentLessonsDate (studLessDate:StudLessonsDate, onSuccess: () -> () -> Unit)
    suspend fun deleteStudentLessonsDate (studLessDate:StudLessonsDate, onSuccess: () -> () -> Unit)

    suspend fun insertLesson (studentLessons: StudentLessons, onSuccess: () -> () -> Unit)
    suspend fun updateLesson (studentLessons: StudentLessons, onSuccess: () -> () -> Unit)
    suspend fun deleteLesson (studentLessons: StudentLessons, onSuccess: () -> () -> Unit)



}