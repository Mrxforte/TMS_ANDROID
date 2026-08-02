package com.example.tms_android.Lessons.Lesson23.Task1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoppingViewModel : ViewModel() {
    private val _items = MutableLiveData<List<ShoppingItem>>(emptyList())
    val items: LiveData<List<ShoppingItem>> = _items

    fun addItem(name: String) {
        val currentList = _items.value.orEmpty().toMutableList()
        val newItem = ShoppingItem(
            id = System.currentTimeMillis(),
            name = name
        )
        currentList.add(newItem)
        _items.value = currentList
    }

    fun toggleItem(id: Long) {
        val currentList = _items.value.orEmpty().toMutableList()
        val index = currentList.indexOfFirst { it.id == id }
        if (index != -1) {
            val item = currentList[index]
            currentList[index] = item.copy(isChecked = !item.isChecked)
            _items.value = currentList
        }
    }
}
