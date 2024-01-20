package com.ujjwal.sneakers.productsDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.ujjwal.sneakers.commonDataModels.ProductItem
import com.ujjwal.sneakers.databinding.FragmentProductsDetailBinding
import com.ujjwal.sneakers.productsDetails.clickCallBacks.ProductDetailsCallBack
import com.ujjwal.sneakers.utilities.EventObserver
import com.ujjwal.sneakers.utilities.navigateBack
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {

    private lateinit var _binding: FragmentProductsDetailBinding
    val binding get() = _binding

    @Inject
    lateinit var factory: ProductDetailsViewModelFactory

    private val args: ProductDetailsFragmentArgs by navArgs()

    private val productDetailsViewModel: ProductDetailsViewModel by viewModels{
        ProductDetailsViewModel.provideFactory(factory, args.productId)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductsDetailBinding.inflate(inflater, container, false )
        _binding.lifecycleOwner = viewLifecycleOwner
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setBackListener()
        setNavigationButton()
        setObservers()
    }

    override fun onResume() {
        super.onResume()
        productDetailsViewModel.refreshData()
    }

    private fun setUi(productDetail: ProductItem) {
        val callBacks =  ProductDetailsCallBack(productDetailsViewModel)
        _binding.callBack = callBacks
        _binding.item = productDetail
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
        productDetailsViewModel.addToCartLiveData.observe(viewLifecycleOwner,EventObserver{
            Toast.makeText(requireContext(),"Added To Cart",Toast.LENGTH_SHORT).show()
        })


        productDetailsViewModel.productDetailResponseModel.observe(viewLifecycleOwner, Observer {
            setUi(it)
        })
    }
}