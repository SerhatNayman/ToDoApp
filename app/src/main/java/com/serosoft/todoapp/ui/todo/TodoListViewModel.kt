package com.serosoft.todoapp.ui.todo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.serosoft.todoapp.data.entity.Todo
import com.serosoft.todoapp.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(var todoRepo: TodoRepository) : ViewModel() {
    var todoList = MutableLiveData<List<Todo>>()

    init {

        todoList = todoRepo.getTodos()

    }

    fun getTodo() {
        todoRepo.getAllTodo()

    }

    fun deleteTodo(todoId: Int) {
        todoRepo.deleteTodo(todoId)

    }

    fun searchTodo(search: String) {
        todoRepo.searchTodo(search)

    }
}