package com.example.tms_android.Lessons.Lesson21.HomeWork2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_android.Lessons.Lesson21.PostModel
import com.example.tms_android.R

class PostAdapterHW2 : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var posts = listOf<PostModel>()

    companion object {
        private const val TYPE_AUTHOR = 0
        private const val TYPE_IMAGE = 1
        private const val TYPE_BUTTON = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (posts[position]) {
            is PostModel.AuthorPost -> TYPE_AUTHOR
            is PostModel.ImagePost -> TYPE_IMAGE
            is PostModel.ButtonPost -> TYPE_BUTTON
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_AUTHOR -> AuthorViewHolder(inflater.inflate(R.layout.item_post_author_no_margin, parent, false))
            TYPE_IMAGE -> ImageViewHolder(inflater.inflate(R.layout.item_post_image_no_margin, parent, false))
            TYPE_BUTTON -> ButtonViewHolder(inflater.inflate(R.layout.item_post_button_no_margin, parent, false))
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val post = posts[position]
        when (holder) {
            is AuthorViewHolder -> holder.bind(post as PostModel.AuthorPost)
            is ImageViewHolder -> holder.bind(post as PostModel.ImagePost)
            is ButtonViewHolder -> holder.bind(post as PostModel.ButtonPost)
        }
    }

    override fun getItemCount(): Int = posts.size

    fun updateList(newPosts: List<PostModel>) {
        val diffCallback = PostDiffCallback(posts, newPosts)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        posts = newPosts
        diffResult.dispatchUpdatesTo(this)
    }

    class AuthorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(post: PostModel.AuthorPost) {
            itemView.findViewById<TextView>(R.id.authorName).text = post.author
            itemView.findViewById<TextView>(R.id.postText).text = post.text
        }
    }

    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(post: PostModel.ImagePost) {
            itemView.findViewById<ImageView>(R.id.postImage).setImageResource(post.imageRes)
            itemView.findViewById<TextView>(R.id.postText).text = post.text
        }
    }

    class ButtonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(post: PostModel.ButtonPost) {
            itemView.findViewById<TextView>(R.id.postText).text = post.text
            itemView.findViewById<Button>(R.id.postButton).text = post.buttonLabel
        }
    }

    class PostDiffCallback(private val oldList: List<PostModel>, private val newList: List<PostModel>) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size
        override fun getNewListSize(): Int = newList.size
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }
        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}
