package com.example.equis

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    // Lista mutable para almacenar usuarios registrados en la ejecución actual
    companion object {
        val userList = mutableListOf<Map<String, String>>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.edtUsuario)
        passwordEditText = findViewById(R.id.edtPassword)
        loginButton = findViewById(R.id.btnLogin)

        // Usuarios iniciales
        if (userList.isEmpty()) {
            userList.add(
                mapOf("username" to "admin", "password" to "123", "userType" to "admin", "telefono" to "N/A", "correo" to "N/A")
            )
            userList.add(
                mapOf("username" to "cliente", "password" to "123", "userType" to "cliente", "telefono" to "N/A", "correo" to "N/A")
            )
        }

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val user = userList.find { it["username"] == username && it["password"] == password }
                if (user != null) {
                    saveUserDetails(user)
                    Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                    navigateToMain()
                } else {
                    Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun saveUserDetails(user: Map<String, String>) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("username", user["username"])
        editor.putString("userType", user["userType"])
        editor.apply()
    }

    private fun navigateToMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
