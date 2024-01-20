package com.ujjwal.sneakers.cart

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.ujjwal.sneakers.cart.callBacks.CartCallBacks
import com.ujjwal.sneakers.commonDataModels.ProductItem
import com.ujjwal.sneakers.databinding.FragmentCartBinding
import com.ujjwal.sneakers.utilities.EventObserver
import com.ujjwal.sneakers.utilities.navigate
import com.ujjwal.sneakers.utilities.navigateBack
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment() {
    private lateinit var _binding: FragmentCartBinding
    val binding get() = _binding

    private val cartViewModel: CartViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setBinding()
        setBackListener()
        setNavigationButton()
        setObservers()
    }

    private fun setBinding() {
        val callBacks = CartCallBacks(cartViewModel)
        binding.callBack = callBacks
    }

    @SuppressLint("SetTextI18n")
    private fun setObservers() {
        cartViewModel.navDirections.observe(viewLifecycleOwner, EventObserver{
            navigate(it)
        })
        cartViewModel.cartLiveData.observe(viewLifecycleOwner) {
            setRecyclerView(it)
            binding.priceTv.text = getTotalPrice(it).toString()
        }

        cartViewModel.snackBarLiveData.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })
    }

    private fun setRecyclerView(cartList: List<ProductItem>) {
        val callBacks =  CartCallBacks(cartViewModel)
        val recyclerViewSneakers = binding.courseDetailsRecyclerView
        val newsAdapter = CartAdapter(cartList,callBacks)

        recyclerViewSneakers.adapter = newsAdapter
        recyclerViewSneakers.layoutManager = LinearLayoutManager(this.context)
        recyclerViewSneakers.setHasFixedSize(true)
    }

    private val backPressedCallback: OnBackPressedCallback =
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                navigateBack()
            }
        }

    private fun setBackListener() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            backPressedCallback
        )
    }
    private fun setNavigationButton() {
        binding.tabLayout.setNavigationOnClickListener { navigateBack() }
    }

    private fun getTotalPrice(list: List<ProductItem>): Float{
        var total: Float = 0F
        for(item in list){
            item.retailPrice?.let {
                total += it
            }
        }
        return total
    }

}