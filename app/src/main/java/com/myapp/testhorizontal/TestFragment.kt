package com.myapp.testhorizontal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.myapp.testhorizontal.databinding.FragmentTestBinding

class TestFragment: Fragment() {
    private var text: String? = null
    private val binding by lazy { FragmentTestBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.text.text = text
    }

    companion object {
        fun newInstance(text: String): TestFragment = TestFragment().apply { this.text = text }
    }
}
