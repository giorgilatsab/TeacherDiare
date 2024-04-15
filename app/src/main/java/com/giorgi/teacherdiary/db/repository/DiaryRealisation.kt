package com.giorgi.teacherdiary.db.repository

import androidx.lifecycle.LiveData
import com.giorgi.teacherdiary.db.dao.StudentInfoDao
import com.giorgi.teacherdiary.model.*
import com.giorgi.teacherdiary.screens.CurrentData.getCurrentDate
import java.util.*

 class DiaryRealisation(private val dao: StudentInfoDao,
                       ): DiaryRepository {

    override val studentLessons: LiveData<List<StudentLessons>>
        get() = dao.getStudentLessons()

    override val studentLessonsDate: LiveData<List<StudLessonsDate>>
        get() = dao.getStudentLessonsDate()

    override val studentList: LiveData<List<StudentListModel>>
        get() = dao.getStudentList()

    override val studentName: LiveData<List<StudentName>>
       get() = dao.getStudentName()

     override val lessonsForCurrentDate: LiveData<List<StudentLessons>>
        get() = dao.getLessonsForCurrentDate(getCurrentDate())

    override suspend fun insertStudent(studentInfo: StudentInfo, onSuccess: () -> () -> Unit) {
        dao.insertStudent(studentInfo)
        onSuccess()
    }

    override suspend fun updateStudent(studentInfo: StudentInfo, onSuccess: () -> () -> Unit) {
        dao.updateStudent(studentInfo)
        onSuccess()
    }

    override suspend fun deleteStudent(studentInfo: StudentInfo, onSuccess: () -> () -> Unit) {
        dao.deleteStudent(studentInfo)
        onSuccess()
    }

    override suspend fun insertStudentLessonsDate(
        studLessDate: StudLessonsDate,
        onSuccess: () -> () -> Unit
    ) {
        dao.insertStudentAttendLesson(studLessDate)
        onSuccess()
    }

    override suspend fun updateStudentLessonsDate(
        studLessDate: StudLessonsDate,
        onSuccess: () -> () -> Unit
    ) {
        dao.updateStudentAttendLesson(studLessDate)
        onSuccess()
    }

    override suspend fun deleteStudentLessonsDate(
        studLessDate: StudLessonsDate,
        onSuccess: () -> () -> Unit
    ) {
        dao.deleteStudentAttendLesson(studLessDate)
        onSuccess()
    }

    override suspend fun insertLesson(
        studentLessons: StudentLessons,
        onSuccess: () -> () -> Unit) {
        dao.insertLesson(studentLessons)
    }

    override suspend fun updateLesson(
        studentLessons: StudentLessons,
        onSuccess: () -> () -> Unit) {
        dao.updateLesson(studentLessons)
    }

    override suspend fun deleteLesson(studentLessons: StudentLessons, onSuccess: () -> () -> Unit) {
        dao.deleteLesson(studentLessons)
        onSuccess()
    }


}