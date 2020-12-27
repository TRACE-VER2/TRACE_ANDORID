package com.trace.myapplication.startpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.trace.myapplication.R
import kotlinx.android.synthetic.main.fragment_kingo_first.*


class KingoFirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kingo_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        kingofirst_btn_prev.setOnClickListener {
            view.findNavController().popBackStack()
        }
        kingofirst_btn_next.setOnClickListener {
            view.findNavController().navigate(R.id.action_kingoFirstFragment_to_kingoSecondFragment)
        }
    }
}