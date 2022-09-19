package com.serosoft.todoapp.room

import androidx.room.RoomDatabase
import com.serosoft.todoapp.data.entity.Todo

@androidx.room.Database(entities = [Todo::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract fun getTodoDao(): TodoDao
}