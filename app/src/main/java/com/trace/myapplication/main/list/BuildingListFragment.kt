package com.trace.myapplication.main.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.trace.myapplication.R
import com.trace.myapplication.databinding.FragmentBuildingListBinding
import com.trace.myapplication.network.Repository
import com.trace.myapplication.main.dataType.ResponseMainList
import com.trace.myapplication.startpage.myjwt
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class BuildingListFragment : Fragment() {
    private lateinit var binding: FragmentBuildingListBinding
    lateinit var buildingListPageAdapter: BuildingListPageAdapter
    var datas = mutableListOf<BuildingListPageData>()
    val requestToServer = Repository

    //nav 도착하는 쪽 코드
    val args: BuildingListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBuildingListBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment
        var tmptitle="건물정보-"
        //tmptitle += args.title
        binding.tvListTitle.text=tmptitle

        //Log.d("도착","$args")
        binding.listBtnSearch.setOnClickListener {
            view.findNavController().navigate(R.id.reviewFragment)
        }
        binding.listBtnBack.setOnClickListener{
            view.findNavController().popBackStack()
        }


        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //앞 fragment에서 addextra기능
        //tv_list_fragment.text=args.text
        buildingListPageAdapter= BuildingListPageAdapter(view.context)
        binding.rvListPage.adapter=buildingListPageAdapter
        loadDatas()
    }

    private fun loadDatas(){
        var tmpjwt:String= "Bearer "+ myjwt
        var tmpaddress: String
        var tmpstar=4
        Log.d("loadDatas", "함수진입+ ${tmpjwt}")
        datas = mutableListOf<BuildingListPageData>()
        var tmppath=args.text
        Log.d("path:", "$tmppath")

        requestToServer.service.listPageRequest(
                "${tmpjwt}", "${tmppath}"
        ).enqueue(object : Callback<ResponseMainList> {
            override fun onFailure(call: Call<ResponseMainList>, t: Throwable) {
                Log.d("통신 실패", "${t.message }")
            }

            override fun onResponse(
                    call: Call<ResponseMainList>,
                    response: Response<ResponseMainList>
            ) {
                if (response.isSuccessful) {
                    if (response.body()!!.success) {
                        Log.d("성공", response.body()!!.data.toString())
                        for (i in 0 until response.body()!!.data!!.content.size){
                            tmpaddress=response.body()!!.data!!.content[i].address
                            tmpaddress += response.body()!!.data!!.content[i].lotNumber

                            datas.apply{
                                add(BuildingListPageData(
                                        address = tmpaddress,
                                        star = tmpstar
                                ))
                            }

                        }
                        buildingListPageAdapter.datas=datas
                        buildingListPageAdapter.notifyDataSetChanged()
                    } else {
                        Log.d("실패", "실패")
                    }
                }
            }
        })


    }
    /*
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

     */
}