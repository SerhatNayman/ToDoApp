package com.serosoft.todoapp.ui.todo

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.serosoft.todoapp.R
import com.serosoft.todoapp.data.entity.Todo
import com.serosoft.todoapp.databinding.FragmentTodoListBinding
import com.serosoft.todoapp.ui.adapter.TodoRecyclerAdapter
import com.serosoft.todoapp.ui.add.AddTodoFragmentDirections
import com.serosoft.todoapp.utils.actionFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoListFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentTodoListBinding
    private lateinit var viewModel: TodoListViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_todo_list, container, false)

        binding.todoListFragment = this
        binding.toolbar
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        viewModel.todoList.observe(viewLifecycleOwner) {

            val adapter = TodoRecyclerAdapter(requireContext(), it, viewModel)
            binding.todoAdapter = adapter
            noTodoControl(it)

        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: TodoListViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
        val item = menu.findItem(R.id.search)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)

    }


    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.searchTodo(query)
        return true
    }


    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.searchTodo(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.getTodo()
    }

    fun goFab() {
        Navigation.actionFragment(binding.root, TodoListFragmentDirections.todoToAdd())
    }

    fun noTodoControl(list: List<Todo>) {
        if (list.isEmpty()) {
            binding.tvTodo.visibility = View.VISIBLE
        } else {
            binding.tvTodo.visibility = View.GONE
        }
    }


}