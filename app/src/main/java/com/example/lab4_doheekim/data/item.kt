package com.example.lab4_doheekim.data

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

data class Item(

    val id: String ="",
    val name: String =""
)

class ItemRepository(private val firestore: FirebaseFirestore) {

    suspend fun createItem(name: String): Result<Unit> = try {
        val collectionRef = firestore.collection("items")
        val docRef = collectionRef.document() // generate a new document reference (with ID)
        val item = Item(id = docRef.id, name = name) // assign the generated ID to the item
        docRef.set(item).await() // save the item with the assigned ID
        Result.success(Unit)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun getItems(): Result<List<Item>> = try {
        val querySnapshot = firestore.collection("items").get().await()
        val items = querySnapshot.documents.map { document ->
            document.toObject(Item::class.java)!!.copy(id = document.id)
        }
        Result.success(items)
    } catch (e: Exception) {
        Result.failure(e)
    }
}