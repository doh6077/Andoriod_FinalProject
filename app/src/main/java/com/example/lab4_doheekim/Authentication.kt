package com.example.lab4_doheekim

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Authentication : ViewModel() {

    private var auth: FirebaseAuth = Firebase.auth

    fun signUp(context: Context, email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    goToMainActivity(task.result?.user, context)
                } else if (!task.exception?.message.isNullOrEmpty()) {
                    Toast.makeText(context, task.exception?.message, Toast.LENGTH_LONG).show()
                } else {
                    signIn(context, email, password)
                }
            }
    }

    fun signIn(context: Context, email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    goToMainActivity(task.result?.user, context)
                } else {
                    Toast.makeText(context, task.exception?.message, Toast.LENGTH_LONG).show()
                }
            }
    }

    fun goToMainActivity(user: FirebaseUser?, context: Context) {
        if (user != null) {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

    fun logout() {
        auth.signOut()
    }
}
