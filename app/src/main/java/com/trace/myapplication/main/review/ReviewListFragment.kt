package com.trace.myapplication.main.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.trace.myapplication.databinding.FragmentReviewListBinding

class ReviewListFragment: Fragment() {
    private lateinit var _vBinding: FragmentReviewListBinding
    private val vBinding
        get() = _vBinding

    private val rViewModel by lazy{ ViewModelProvider(this).get(ReviewViewModel::class.java) }
    private val parent by lazy{requireActivity()}
    private val rAdapter by lazy{ ReviewListAdapter() }

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

        //TODO("for test")
        rAdapter.thumbnails = listOf(
                rViewModel.fakeApi.getReview("jonathan"),
                rViewModel.fakeApi.getReview("jungmin"))
        rAdapter.notifyDataSetChanged()
    }

    private fun setRV(){
        rAdapter.setHasStableIds(true)

        vBinding.rvReviewList.apply{
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = rAdapter
        }
    }
}