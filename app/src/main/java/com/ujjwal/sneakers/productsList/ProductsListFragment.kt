package com.ujjwal.sneakers.productsList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.ujjwal.sneakers.productsList.callBacks.ClickCallBacks
import com.ujjwal.sneakers.commonDataModels.ProductItem
import com.ujjwal.sneakers.databinding.FragmentProductListBinding
import com.ujjwal.sneakers.utilities.EventObserver
import com.ujjwal.sneakers.utilities.navigate
import com.ujjwal.sneakers.utilities.navigateBack
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsListFragment : Fragment() {

    private lateinit var _binding: FragmentProductListBinding
    val binding get() = _binding

    val productsListViewModel: ProductsListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductListBinding.inflate(inflater, container, false )
        _binding.lifecycleOwner = viewLifecycleOwner
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setNavigationButton()
        setBackListener()
        setObservers()
    }

    private fun setRecyclerView(sneakersList: List<ProductItem>) {
        val callBacks =  ClickCallBacks(productsListViewModel)
        val recyclerViewSneakers = binding.courseDetailsRecyclerView
        val newsAdapter = SneakersListAdapter(sneakersList,callBacks)

        recyclerViewSneakers.adapter = newsAdapter
        recyclerViewSneakers.layoutManager = GridLayoutManager(this.context,2)
        recyclerViewSneakers.setHasFixedSize(true)
    }

    private fun setNavigationButton() {
        binding.tabLayout.setNavigationOnClickListener { navigateBack() }
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


    private fun setObservers() {
        productsListViewModel.navDirections.observe(viewLifecycleOwner,EventObserver{
             navigate(it)
        })
        productsListViewModel.productsListLiveData.observe(viewLifecycleOwner, Observer {
            setRecyclerView(it)
        })
        productsListViewModel.addToCartLiveData.observe(viewLifecycleOwner,EventObserver{
            Toast.makeText(requireContext(),"Added To Cart", Toast.LENGTH_SHORT).show()
        })
    }


}