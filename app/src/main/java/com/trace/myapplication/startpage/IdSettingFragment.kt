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
import kotlinx.android.synthetic.main.fragment_id_setting.*
import kotlinx.android.synthetic.main.fragment_kingo_first.*


class IdSettingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_id_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signup_btn_last.setOnClickListener {
            startActivity(Intent(activity, LoginActivity::class.java))
            activity!!.finish()
        }
        signup_btn_check.setOnClickListener {
            Toast.makeText(activity,"사용할 수 있는 아이디 입니다.", Toast.LENGTH_SHORT).show()
        }
    }
}