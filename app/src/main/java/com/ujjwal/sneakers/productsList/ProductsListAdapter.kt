package com.ujjwal.sneakers.productsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ujjwal.sneakers.commonDataModels.ProductItem
import com.ujjwal.sneakers.databinding.ProductItemBinding
import com.ujjwal.sneakers.productsList.callBacks.ClickCallBacks

class SneakersListAdapter(
    private val sneakersList: List<ProductItem>,
    private val callBacks: ClickCallBacks
): RecyclerView.Adapter<SneakerViewHolder>()  {
    private lateinit var binding: ProductItemBinding




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SneakerViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        binding = ProductItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SneakerViewHolder(binding)
    }


    // binds the list items to a view
    override fun onBindViewHolder(holder: SneakerViewHolder, position: Int) {
        val itemsView = sneakersList[position]
        holder.bind(itemsView,callBacks)
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return sneakersList.size
    }

}
// Holds the views for adding it to image and text
class SneakerViewHolder(private val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(productItem: ProductItem, callBacks: ClickCallBacks){
        binding.item = productItem
        binding.callBack = callBacks
        binding.executePendingBindings()
    }
}



