package com.giorgi.teacherdiary.db.repository

import androidx.room.RoomDatabase

@androidx.room.Database(entities = [com.giorgi.teacherdiary.model.StudentInfo::class,
   com.giorgi.teacherdiary.model.StudLessonsDate::class, com.giorgi.teacherdiary.model.StudentLessons::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun getStudentInfoDao(): com.giorgi.teacherdiary.db.dao.StudentInfoDao
    companion object {
        @kotlin.jvm.Volatile
        private var database: com.giorgi.teacherdiary.db.repository.Database? = null
        @Synchronized
        fun getInstance(context: android.content.Context): com.giorgi.teacherdiary.db.repository.Database {
            return if (database == null) {
                database = androidx.room.Room.databaseBuilder(context, com.giorgi.teacherdiary.db.repository.Database::class.java, "diary").build()
                database as com.giorgi.teacherdiary.db.repository.Database
            } else {
                database as com.giorgi.teacherdiary.db.repository.Database
            }
        }
    }
}