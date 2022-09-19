package com.serosoft.todoapp.ui.detail

import androidx.lifecycle.ViewModel
import com.serosoft.todoapp.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(var todoRepo: TodoRepository) : ViewModel() {
    fun updateTodo(todoId: Int, description: String) {
        todoRepo.updateTodo(todoId, description)
    }
}