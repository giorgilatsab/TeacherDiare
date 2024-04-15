package com.giorgi.teacherdiary.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.giorgi.teacherdiary.R
import com.giorgi.teacherdiary.model.StudentListModel
import kotlinx.android.synthetic.main.item_lesson.view.name
import kotlinx.android.synthetic.main.item_student_list.view.*
import com.giorgi.teacherdiary.screens.menu.studentList.StudentList

class ListStudentAdapter: RecyclerView.Adapter<ListStudentAdapter.ListStudentViewHolder>() {

    var studlist = emptyList<StudentListModel>()

    class ListStudentViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListStudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student_list,parent,false)
        return ListStudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListStudentViewHolder, position: Int) {
        holder.itemView.name.text = studlist[position].studentName
        holder.itemView.wich_class.text = studlist[position].whichClass.toString()
        holder.itemView.phone_number.text = studlist[position].telNumber.toString()
    }

    override fun getItemCount(): Int {
        return studlist.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setstudlist(list : List<StudentListModel>){
        studlist = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: ListStudentViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{
            StudentList.clicknote(studlist[holder.adapterPosition])
        }
    }
}