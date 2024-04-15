package com.giorgi.teacherdiary.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.giorgi.teacherdiary.screens.weekday.friday.FridayFragment
import com.giorgi.teacherdiary.screens.weekday.monday.MondayFragment
import com.giorgi.teacherdiary.screens.weekday.saturday.SaturdayFragment
import com.giorgi.teacherdiary.screens.weekday.sunday.SundayFragment
import com.giorgi.teacherdiary.screens.weekday.thursday.ThursdayFragment
import com.giorgi.teacherdiary.screens.weekday.tuesday.TuesdayFragment
import com.giorgi.teacherdiary.screens.weekday.wednesday.WednesdayFragment

class ViewpagerAdapter (fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 7
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MondayFragment()
            1 -> TuesdayFragment()
            2 -> ThursdayFragment()
            3 -> WednesdayFragment()
            4 -> FridayFragment()
            5 -> SaturdayFragment()
            else -> return SundayFragment()
        }
    }
}