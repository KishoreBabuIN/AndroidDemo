package com.kishorebabu.gorillaschallenge.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kishorebabu.gorillaschallenge.databinding.ItemPostListBinding
import com.kishorebabu.posts.domain.model.Post

class PostsListAdapter : ListAdapter<Post, PostsListAdapter.PostItemViewHolder>(PostListDiffUtil) {
    private val postsList = mutableListOf<Post>()
    private var postOnClickListener: (String) -> Unit = {}

    fun setPosts(posts: List<Post>, onClick: (String) -> Unit) {
        postsList.clear()
        postsList.addAll(posts)
        this.postOnClickListener = onClick
        notifyDataSetChanged() //fixme
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItemViewHolder {
        val binding =
            ItemPostListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostItemViewHolder, position: Int) {
        holder.bind(postsList[position], postOnClickListener)
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    class PostItemViewHolder constructor(
        private val binding: ItemPostListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post, postOnClickListener: (String) -> Unit) {
            binding.apply {
                this.tvBody.text = post.body
                this.tvTitle.text = post.title
                root.setOnClickListener { postOnClickListener(post.id) }
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
