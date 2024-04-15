package com.giorgi.teacherdiary.screens.weekday.monday

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.giorgi.teacherdiary.adapters.LessonsAdapter
import com.giorgi.teacherdiary.databinding.FragmentMondayBinding
import com.giorgi.teacherdiary.model.StudentLessons
import java.text.SimpleDateFormat
import java.util.*


class MondayFragment : Fragment() {

    lateinit var binding: FragmentMondayBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: LessonsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentMondayBinding.inflate(layoutInflater,container,false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        recyclerView = binding.recyclerStudent
        val arralis = arrayListOf<StudentLessons>(StudentLessons(12, 3, "name", false, 7))
        adapter = LessonsAdapter()
        adapter.setlist(arralis)
        recyclerView.adapter = adapter


    }



}