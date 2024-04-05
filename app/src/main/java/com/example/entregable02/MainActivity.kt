package com.example.entregable02

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var register: Button


    private lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.contraseña)
        loginButton = findViewById(R.id.button)
        register = findViewById(R.id.button1)


        register.setOnClickListener {
            val registroIntent = Intent(this, registro::class.java)
            startActivity(registroIntent)
            finish() // Opcional: cierra la actividad actual
        }


        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                loginUser(email, password)
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Login successful, navigate to home screen
                    val homeIntent = Intent(this, home::class.java)
                    startActivity(homeIntent)
                    finish() // Close current activity so user can't navigate back to it
                } else {
                    // Login failed, show error message
                    Toast.makeText(
                        this, "Error en el inicio de sesión. Por favor, verifica tus credenciales.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}
