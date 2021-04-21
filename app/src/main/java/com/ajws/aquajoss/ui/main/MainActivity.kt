package com.ajws.aquajoss.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ajws.aquajoss.R
import com.ajws.aquajoss.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var oldTab: Int = 0
    private var currentTab: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        binding.navigation.selectedItemId = R.id.navigation_home
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            currentTab = item.itemId
            when (currentTab) {
                R.id.navigation_home -> {
                    return@OnNavigationItemSelectedListener setFragment(HomeFragment())
                }
                R.id.navigation_cart -> {
                    return@OnNavigationItemSelectedListener setFragment(CartFragment())
                }
                R.id.navigation_order_history -> {
                    return@OnNavigationItemSelectedListener setFragment(OrderHistoryFragment())
                }
                R.id.navigation_profile -> {
                    return@OnNavigationItemSelectedListener setFragment(ProfileFragment())
                }
            }
            false
        }

    private fun setFragment(fragment: Fragment): Boolean {
        if (oldTab != currentTab) {
            oldTab = currentTab
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment).commitAllowingStateLoss()
            return true
        }
        return false
    }
}