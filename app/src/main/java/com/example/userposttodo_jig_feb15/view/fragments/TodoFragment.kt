package com.example.userposttodo_jig_feb15.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.userposttodo_jig_feb15.databinding.FragmentTodoBinding
import com.example.userposttodo_jig_feb15.utils.DataState
import com.example.userposttodo_jig_feb15.view.adapter.TodoAdapter
import com.example.userposttodo_jig_feb15.viewmodel.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoFragment : Fragment() {

    private var _binding: FragmentTodoBinding? = null
    private val binding: FragmentTodoBinding get() = _binding!!
    private val viewModel: TodoViewModel by viewModels()
    private val todoAdapter by lazy {
        TodoAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            todoRv.apply {
                adapter = todoAdapter
                layoutManager = LinearLayoutManager(requireContext())
                addItemDecoration(
                    DividerItemDecoration(
                        requireContext(),
                        LinearLayoutManager.VERTICAL
                    )
                )
            }
            viewModel.todos.observe(viewLifecycleOwner) { state ->
                updateUi(state is DataState.Loading)
                when (state) {
                    is DataState.Loading -> {

                    }
                    is DataState.Success -> {
                        todoAdapter.submitList(state.data)
                    }
                    is DataState.Error -> {
                        Toast.makeText(requireContext(), state.msg, Toast.LENGTH_LONG).show()
                    }
                }

            }
        }
    }
    private fun updateUi(isLoading: Boolean) {
        binding.progressBar.isVisible = isLoading
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}