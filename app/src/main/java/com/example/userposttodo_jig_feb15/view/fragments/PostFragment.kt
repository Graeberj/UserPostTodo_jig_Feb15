package com.example.userposttodo_jig_feb15.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.userposttodo_jig_feb15.databinding.FragmentPostBinding
import com.example.userposttodo_jig_feb15.utils.DataState
import com.example.userposttodo_jig_feb15.view.adapter.PostAdapter
import com.example.userposttodo_jig_feb15.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostFragment : Fragment() {

    private var _binding: FragmentPostBinding? = null
    private val binding: FragmentPostBinding get() = _binding!!
    private val viewModel: PostViewModel by viewModels()
    private val postAdapter by lazy {
        PostAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            postRv.apply {
                adapter = postAdapter
                layoutManager = LinearLayoutManager(requireContext())
                addItemDecoration(
                    DividerItemDecoration(
                        requireContext(),
                        LinearLayoutManager.VERTICAL
                    )
                )
            }
            todoBtn.setOnClickListener{
                val directions = PostFragmentDirections.actionPostFragmentToTodoFragment()
                findNavController().navigate(directions)
            }
            viewModel.posts.observe(viewLifecycleOwner) { state ->
                updateUi(state is DataState.Loading)
                when (state) {
                    is DataState.Loading -> {

                    }
                    is DataState.Success -> {
                        postAdapter.submitList(state.data)
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