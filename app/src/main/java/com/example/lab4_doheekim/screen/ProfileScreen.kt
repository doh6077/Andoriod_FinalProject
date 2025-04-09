package com.example.lab4_doheekim.screen

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.firebase.StorageActivity
import com.example.lab4_doheekim.Authentication
import com.example.lab4_doheekim.R
import com.example.lab4_doheekim.ui.theme.Lab4_DoheeKimTheme
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage


@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var uri: Uri
    var storageActivity = StorageActivity()
    var authentication = Authentication()
    var imageUrl by remember { mutableStateOf<String?>(null) }

    // Get Firebase image URL once when the Composable loads
    LaunchedEffect(Unit) {
        val storageRef = Firebase.storage.reference.child("profile_images/img.png")
        storageRef.downloadUrl.addOnSuccessListener { uri ->
            imageUrl = uri.toString()
        }.addOnFailureListener {
            Toast.makeText(context, "Failed to load image", Toast.LENGTH_SHORT).show()
        }
    }

    Column(
        modifier = Modifier.padding(48.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (imageUrl != null) {
            Image(
                painter = rememberAsyncImagePainter(imageUrl),
                contentDescription = "Profile Image",
                modifier = Modifier.size(200.dp)
            )
        } else {
            // Placeholder image
            Image(
                painter = painterResource(id = R.drawable.profile_icon),
                contentDescription = "Default Profile",
                modifier = Modifier.size(200.dp)
            )
        }
        // First Button - Create
        Button(
            onClick = {
                Toast.makeText(context, "Updating image...", Toast.LENGTH_SHORT).show()
                storageActivity.updateFile(context)
            },
            shape = RoundedCornerShape(size = 24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            modifier = Modifier
                .size(250.dp, 70.dp)
                .padding(8.dp)
        ) {
            Text(
                "Change Profile",
                modifier = Modifier.padding(8.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }



        }
    }

