package com.example.equis.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.equis.R
import com.example.equis.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // Esta propiedad es válida solo entre onCreateView y onDestroyView
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Obtener referencias a los botones
        val btnInscribirBasico: Button = binding.root.findViewById(R.id.buttonInscribirBasico)
        val btnInscribirAvanzado: Button = binding.root.findViewById(R.id.buttonInscribirAvanzado)
        val btnInscribirPremium: Button = binding.root.findViewById(R.id.buttonInscribirPremium)

        // Configurar los botones para mostrar un mensaje de inscripción
        btnInscribirBasico.setOnClickListener {
            Toast.makeText(context, "¡Te has inscrito al Plan Básico!", Toast.LENGTH_SHORT).show()
        }

        btnInscribirAvanzado.setOnClickListener {
            Toast.makeText(context, "¡Te has inscrito al Plan Avanzado!", Toast.LENGTH_SHORT).show()
        }

        btnInscribirPremium.setOnClickListener {
            Toast.makeText(context, "¡Te has inscrito al Plan Premium!", Toast.LENGTH_SHORT).show()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
