package com.myapp.testhorizontal

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.MobileAds
import com.myapp.testhorizontal.databinding.ActivitySecondBinding

class SecondActivity: AppCompatActivity() {
    private val binding by lazy { ActivitySecondBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("tag111", "create")
        setContentView(binding.root)
        binding.rv.adapter = RvAdapter()

        binding.rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val a = (binding.rv.layoutManager as? LinearLayoutManager)?.findLastCompletelyVisibleItemPosition() ?: 0
                Log.v("tag111", "aaaa: $a")
                if (a < 0 ) {
                    return
                }
                if (a == 0) {
                    binding.first.backgroundTintList = ColorStateList.valueOf(Color.RED)
                    binding.second.backgroundTintList = ColorStateList.valueOf(Color.BLACK)
                } else {
                    binding.second.backgroundTintList = ColorStateList.valueOf(Color.RED)
                    binding.first.backgroundTintList = ColorStateList.valueOf(Color.BLACK)
                }
            }
        })
    }

    override fun onStart() {
        super.onStart()
        Log.v("tag111", "activity started $this")
    }
}