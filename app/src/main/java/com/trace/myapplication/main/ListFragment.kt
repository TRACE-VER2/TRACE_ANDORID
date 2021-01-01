package com.trace.myapplication.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.trace.myapplication.R
import com.trace.myapplication.databinding.FragmentListBinding
import com.trace.myapplication.main.ListRecyclerView.ListPageAdapter
import com.trace.myapplication.main.ListRecyclerView.ListPageData
import kotlinx.android.synthetic.main.fragment_list.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    lateinit var listPageAdapter: ListPageAdapter
    var datas = mutableListOf<ListPageData>()

    //nav 도착하는 쪽 코드
    //val args: ListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment

        binding.listBtnSearch.setOnClickListener {
            view.findNavController().navigate(R.id.reviewFragment)
        }


        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //앞 fragment에서 addextra기능
        //tv_list_fragment.text=args.text
        listPageAdapter= ListPageAdapter(view.context)
        binding.rvListPage.adapter=listPageAdapter
        loadDatas()


//        btn_to_detail.setOnClickListener {
//            view.findNavController().navigate(R.id.action_listFragment_to_buildingDetailFragment)
//        }

    }

    private fun loadDatas(){
        datas = mutableListOf<ListPageData>()
        datas.apply {
            add(
                ListPageData(
                    address = "성북구 성북동 1가 범진빌리지a",
                    star = 4
                )
            )
            add(
                ListPageData(
                    address = "성북구 성북동 1가 범진빌리지b",
                    star = 2
                )
            )
        }
        listPageAdapter.datas=datas
        listPageAdapter.notifyDataSetChanged()
    }
}