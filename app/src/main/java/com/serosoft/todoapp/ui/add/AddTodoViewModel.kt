package com.serosoft.todoapp.ui.add

import androidx.lifecycle.ViewModel
import com.serosoft.todoapp.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddTodoViewModel @Inject constructor(var todoRepo: TodoRepository) : ViewModel() {

    fun addTodo(description: String) {

        todoRepo.addTodo(description)
    }
}