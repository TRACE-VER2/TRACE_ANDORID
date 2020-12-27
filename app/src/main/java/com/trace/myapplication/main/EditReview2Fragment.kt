package com.trace.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.trace.myapplication.databinding.FragmentEditReview1Binding
import com.trace.myapplication.databinding.FragmentEditReview2Binding

class EditReview2Fragment: Fragment() {
    private lateinit var _vBinding: FragmentEditReview2Binding
    private val vBinding
        get() = _vBinding

    private val parent by lazy{requireActivity()}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _vBinding = FragmentEditReview2Binding.inflate(inflater, container, false)
        return vBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBtn()
    }

    private fun setBtn(){
        vBinding.btnPrevious.setOnClickListener{
            findNavController().popBackStack()
        }
    }
}