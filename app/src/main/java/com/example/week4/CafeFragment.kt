package com.example.week4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class CafeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Meng-inflate layout untuk fragment ini
        return inflater.inflate(R.layout.fragment_cafe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi ViewPager dan TabLayout
        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager)
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)

        // Set adapter untuk ViewPager
        val adapter = CafePagerAdapter(requireContext(), childFragmentManager, lifecycle)
        viewPager.adapter = adapter

        // Sinkronisasi antara TabLayout dan ViewPager
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = resources.getString(cafeTitles[position])
        }.attach()
    }
}
