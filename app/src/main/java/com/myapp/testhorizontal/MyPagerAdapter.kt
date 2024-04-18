package com.myapp.testhorizontal

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = 2 // Number of pages

    override fun createFragment(position: Int): Fragment {
        // Create and return your fragment for each page
        return TestFragment.newInstance(position.toString())
    }
}