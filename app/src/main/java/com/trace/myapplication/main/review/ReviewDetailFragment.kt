package com.trace.myapplication.main.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.trace.myapplication.databinding.FragmentReviewBinding
import com.trace.myapplication.databinding.FragmentUserReviewBinding

class ReviewDetailFragment: Fragment() {

    private lateinit var _vBinding: FragmentUserReviewBinding
    private val vBinding
        get() = _vBinding

    private val parent by lazy{requireActivity()}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _vBinding = FragmentUserReviewBinding.inflate(inflater, container, false)
        return vBinding.root
    }
}