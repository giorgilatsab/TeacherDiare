package com.giorgi.teacherdiary.screens.menu.studentList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.giorgi.teacherdiary.REPOSITORY
import com.giorgi.teacherdiary.model.StudentListModel
import com.giorgi.teacherdiary.model.StudentName

class StudentListViewmodel(application: Application): AndroidViewModel(application) {

val context = application


    fun getStudentList(): LiveData<List<StudentListModel>>{
        return REPOSITORY.studentList
    }

    fun getStudentNames(): LiveData<List<StudentName>>{
        return REPOSITORY.studentName
    }

}
