package com.example.tms_android.Lessons.Lesson22.Task2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    private val _filteredUsers = MutableLiveData<List<UserModel>>()
    val filteredUsers: LiveData<List<UserModel>> = _filteredUsers

    val usersList = listOf(
//        change names to different
//        by name 100 list real name users
        UserModel(1, "John Doe"),
        UserModel(2, "Jane Smith"),
        UserModel(3, "Bob Johnson"),
        UserModel(4, "Alice Brown"),
        UserModel(5, "Charlie White"),
        UserModel(6, "Eva Green"),
        UserModel(7, "David Black"),
        UserModel(8, "Grace Gray"),
        UserModel(9, "Frank Red"),
        UserModel(10, "Helen Yellow"),
        UserModel(11, "George Blue"),
        UserModel(12, "Ivy Pink"),
        UserModel(13, "Jack Orange"),
        UserModel(14, "Kelly Purple"),
        UserModel(15, "Liam Teal"),
        UserModel(16, "Mia Brown"),
        UserModel(17, "Noah Green"),
        UserModel(18, "Olivia White"),
        UserModel(19, "Peter Red"),
        UserModel(20, "Quinn Yellow"),
        UserModel(21, "Rachel Blue"),
        UserModel(22, "Sam Pink"),
        UserModel(23, "Tom Orange"),
        UserModel(24, "Ursula Purple"),
        UserModel(25, "Victor Teal"),
        UserModel(26, "Wendy Brown"),
        UserModel(27, "Xavier Green"),
        UserModel(28, "Yvonne White"),
        UserModel(29, "Zachary Red"),
        UserModel(30, "Zoe Yellow"),






    )

    init {
        _filteredUsers.value = usersList
    }

    fun filterUsers(filter: String) {
        _filteredUsers.value = usersList.filter { it.name.contains(filter) }
    }
}


