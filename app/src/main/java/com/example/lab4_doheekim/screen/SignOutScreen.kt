package com.example.lab4_doheekim.screen
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab4_doheekim.Authentication
import com.example.lab4_doheekim.SignUp
import com.example.lab4_doheekim.ui.theme.Lab4_DoheeKimTheme



@Composable
fun SignOutScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var authentication = Authentication()

    Column(
        modifier = Modifier.padding(48.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Set up sign out button
        Button(
            onClick = {
                Toast.makeText(context, "Sign Out..", Toast.LENGTH_SHORT).show()
                authentication.logout(context)
            },
            shape = RoundedCornerShape(size = 24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            modifier = Modifier
                .size(250.dp, 70.dp)
                .padding(8.dp)
        ) {
            Text(
                "Sign out",
                modifier = Modifier.padding(8.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

