package com.trace.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.trace.myapplication.R
import com.trace.myapplication.databinding.FragmentReviewBinding

class ReviewFragment: Fragment() {
    private lateinit var _vBinding: FragmentReviewBinding
    private val vBinding
        get() = _vBinding

    private val parent by lazy{requireActivity()}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _vBinding = FragmentReviewBinding.inflate(inflater, container, false)
        return vBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBuildingInfo()
        setReviewList()
        setRV()
    }

    private fun setBuildingInfo(){
    }

    private fun setReviewList(){
        parent.supportFragmentManager.beginTransaction()
            .add(R.id.frame_under_building_info, ReviewListFragment())
            .addToBackStack(null)
            .commit()
    }

    private fun setUserReview(){
        parent.supportFragmentManager.beginTransaction()
            .add(R.id.frame_under_building_info, UserReviewFragment())
            .addToBackStack(null)
            .commit()
    }

    private fun setRV(){
    }
}