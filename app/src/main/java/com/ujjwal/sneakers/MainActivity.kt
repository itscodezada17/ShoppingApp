package com.ujjwal.sneakers

import android.app.UiModeManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.ujjwal.sneakers.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {

        //set dark mode according to settings
        val uiManager: UiModeManager = this.getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
        uiManager.nightMode= UiModeManager.MODE_NIGHT_YES

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
        setBottomNavigation()
    }




    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragmentMainActivity)
        navController = navHostFragment?.findNavController()!!
        NavigationUI.setupWithNavController(
            binding.mainBottomNavigation,
            navController
        )

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.cartFragment || destination.id == R.id.productsListFragment || destination.id == R.id.productDetailFragment ) {
                binding.mainBottomNavigation.visibility = View.VISIBLE
            } else {
                binding.mainBottomNavigation.visibility = View.GONE
            }
        }
    }
    private fun setBottomNavigation() {
        binding.mainBottomNavigation.setOnItemSelectedListener { item ->
            if (item.itemId != binding.mainBottomNavigation.selectedItemId) { }
            NavigationUI.onNavDestinationSelected(item, navController)
            when (item.itemId) {
                R.id.productsListFragment -> {
                    navController.navigate(R.id.productsListFragment)
                    Timber.d("SneakersListFragment from bottom navigation")
                }
                R.id.cartFragment -> {
                    navController.navigate(R.id.cartFragment)
                    Timber.d("CartFragment from bottom navigation")
                }
                else -> {
                    item.isChecked = false
                }
            }
            true
        }
    }

}