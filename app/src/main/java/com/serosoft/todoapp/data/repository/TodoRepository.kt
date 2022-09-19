package com.serosoft.todoapp.data.repository

import androidx.lifecycle.MutableLiveData
import com.serosoft.todoapp.data.entity.Todo
import com.serosoft.todoapp.room.TodoDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoRepository(var todoDao: TodoDao) {
    val todoList: MutableLiveData<List<Todo>>

    init {
        todoList = MutableLiveData()
    }

    fun getTodos(): MutableLiveData<List<Todo>> {
        return todoList
    }

    fun getAllTodo() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            todoList.value = todoDao.getTodo()
        }
    }

    fun addTodo(description: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val todo = Todo(0, description)
            todoDao.addTodo(todo)
        }

    }

    fun deleteTodo(todoId: Int) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val todo = Todo(todoId, "")
            todoDao.deleteTodo(todo)
            getAllTodo()
        }
    }

    fun updateTodo(todoId: Int, description: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val todo = Todo(todoId, description)
            todoDao.updateTodo(todo)
            getAllTodo()
        }
    }

    fun searchTodo(search: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            todoList.value = todoDao.searchTodo(search)
        }

    }
}