package com.example.firebase

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.lab4_doheekim.R
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import com.google.firebase.storage.storageMetadata
import java.io.ByteArrayOutputStream
import android.content.Context
import android.net.Uri
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Date

class StorageActivity: ViewModel() {

    var storage = Firebase.storage

    // Create a storage reference from our app
    var storageRef = storage.reference
    var imagesRef: StorageReference? = storageRef.child("images")
    var spaceRef = storageRef.child("images/space.jpg")


    fun uploadFile(context: Context) {
        // Decode the resource to a bitmap
        val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.img)

        if (bitmap == null) {
            Log.e("StorageActivity", "Failed to decode image.")
            return
        }

        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos)
        val data = baos.toByteArray()

        val ref = storageRef.child("images/img.png")

        ref.putBytes(data)
            .addOnSuccessListener {
                Log.d("Firebase", "Upload img.png successful")
            }
            .addOnFailureListener {
                Log.e("Firebase", "Upload img.png failed", it)
            }
    }
    fun imageUpload(uri: Uri) {
        // storage 인스턴스 생성
        val storage = Firebase.storage
        // storage 참조
        val storageRef = storage.getReference("image")
        // storage에 저장할 파일명 선언
        val fileName = SimpleDateFormat("yyyyMMddHHmmss").format(Date())
        val mountainsRef = storageRef.child("${fileName}.png")

        val uploadTask = mountainsRef.putFile(uri)
        uploadTask.addOnSuccessListener { taskSnapshot ->
        }.addOnFailureListener {

        }
    }


    fun downloadFile(){

        var islandRef = storageRef.child("images/img.png")

        val ONE_MEGABYTE: Long = 1024 * 1024
        islandRef.getBytes(ONE_MEGABYTE).addOnSuccessListener {
            // Data for "images/island.jpg" is returned, use this as needed
            Log.d("Firebase", "Download img.png successful")
        }.addOnFailureListener {
            // Handle any errors
            Log.e("Firebase", "Download img.png failed", it)
        }
    }

    fun updateFile(context: Context){

        val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.img_1)

        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos)
        val data = baos.toByteArray()

        val ref = storageRef.child("profile_images/img.png")

        ref.putBytes(data)
            .addOnSuccessListener {
                Log.d("Firebase", "Update to img_1.png successful")
            }
            .addOnFailureListener {
                Log.e("Firebase", "Update failed", it)
            }
    }

    fun deleteFile(){


// Create a reference to the file to delete
        val desertRef = storageRef.child("images/img.png")

// Delete the file
        desertRef.delete().addOnSuccessListener {
            Log.d("Firebase", "Deleting img.png successful")
        }.addOnFailureListener {
            // Handle any errors
            Log.e("Firebase", "Deleting img.png failed", it)
        }
    }
}

fun main(){

}
