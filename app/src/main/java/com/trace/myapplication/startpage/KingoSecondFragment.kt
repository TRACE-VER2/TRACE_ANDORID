package com.trace.myapplication.startpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.trace.myapplication.R
import com.trace.myapplication.databinding.FragmentChoosePreferBinding
import com.trace.myapplication.databinding.FragmentKingoSecondBinding
import kotlinx.android.synthetic.main.fragment_kingo_first.*
import kotlinx.android.synthetic.main.fragment_kingo_second.*


class KingoSecondFragment : Fragment() {
    private lateinit var binding: FragmentKingoSecondBinding
    val signUpViewModel by activityViewModels<SignUpViewModel>()


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
            if (signUpViewModel.verificationKey.toString()==binding.etKingoVerify.text.toString()){
                Toast.makeText(activity,"인증이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                view.findNavController().navigate(R.id.action_kingoSecondFragment_to_idSettingFragment)
            }
            else{
                Toast.makeText(activity,"인증에 실패하였습니다. 인증코드를 다시 확인해주세요.", Toast.LENGTH_SHORT).show()
            }

        }

        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}