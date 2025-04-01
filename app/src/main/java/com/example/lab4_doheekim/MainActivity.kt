package com.example.lab4_doheekim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firebase.StorageActivity
import com.example.lab4_doheekim.ui.theme.Lab4_DoheeKimTheme
import android.content.Context
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            Lab4_DoheeKimTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var storageActivity = StorageActivity()
    Column {
        Text(
            text = "Hello Dohee!",
            modifier = modifier
        )
        Button(onClick = {
            Toast.makeText(context, "Uploading image...", Toast.LENGTH_SHORT).show()
            storageActivity.uploadFile(context)
        }
        ) {
            Text("Create")
        }
        Button(onClick = {
            Toast.makeText(context, "Reading image...", Toast.LENGTH_SHORT).show()
            storageActivity.downloadFile()
        }
        ) {
            Text("Read")
        }
        Button(onClick = {
            Toast.makeText(context, "Updating image...", Toast.LENGTH_SHORT).show()
            storageActivity.updateFile(context)
        }
        ) {
            Text("Update")
        }
        Button(onClick = {
            Toast.makeText(context, "Deleting image...", Toast.LENGTH_SHORT).show()
            storageActivity.deleteFile()
        }
        ) {
            Text("Delete")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab4_DoheeKimTheme {
        Greeting("Android")
    }
}