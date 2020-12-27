package com.trace.myapplication.startpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.trace.myapplication.R
import com.trace.myapplication.databinding.ActivityLoginBinding
import com.trace.myapplication.databinding.FragmentChoosePreferBinding
import kotlinx.android.synthetic.main.fragment_choose_prefer.*

class ChoosePreferFragment : Fragment() {
    private lateinit var binding: FragmentChoosePreferBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentChoosePreferBinding.inflate(inflater, container, false)
        val view = binding.root
        //setContentView(view)

        binding.chooseBtnNext.setOnClickListener {
            view.findNavController().navigate(R.id.action_choosePreferFragment_to_userCheckFragment)
        }

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_choose_prefer, container, false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        //choose_btn_next.setOnClickListener {


    }

}