package com.example.daggerhiltintoduction


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.daggerhiltintoduction.databinding.ProductItemBinding
import com.example.daggerhiltintoduction.model.ProductItem



class ProductListAdapter(private val productList : List<ProductItem> ) : RecyclerView.Adapter<ProductListAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding : ProductItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =  ProductItemBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, @SuppressLint("RecyclerView") position: Int) {
        with(holder){
            with(productList[position]){
                binding.productItemTitleTv.text  = this.title
                binding.productItemAmtTv.text = this.price.toString()
                Glide.with(itemView).load(this.image).into(binding.productItemIv)
            }
        }

    }


    override fun getItemCount(): Int {
        return productList.size
    }
}