package com.trace.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_main.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class ListFragment : Fragment() {
    //nav 도착하는 쪽 코드
    val args: ListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    //앞 fragment에서 addextra기능
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tv_list_fragment.text=args.text

        btn_to_detail.setOnClickListener {
            view.findNavController().navigate(R.id.action_listFragment_to_buildingDetailFragment)
        }

    }

}