package com.example.equis

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AgregarUsuarioActivity : AppCompatActivity() {

    private lateinit var editTextNombre: EditText
    private lateinit var editTextTelefono: EditText
    private lateinit var editTextCorreo: EditText
    private lateinit var editTxtContrasena: EditText
    private lateinit var switchCliente: Switch
    private lateinit var switchAdmin: Switch
    private lateinit var buttonRegistrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_usuario)

        editTextNombre = findViewById(R.id.editTxtNombre)
        editTextTelefono = findViewById(R.id.editTxtTelefono)
        editTextCorreo = findViewById(R.id.editTxtEmail)
        editTxtContrasena = findViewById(R.id.editTxtContrasena)
        switchCliente = findViewById(R.id.switchCliente)
        switchAdmin = findViewById(R.id.switchAdmin)
        buttonRegistrar = findViewById(R.id.buttonRegistrar)

        switchCliente.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) switchAdmin.isChecked = false
        }

        switchAdmin.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) switchCliente.isChecked = false
        }

        buttonRegistrar.setOnClickListener {
            val nombre = editTextNombre.text.toString().trim()
            val telefono = editTextTelefono.text.toString().trim()
            val correo = editTextCorreo.text.toString().trim()
            val contrasena = editTxtContrasena.text.toString().trim()
            val tipoUsuario = if (switchCliente.isChecked) "cliente" else "administrador"

            if (nombre.isEmpty() || telefono.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                // Crear el nuevo usuario
                val newUser = mapOf(
                    "username" to nombre,
                    "password" to contrasena,
                    "userType" to tipoUsuario,
                    "telefono" to telefono,
                    "correo" to correo
                )

                // Guardar el usuario en la lista de LoginActivity
                LoginActivity.userList.add(newUser)

                // Mostrar mensaje de éxito
                Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show()

                // Volver al menú principal
                finish()
            }
        }

    }
}
