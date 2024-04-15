package com.giorgi.teacherdiary.screens.weekday.monday

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.giorgi.teacherdiary.REPOSITORY
import com.giorgi.teacherdiary.db.repository.Database.Companion.getInstance
import com.giorgi.teacherdiary.db.repository.DiaryRealisation
import com.giorgi.teacherdiary.model.StudentLessons

class MondayViewmodel(application: Application):AndroidViewModel(application) {
    val context = application

    fun initdatabase(){
        val daoNote = getInstance(context).getStudentInfoDao()
        REPOSITORY = DiaryRealisation(daoNote)

        fun getcurrentLessons(): LiveData<List<StudentLessons>> {


            return REPOSITORY.lessonsForCurrentDate

        }
        }
}