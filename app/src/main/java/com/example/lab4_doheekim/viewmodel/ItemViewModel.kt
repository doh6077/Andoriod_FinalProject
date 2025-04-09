package com.example.lab4_doheekim.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab4_doheekim.data.Item
import com.example.lab4_doheekim.data.ItemRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

class ItemViewModel : ViewModel() {
    private val repository = ItemRepository(FirebaseFirestore.getInstance())

    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> = _items

    init {
        loadItems()
    }

    fun loadItems() {
        viewModelScope.launch {
            repository.getItems().onSuccess {
                _items.value = it
            }
        }
    }

    fun createItem(name: String) {
        viewModelScope.launch {
            repository.createItem(name).onSuccess {
                loadItems() // refresh after adding
            }
        }
    }
}
