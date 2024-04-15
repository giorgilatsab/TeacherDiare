package com.giorgi.teacherdiary.screens.menu.studentList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.giorgi.teacherdiary.APP
import com.giorgi.teacherdiary.R
import com.giorgi.teacherdiary.model.StudentListModel
import kotlinx.android.synthetic.main.activity_nest.*
import java.io.Serializable

class StudentList : AppCompatActivity(), Serializable {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)



    }

    fun init()
    {

    }

    companion object {
        fun clicknote(student: StudentListModel){
            val bundle = Bundle()
            bundle.putSerializable("note", student)
            APP.navcontroller.navigate(R.id.action_mondayFragment_to_tuesdayFragment, bundle)
        }
    }
}