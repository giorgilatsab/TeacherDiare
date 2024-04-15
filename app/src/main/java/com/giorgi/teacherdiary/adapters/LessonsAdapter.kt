package com.giorgi.teacherdiary.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.giorgi.teacherdiary.R
import com.giorgi.teacherdiary.model.StudentLessons
import kotlinx.android.synthetic.main.item_lesson.view.*

class LessonsAdapter:RecyclerView.Adapter<LessonsAdapter.LessonsViewholder>() {

    var listStud = emptyList<StudentLessons>()

    class LessonsViewholder(view: View): RecyclerView.ViewHolder(view) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonsViewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lesson,parent,false)
        return LessonsViewholder(view)
    }

    override fun onBindViewHolder(holder: LessonsViewholder, position: Int) {
        holder.itemView.name.text = listStud[position].studentName
        holder.itemView.time.text = listStud[position].lessonTime.toString()
        holder.itemView.checkBox.isChecked = listStud[position].come
        holder.itemView.lessons_numb.text = listStud[position].lessonsNumber.toString()


    }

    override fun getItemCount(): Int {
        return listStud.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setlist(list:List<StudentLessons>){
        listStud = list
        notifyDataSetChanged()
    }
}