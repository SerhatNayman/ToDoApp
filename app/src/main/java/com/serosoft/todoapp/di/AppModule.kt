package com.serosoft.todoapp.di

import android.content.Context
import androidx.room.Room
import com.serosoft.todoapp.data.repository.TodoRepository
import com.serosoft.todoapp.room.Database
import com.serosoft.todoapp.room.TodoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideTodoRepository(todoDao: TodoDao): TodoRepository {
        return TodoRepository(todoDao)
    }

    @Provides
    @Singleton
    fun provideTodoDao(@ApplicationContext context: Context): TodoDao {
        val db = Room.databaseBuilder(context, Database::class.java, "todoapp.sqlite")
            .createFromAsset("todoapp.sqlite").build()
        return db.getTodoDao()
    }
}