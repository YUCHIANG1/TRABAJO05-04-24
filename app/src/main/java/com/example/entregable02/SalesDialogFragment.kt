package com.example.entregable02

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class SalesDialogFragment : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.floating_sales_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Implementa tu lógica para vender aquí, por ejemplo, añade OnClickListener a venderButton
        val venderButton = view.findViewById<Button>(R.id.venderButton)
        venderButton.setOnClickListener {
            // Utiliza el contexto de la aplicación para mostrar el mensaje Toast
            val context: Context = requireContext()
            Toast.makeText(context, "Producto vendido", Toast.LENGTH_SHORT).show()

            // Realiza la acción de vender
            dismiss() // Cierra el diálogo después de vender
        }
    }
}
