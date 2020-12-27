package com.trace.myapplication.startpage

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.trace.myapplication.R
import com.trace.myapplication.databinding.FragmentChoosePreferBinding
import com.trace.myapplication.databinding.FragmentIdSettingBinding
import kotlinx.android.synthetic.main.fragment_id_setting.*
import kotlinx.android.synthetic.main.fragment_kingo_first.*


class IdSettingFragment : Fragment() {
    private lateinit var binding: FragmentIdSettingBinding
    var agree=false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentIdSettingBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.signupBtnLast.setOnClickListener {
            startActivity(Intent(activity, LoginActivity::class.java))
            activity!!.finish()
        }
        binding.signupBtnCheck.setOnClickListener {
            Toast.makeText(activity,"사용할 수 있는 아이디 입니다.", Toast.LENGTH_SHORT).show()
        }
        binding.signupBtnAgree.setOnClickListener{
            agree = if(agree){

                binding.signupBtnAgree.setImageResource(R.drawable.btn_agree_unpick)
                false
            } else{
                Toast.makeText(activity,"동의", Toast.LENGTH_SHORT).show()
                binding.signupBtnAgree.setImageResource(R.drawable.btn_agree_pick)
                true
            }
        }
        binding.idsettingBtnPrev.setOnClickListener {
            view.findNavController().popBackStack()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }
}