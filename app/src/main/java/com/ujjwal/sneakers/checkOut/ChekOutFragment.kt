package com.ujjwal.sneakers.checkOut

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import com.ujjwal.sneakers.databinding.FragmentChekOutBinding
import com.ujjwal.sneakers.utilities.navigateBack


class ChekOutFragment : Fragment() {
    private lateinit var _binding: FragmentChekOutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChekOutBinding.inflate(inflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setBackListener()
        openPdfUsingWebView()
        openPdfUsingLibrary()
    }

    private fun openPdfUsingLibrary() {
       // _binding.pdfViewLibrary.fromUri("https://www.africau.edu/images/default/sample.pdf".toUri())
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun openPdfUsingWebView() {
        val webView = _binding.webView
        val url = "https://www.africau.edu/images/default/sample.pdf"
        webView.webViewClient = WebViewClient()
        webView.settings.setSupportZoom(true)
        webView.settings.javaScriptEnabled = true
        webView.settings.loadWithOverviewMode = true;
        webView.settings.useWideViewPort = true;
        webView.settings.builtInZoomControls = true;
        webView.settings.setSupportZoom(true);
        webView.loadUrl("https://docs.google.com/gview?embedded=true&url=$url")
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
}