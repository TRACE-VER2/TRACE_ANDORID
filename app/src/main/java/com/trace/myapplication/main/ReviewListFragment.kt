package com.trace.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.trace.myapplication.databinding.FragmentReviewListBinding
import com.trace.myapplication.model.ReviewThumbnail

class ReviewListFragment: Fragment() {
    private lateinit var _vBinding: FragmentReviewListBinding
    private val vBinding
        get() = _vBinding

    private val parent by lazy{requireActivity()}
    private val rAdapter by lazy{ReviewListAdapter()}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _vBinding = FragmentReviewListBinding.inflate(inflater, container, false)
        return vBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRV()

        rAdapter.thumbnails = listOf(ReviewThumbnail(), ReviewThumbnail())
        rAdapter.notifyDataSetChanged()
    }

    private fun setRV(){
        vBinding.rvReviewList.apply{
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = rAdapter
        }
    }
}