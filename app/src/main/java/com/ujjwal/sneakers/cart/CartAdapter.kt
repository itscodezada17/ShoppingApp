package com.ujjwal.sneakers.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ujjwal.sneakers.cart.callBacks.CartCallBacks
import com.ujjwal.sneakers.commonDataModels.ProductItem
import com.ujjwal.sneakers.databinding.CartItemBinding

class CartAdapter(
    private val cartList: List<ProductItem>,
    private val callBacks: CartCallBacks
): RecyclerView.Adapter<SneakerViewHolder>()  {
    private lateinit var binding: CartItemBinding




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SneakerViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        binding = CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SneakerViewHolder(binding)
    }


    // binds the list items to a view
    override fun onBindViewHolder(holder: SneakerViewHolder, position: Int) {
        val itemsView = cartList[position]
        holder.bind(itemsView,callBacks)
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return cartList.size
    }

}
// Holds the views for adding it to image and text
class SneakerViewHolder(private val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(productItem: ProductItem, callBacks: CartCallBacks){
        binding.item = productItem
        binding.callBack = callBacks
        binding.executePendingBindings()
    }
}



