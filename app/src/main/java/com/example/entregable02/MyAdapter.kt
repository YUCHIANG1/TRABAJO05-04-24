package com.example.entregable02

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val productList = listOf(
        Product("Manzana", 23, "Frutas"),
        Product("Naranja", 15, "Frutas"),
        Product("Plátano", 20, "Frutas"),
        Product("Manzana", 23, "Frutas"),
        Product("Naranja", 15, "Frutas"),
        Product("Plátano", 20, "Frutas"),
        Product("Manzana", 23, "Frutas"),
        Product("Naranja", 15, "Frutas"),
        Product("Plátano", 20, "Frutas"),
        Product("Manzana", 23, "Frutas"),
        Product("Naranja", 15, "Frutas"),
        Product("Plátano", 20, "Frutas"),
        Product("Manzana", 23, "Frutas"),
        Product("Naranja", 15, "Frutas"),
        Product("Plátano", 20, "Frutas"),
        Product("Manzana", 23, "Frutas"),
        Product("Naranja", 15, "Frutas"),
        Product("Plátano", 20, "Frutas")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val product = productList[position]
        holder.productImageView.setImageResource(getImageResource(product.category))
        holder.productNameTextView.text = product.name
        holder.productPriceTextView.text = "Precio: $${product.price}"
        holder.productCategoryTextView.text = "Categoría: ${product.category}"
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImageView: ImageView = itemView.findViewById(R.id.productImageView)
        val productNameTextView: TextView = itemView.findViewById(R.id.productNameTextView)
        val productPriceTextView: TextView = itemView.findViewById(R.id.productPriceTextView)
        val productCategoryTextView: TextView = itemView.findViewById(R.id.productCategoryTextView)
        val sellButton: Button = itemView.findViewById(R.id.sellButton)

        init {
            sellButton.setOnClickListener {
                val fragmentManager = (itemView.context as AppCompatActivity).supportFragmentManager
                val salesDialog = SalesDialogFragment()
                salesDialog.show(fragmentManager, "SalesDialog")
            }
        }
    }

    data class Product(val name: String, val price: Int, val category: String)

    private fun getImageResource(category: String): Int {
        return when (category) {
            "Frutas" -> R.drawable.yuchi
            else -> R.drawable.yuchi
        }
    }
}
