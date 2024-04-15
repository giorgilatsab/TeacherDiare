package com.giorgi.teacherdiary.screens.addlesson

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat.is24HourFormat
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import com.giorgi.teacherdiary.REPOSITORY
import com.giorgi.teacherdiary.databinding.ActivityAddLessonBinding
import com.giorgi.teacherdiary.model.StudLessonsDate
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import kotlinx.android.synthetic.main.activity_add_lesson.view.*
import java.text.SimpleDateFormat
import java.util.*

class AddLessonActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddLessonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddLessonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.timeLesson.setOnClickListener{
            openTimePicker()
        }

        binding.date.setOnClickListener{
            onOpenDatePickerButtonClick()
        }

        binding.saveButton.setOnClickListener{
            saveLesson()
        }
        binding.backButton.setOnClickListener{
            finish()
        }
    }

    private fun saveLesson() {
        val studentName = binding.studentname.text.toString()
        val lessonTime = binding.timeText.text.toString()
        val lessonDate = binding.dateText.text.toString()


        if (studentName.isEmpty() || lessonTime.isEmpty() || lessonDate.isEmpty() ){
            Toast.makeText(this, "please full all fields", Toast.LENGTH_SHORT).show()

        }

        //val lessonData = StudLessonsDate(lessonDate, lessonTime, studentName)
       // REPOSITORY.addLesson(lesson)
        else {
            val lesson = StudLessonsDate(lessonDate, lessonTime, studentName)
            //REPOSITORY.addLesson(lesson)
            Toast.makeText(this, "Lesson added", Toast.LENGTH_SHORT).show()
            finish()
        }

    }

    private fun openTimePicker() {

        val isSystem24Hour = is24HourFormat(this)
        val clockFormat = if (isSystem24Hour) TimeFormat.CLOCK_24H else TimeFormat.CLOCK_12H


        val picker = MaterialTimePicker.Builder()
            .setTimeFormat(clockFormat)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Select Appointment time")
            .build()

        val selectedTimeTextView: TextView = binding.timeText

        picker.addOnPositiveButtonClickListener {
            val selectedHour = picker.hour
            val selectedMinute = picker.minute

            // Handle the selected time as needed
            val selectedTime = "$selectedHour:$selectedMinute"

            // Update the TextView with the selected time
            selectedTimeTextView.text = selectedTime
        }

        picker.show(supportFragmentManager, "timePicker")
    }

    fun onOpenDatePickerButtonClick() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
                val selectedDate = formatDate(selectedYear, selectedMonth, selectedDay)
                 binding.dateText.text = selectedDate
                 var data = selectedDate
            },
            year,
            month,
            day
        )

        datePickerDialog.show()
    }

    private fun formatDate(year: Int, month: Int, day: Int): String {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return dateFormat.format(calendar.time)
    }

    }
