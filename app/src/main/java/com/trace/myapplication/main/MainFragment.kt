package com.trace.myapplication.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import com.trace.myapplication.R
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        button_for_test_tolist.setOnClickListener {
//
//            //addextra보내기
//            val action=
//                MainFragmentDirections.actionMainFragmentToListFragment(
//                    "Hello ListFragment"
//                )
//            view.findNavController().navigate(action)
//
//        }
//
//        button_for_test_toreview.setOnClickListener {
//            view.findNavController().navigate(R.id.action_mainFragment_to_addReviewFragment)
//        }
    }

}