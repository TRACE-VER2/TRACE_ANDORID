package com.trace.myapplication.startpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.trace.myapplication.R
import com.trace.myapplication.databinding.FragmentChoosePreferBinding
import com.trace.myapplication.databinding.FragmentKingoSecondBinding
import kotlinx.android.synthetic.main.fragment_kingo_first.*
import kotlinx.android.synthetic.main.fragment_kingo_second.*


class KingoSecondFragment : Fragment() {
    private lateinit var binding: FragmentKingoSecondBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKingoSecondBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.kingosecondBtnPrev.setOnClickListener {
            view.findNavController().popBackStack()
        }
        binding.kingosecondBtnNext.setOnClickListener {
            view.findNavController().navigate(R.id.action_kingoSecondFragment_to_idSettingFragment)
        }

        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}