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
import com.example.userposttodo_jig_feb15.databinding.FragmentUserBinding
import com.example.userposttodo_jig_feb15.utils.DataState
import com.example.userposttodo_jig_feb15.view.adapter.UserAdapter
import com.example.userposttodo_jig_feb15.viewmodel.UserViewModel

class UserFragment: Fragment() {

    private var _binding: FragmentUserBinding? = null
    private val binding: FragmentUserBinding get() = _binding!!
    private val viewModel: UserViewModel by viewModels()
    private val userAdapter by lazy {
        UserAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            userRv.apply {
                adapter = userAdapter
                layoutManager = LinearLayoutManager(requireContext())
                addItemDecoration(
                    DividerItemDecoration(
                        requireContext(),
                        LinearLayoutManager.VERTICAL)
                )
            }
            viewModel.users.observe(viewLifecycleOwner) {state->
                updateUi(state is DataState.Loading)
                when (state) {
                    is DataState.Loading -> {

                    }
                    is DataState.Success -> {
                        userAdapter.submitList(state.data)
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