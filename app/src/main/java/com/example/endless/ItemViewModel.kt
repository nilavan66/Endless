package com.example.endless

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemViewModel : ViewModel() {
    val itemList: MutableLiveData<List<Item>> = MutableLiveData()

    fun loadMoreItems() {
        val currentList = itemList.value ?: emptyList()
        val newList = currentList + createMockItems()
        itemList.postValue(newList)
    }

    private fun createMockItems(): List<Item> {

        // data creation logic
        val currentList = itemList.value ?: emptyList()

        // last item ID
        val lastItemId = currentList.lastOrNull()?.id ?: 0

        val newItems = mutableListOf<Item>()
        for (i in 1..10) {
            newItems.add(Item(lastItemId + i, "Item ${lastItemId + i}"))
        }
        return newItems
    }

}