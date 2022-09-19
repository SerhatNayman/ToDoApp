package com.serosoft.todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.serosoft.todoapp.data.entity.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM todoapp")
    suspend fun getTodo(): List<Todo>

    @Insert
    suspend fun addTodo(todo: Todo)

    @Update
    suspend fun updateTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)

    @Query("select * from todoapp where todoDescription like '%'||:search||'%'")
    suspend fun searchTodo(search: String): List<Todo>
}