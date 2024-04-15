package com.giorgi.teacherdiary.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.giorgi.teacherdiary.model.*


@Dao
interface StudentInfoDao {
     @Insert(onConflict = OnConflictStrategy.IGNORE)
     suspend fun insertStudent(studentInfo: StudentInfo) //insert student

     @Update
     suspend fun updateStudent(studentInfo: StudentInfo)  //update student

     @Delete
        suspend fun deleteStudent(studentInfo: StudentInfo) //delete student

     @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertStudentAttendLesson(studLessonsDate: StudLessonsDate) //insert lesson attend

     @Update
        suspend fun updateStudentAttendLesson(studLessonsDate: StudLessonsDate) //update lesson date

     @Delete
        suspend fun deleteStudentAttendLesson(studLessonsDate: StudLessonsDate) //delete lesson attend

     @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertLesson(studentLessons: StudentLessons) //insert student  lesson

     @Update
     suspend fun updateLesson(studentLessons: StudentLessons)//update student attend lesson

     @Delete
     suspend fun deleteLesson(studentLessons: StudentLessons) //delete student lesson

     //StudentList where are 3 columns
     @Query("SELECT studentName, whichClass, telNumber  FROM student_info")
     fun getStudentList(): LiveData<List<StudentListModel>>

     //StudentName list where are only one column student name
     @Query("SELECT studentName FROM student_info")
     fun getStudentName(): LiveData<List<StudentName>>

     //studentLessons list
     @Query("SELECT * FROM student_lessons")
     fun getStudentLessons(): LiveData<List<StudentLessons>>

     //studentLessonsDate list
     @Query("SELECT * FROM student_lessons_date")
     fun getStudentLessonsDate(): LiveData<List<StudLessonsDate>>

     @Query("SELECT * FROM student_lessons WHERE lessonData = :currentDate")
     fun getLessonsForCurrentDate(currentDate: Int): LiveData<List<StudentLessons>>
}