package com.example.tms_android.Lessons.Lesson22.Task2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_android.databinding.UserItemBinding

class UserAdapter(private var listUser: List<UserModel>) :
    RecyclerView.Adapter<UserAdapter.MyUserViewHolder>() {

    fun setData(newList: List<UserModel>) {
        listUser = newList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyUserViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyUserViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyUserViewHolder,
        position: Int
    ) {
        val user = listUser[position]
        holder.userItemBinding.userName.text = user.name
        holder.userItemBinding.userSubtitle.text = buildString {
        append("Sure name")
    }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    class MyUserViewHolder(val userItemBinding: UserItemBinding) :
        RecyclerView.ViewHolder(userItemBinding.root) {}
}