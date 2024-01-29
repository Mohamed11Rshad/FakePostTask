package com.example.fakeposttask.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fakeposttask.databinding.PostLayoutBinding
import com.example.fakeposttask.domain.entity.Post

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    inner class PostViewHolder( val binding : PostLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.apply {
                postItemTitleTv.text = post.title
                postItemBodyTv.text = post.body

            }
        }
    }

    private val diffCallback = object : DiffUtil.ItemCallback<Post>(){

        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            PostLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = differ.currentList[position]
        holder.bind(post)

        holder.itemView.setOnClickListener {
            onPostClick?.invoke(post)
        }

    }

    var onPostClick : ((Post) -> Unit)? = null

}