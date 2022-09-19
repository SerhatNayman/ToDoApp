package com.serosoft.todoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.serosoft.todoapp.R
import com.serosoft.todoapp.data.entity.Todo
import com.serosoft.todoapp.databinding.CardviewTodoBinding
import com.serosoft.todoapp.ui.todo.TodoListFragmentDirections
import com.serosoft.todoapp.ui.todo.TodoListViewModel
import com.serosoft.todoapp.utils.actionFragment

class TodoRecyclerAdapter(
    val mContext: Context,
    val todoList: List<Todo>,
    val viewModel: TodoListViewModel
) :
    RecyclerView.Adapter<TodoRecyclerAdapter.CardDesign>() {

    inner class CardDesign(binding: CardviewTodoBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: CardviewTodoBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesign {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: CardviewTodoBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.cardview_todo, parent, false)
        return CardDesign(binding)
    }

    override fun onBindViewHolder(holder: CardDesign, position: Int) {
        val todo = todoList[position]
        val t = holder.binding
        t.todoObject = todo
        t.textViewTodo.text = "${todo.todoDescription}"
        t.cardView.setOnClickListener {
            Navigation.actionFragment(it, TodoListFragmentDirections.todoToDetail(todo = todo))

        }
        t.imageViewTodo.setOnClickListener {
            Snackbar.make(it, "Are you sure to delete?", Snackbar.LENGTH_LONG).setAction("YES") {

                viewModel.deleteTodo(todo.todoId)
            }.show()
        }
    }

    override fun getItemCount(): Int {
        return todoList.size
    }
}