package com.example.equis.ui.accesorios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.equis.databinding.FragmentAccesoriosBinding

class AccesoriosFragment : Fragment() {

    // Declaración de la variable _binding
    private var _binding: FragmentAccesoriosBinding? = null

    // Esta propiedad es solo válida entre onCreateView y onDestroyView
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inicialización del binding
        _binding = FragmentAccesoriosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Configurar los clics de productos
        setupProductClickListeners()

        return root
    }

    private fun setupProductClickListeners() {
        // Configurar clics para cada producto con su mensaje de información
        binding.banda.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Bandas elásticas. Herramienta versátil para entrenamientos de resistencia $200 MXN.",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.cuerda.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Cuerda de Saltar. Accesorio esencial para entrenamientos cardiovasculares $300 MXN.",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.guantes.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Guantes. Diseñados para proteger tus manos durante levantamientos de peso $700 MXN.",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.mochila.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Mochila. Espaciosa y resistente, ideal para transportar tu equipo deportivo $900 MXN.",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.rueda.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Rueda para abdominales. Herramienta efectiva para fortalecer el núcleo 250 MXN.",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.shaker.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Shaker. Botella mezcladora para preparar y transportar tus batidos $350 MXN.",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.straps.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Straps. Correas de levantamiento que mejoran el agarre $400 MXN.",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.tapete.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Tapete. Superficie acolchada y antideslizante para yoga o pilates $600 MXN.",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.tobillera.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Tobilleras con peso. Accesorio ideal para añadir resistencia a tus entrenamientos $200 MXN.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Liberar el binding cuando la vista se destruye
        _binding = null
    }
}
