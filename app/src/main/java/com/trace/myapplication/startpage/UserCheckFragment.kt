package com.trace.myapplication.startpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.trace.myapplication.R
import kotlinx.android.synthetic.main.fragment_user_check.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UserCheckFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserCheckFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_check, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        usercheck_btn_prev.setOnClickListener {
            view.findNavController().popBackStack()
        }
        usercheck_btn_next.setOnClickListener {
            view.findNavController().navigate(R.id.action_userCheckFragment_to_kingoFirstFragment)
        }
    }
}