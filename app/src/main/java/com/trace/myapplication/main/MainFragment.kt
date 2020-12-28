package com.trace.myapplication.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import com.trace.myapplication.R
import com.trace.myapplication.main.recyclerview.MainListAdapter
import com.trace.myapplication.main.recyclerview.MainListData
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {
    lateinit var mainlistAdapter: MainListAdapter
    var datas = mutableListOf<MainListData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainlistAdapter= MainListAdapter(view.context)
        rv_main_list.adapter=mainlistAdapter
        loadDatas()

    }

    private fun loadDatas(){
        datas.apply {
            add(
                MainListData(
                    address = "성북구 성북동 1가 범진빌리지",
                    star = 5
                )
            )
            add(
                MainListData(
                    address = "성북구 성북동 1가 범진빌리지 3",
                    star = 3
                )
            )
        }
        mainlistAdapter.datas=datas
        mainlistAdapter.notifyDataSetChanged()
    }

}

//        button_for_test_tolist.setOnClickListener {
//
//            //addextra보내기
//            val action=
//                MainFragmentDirections.actionMainFragmentToListFragment(
//                    "Hello ListFragment"
//                )
//            view.findNavController().navigate(action)
//
//        }
//
//        button_for_test_toreview.setOnClickListener {
//            view.findNavController().navigate(R.id.action_mainFragment_to_addReviewFragment)
//        }