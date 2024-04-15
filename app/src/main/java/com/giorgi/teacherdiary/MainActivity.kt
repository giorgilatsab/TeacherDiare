package com.giorgi.teacherdiary

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import com.giorgi.teacherdiary.adapters.ViewpagerAdapter
import com.giorgi.teacherdiary.databinding.ActivityMainBinding
import com.giorgi.teacherdiary.model.StudentInfo
import com.giorgi.teacherdiary.screens.addlesson.AddLessonActivity
import com.giorgi.teacherdiary.screens.menu.addStudent.AddStudent
import com.giorgi.teacherdiary.screens.menu.statistic.Statistic
import com.giorgi.teacherdiary.screens.menu.studentList.StudentList
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayoutMediator
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var navcontroller: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        init()
        addlesson()

    }



    private fun init() {
        binding.viewPager.adapter = ViewpagerAdapter(this)
        binding.tabLayout.tabIconTint = null

        val calendar = Calendar.getInstance()
        val currentDayOfWeek = (calendar.get(Calendar.DAY_OF_WEEK) + 6) % 7 // Adjusting for your week starting from Monday

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
            val dayOfWeek = (pos ) % 7  // Adjusting for your week starting from Monday
            val orderedDay = (dayOfWeek + 1) % 7 +1

            val sdf = SimpleDateFormat("EEE", Locale.getDefault())
            val dayName = sdf.format(calendar.time)



            when (orderedDay) {
                Calendar.MONDAY -> tab.text = "ორშ"
                Calendar.TUESDAY -> tab.text = "სამშ"
                Calendar.WEDNESDAY -> tab.text = "ოთხ"
                Calendar.THURSDAY -> tab.text = "ხუთ"
                Calendar.FRIDAY -> tab.text = "პარ"
                Calendar.SATURDAY -> tab.text = "შაბ"
                Calendar.SUNDAY -> tab.text = "კვი"
            }

            // Reset calendar to the current date
            calendar.time = Date()

            if (orderedDay == currentDayOfWeek) {
                binding.tabLayout.setScrollPosition(pos, 0f, true)
            }
        }.attach()

        // Set the starting position of the ViewPager to show the current day fragment
        val startingPosition = (currentDayOfWeek + 6) % 7 // Adjusting for your week starting from Monday
        binding.viewPager.setCurrentItem(startingPosition, false)

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                val prevPosition: Int = (calendar.get(Calendar.DAY_OF_WEEK) + 5) % 7

                // Compare current position with previous position
                if (position > prevPosition) {
                    val difference  = position - prevPosition
                    calendar.add(Calendar.DAY_OF_WEEK, difference) // Add one day if swiping right

                } else if (position < prevPosition) {
                    val difference  = prevPosition - position
                    calendar.add(Calendar.DAY_OF_WEEK, -difference) // Subtract one day if swiping left
                }


                // Update UI
                val sdfCalendarDay = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                val calendarDay = sdfCalendarDay.format(calendar.time)
                binding.courentTime!!.text = calendarDay
            }
        })


        val currentDate = calendar.time
        val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val formattedDate = sdf.format(currentDate)
        binding.courentTime!!.text = formattedDate
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(com.giorgi.teacherdiary.R.menu.menu_option,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            com.giorgi.teacherdiary.R.id.add -> {
                val intent = Intent(this, AddStudent::class.java)
                startActivity(intent)
                return true
            }
            com.giorgi.teacherdiary.R.id.list_students -> {
                val intent = Intent(this, StudentList::class.java)
                startActivity(intent)
                return true
            }
            com.giorgi.teacherdiary.R.id.statistic -> {
                val intent = Intent(this, Statistic::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun addlesson(){
        val floating: FloatingActionButton = binding.addLessonFloatingButton
        floating.setOnClickListener{
            val intent = Intent(this, AddLessonActivity::class.java)
            startActivity(intent)
        }
    }


}





