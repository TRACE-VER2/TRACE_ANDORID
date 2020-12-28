package com.trace.myapplication.startpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.trace.myapplication.R
import com.trace.myapplication.databinding.FragmentChoosePreferBinding
import com.trace.myapplication.databinding.FragmentUserCheckBinding
import kotlinx.android.synthetic.main.fragment_user_check.*

class UserCheckFragment : Fragment() {
    private lateinit var binding: FragmentUserCheckBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentUserCheckBinding.inflate(inflater, container, false)
        val view= binding.root

        binding.usercheckBtnPrev.setOnClickListener {
            view.findNavController().popBackStack()
        }
        binding.usercheckBtnNext.setOnClickListener {
            view.findNavController().navigate(R.id.action_userCheckFragment_to_kingoFirstFragment)
        }

        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}