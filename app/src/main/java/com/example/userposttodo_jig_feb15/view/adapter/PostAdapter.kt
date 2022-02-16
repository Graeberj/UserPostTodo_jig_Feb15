package com.example.userposttodo_jig_feb15.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.userposttodo_jig_feb15.data.local.entity.Post
import com.example.userposttodo_jig_feb15.databinding.PostRowItemBinding

class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private val postList = mutableListOf<Post>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            PostRowItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount(): Int = postList.size

    fun submitList(posts: List<Post>) {
        postList.clear()
        postList.addAll(posts)
        notifyDataSetChanged()
    }
    class PostViewHolder(private val binding: PostRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) = with(binding) {
            userIdTv.text = post.userId.toString()
            idTv.text = post.id.toString()
            titleTv.text = post.title
            bodyTv.text = post.body
        }
    }

}