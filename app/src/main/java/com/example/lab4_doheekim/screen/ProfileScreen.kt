package com.example.lab4_doheekim.screen

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firebase.StorageActivity
import com.example.lab4_doheekim.Authentication
import com.example.lab4_doheekim.R
import com.example.lab4_doheekim.ui.theme.Lab4_DoheeKimTheme



@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var storageActivity = StorageActivity()
    var authentication = Authentication()
    Column(
        modifier = Modifier.padding(48.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.hi),
            contentDescription = "hi image",
            modifier = Modifier.size(200.dp)
        )

        // First Button - Create
        Button(
            onClick = {
                Toast.makeText(context, "Uploading image...", Toast.LENGTH_SHORT).show()
                storageActivity.uploadFile(context)
            },
            shape = RoundedCornerShape(size = 24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            modifier = Modifier
                .size(250.dp, 70.dp)
                .padding(8.dp)
        ) {
            Text(
                "Create",
                modifier = Modifier.padding(8.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Second Button - Read
        Button(
            onClick = {
                Toast.makeText(context, "Reading image...", Toast.LENGTH_SHORT).show()
                storageActivity.downloadFile()
            },
            shape = RoundedCornerShape(size = 24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            modifier = Modifier
                .size(250.dp, 70.dp)
                .padding(8.dp)
        ) {
            Text(
                "Read",
                modifier = Modifier.padding(8.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Third Button - Update
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
                "Update",
                modifier = Modifier.padding(8.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Fourth Button - Delete
        Button(
            onClick = {
                Toast.makeText(context, "Deleting image...", Toast.LENGTH_SHORT).show()
                storageActivity.deleteFile()
            },
            shape = RoundedCornerShape(size = 24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            modifier = Modifier
                .size(250.dp, 70.dp)
                .padding(8.dp)
        ) {
            Text(
                "Delete",
                modifier = Modifier.padding(8.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Button(
            onClick = {
                Toast.makeText(context, "Deleting image...", Toast.LENGTH_SHORT).show()
                authentication.signIn(context,"doh6077@gmail.com", "123456")
            },
            shape = RoundedCornerShape(size = 24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            modifier = Modifier
                .size(250.dp, 70.dp)
                .padding(8.dp)
        ) {
            Text(
                "Sign in",
                modifier = Modifier.padding(8.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }


        }
    }

