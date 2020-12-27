package com.trace.myapplication.startpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.trace.myapplication.R
import com.trace.myapplication.databinding.FragmentChoosePreferBinding
import com.trace.myapplication.databinding.FragmentKingoFirstBinding
import kotlinx.android.synthetic.main.fragment_kingo_first.*


class KingoFirstFragment : Fragment() {
    private lateinit var binding: FragmentKingoFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentKingoFirstBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.kingofirstBtnPrev.setOnClickListener {
            view.findNavController().popBackStack()
        }
        binding.kingofirstBtnNext.setOnClickListener {
            view.findNavController().navigate(R.id.action_kingoFirstFragment_to_kingoSecondFragment)
        }

        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}