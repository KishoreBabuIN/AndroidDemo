package com.kishorebabu.androiddemo.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kishorebabu.androiddemo.databinding.ItemPostListBinding
import com.kishorebabu.posts.domain.model.Post

class PostsListAdapter : ListAdapter<Post, PostsListAdapter.PostItemViewHolder>(PostListDiffUtil) {
    private var postOnClickListener: (Post) -> Unit = {}

    fun setPostClickListener(onClick: (Post) -> Unit) {
        this.postOnClickListener = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItemViewHolder {
        val binding =
            ItemPostListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostItemViewHolder, position: Int) {
        holder.bind(currentList[position], postOnClickListener)
    }

    class PostItemViewHolder constructor(
        private val binding: ItemPostListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post, postOnClickListener: (Post) -> Unit) {
            binding.apply {
                this.tvBody.text = post.body
                this.tvTitle.text = post.title
                root.setOnClickListener { postOnClickListener(post) }
            }
        }
    }

}

object PostListDiffUtil : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }

}
