package com.trace.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.trace.myapplication.databinding.FragmentReviewBinding
import com.trace.myapplication.databinding.FragmentReviewListBinding

class ReviewListFragment: Fragment() {
    private lateinit var _vBinding: FragmentReviewListBinding
    private val vBinding
        get() = _vBinding

    private val parent by lazy{requireActivity()}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _vBinding = FragmentReviewListBinding.inflate(inflater, container, false)
        return vBinding.root
    }
}