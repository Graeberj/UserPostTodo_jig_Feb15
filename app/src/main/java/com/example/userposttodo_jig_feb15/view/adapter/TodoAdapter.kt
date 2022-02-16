package com.example.userposttodo_jig_feb15.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.userposttodo_jig_feb15.data.local.entity.Todo
import com.example.userposttodo_jig_feb15.databinding.TodoRowItemBinding

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    private val todoList = mutableListOf<Todo>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            TodoRowItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todoList[position])
    }

    override fun getItemCount(): Int = todoList.size

    fun submitList(todos: List<Todo>) {
        todoList.clear()
        todoList.addAll(todos)
        notifyDataSetChanged()
    }
    class TodoViewHolder(private val binding: TodoRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: Todo) = with(binding) {
            userIdTv.text = todo.userId.toString()
            idTv.text = todo.id.toString()
            titleTv.text = todo.title
            completedTv.text = todo.completed.toString()
        }
    }
}