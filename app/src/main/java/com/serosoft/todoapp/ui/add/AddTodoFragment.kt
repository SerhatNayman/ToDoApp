package com.serosoft.todoapp.ui.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.serosoft.todoapp.R
import com.serosoft.todoapp.databinding.FragmentAddTodoBinding
import com.serosoft.todoapp.utils.actionFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTodoFragment : Fragment() {
    private lateinit var binding: FragmentAddTodoBinding
    private lateinit var viewModel: AddTodoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_todo, container, false)
        binding.addTodoFragment = this
        binding.toolbarAddTodo = "ToDo Add"

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AddTodoViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun addTodo(description: String) {
        viewModel.addTodo(description)
        Navigation.actionFragment(binding.root, AddTodoFragmentDirections.addTodotoTodoList())
    }


}