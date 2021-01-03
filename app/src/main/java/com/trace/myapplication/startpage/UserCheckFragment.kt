package com.trace.myapplication.startpage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.trace.myapplication.R
import com.trace.myapplication.server.Repository
import com.trace.myapplication.databinding.FragmentUserCheckBinding
import com.trace.myapplication.startpage.dataType.ResponseBasic
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserCheckFragment : Fragment() {
    private lateinit var binding: FragmentUserCheckBinding
    val signUpViewModel by activityViewModels<SignUpViewModel>()
    val requestToServer = Repository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentUserCheckBinding.inflate(inflater, container, false)
        val view= binding.root
        binding.usercheckEtPh.setText(signUpViewModel.phoneNum.toString())
        binding.usercheckEtId.setText(signUpViewModel.username)
        binding.usercheckBtnPrev.setOnClickListener {
            view.findNavController().popBackStack()
        }
        binding.usercheckBtnNext.setOnClickListener {
            if (binding.usercheckEtId.text.isNullOrBlank() || binding.usercheckEtPh.text.isNullOrBlank()){
                Toast.makeText(activity,"빈칸을 모두 채워주세요", Toast.LENGTH_SHORT).show()
            }else {
                signUpViewModel.phoneNum=binding.usercheckEtPh.text.toString()
                signUpViewModel.username=binding.usercheckEtId.text.toString()

                requestToServer.service.ismemberRequest(
                        "${binding.usercheckEtId.text.toString()}","${binding.usercheckEtPh.text.toString()}"
                ).enqueue(object : Callback<ResponseBasic> {
                    override fun onFailure(call: Call<ResponseBasic>, t: Throwable) {
                        Log.d("통신 실패", "${t.message }")
                    }

                    override fun onResponse(
                            call: Call<ResponseBasic>,
                            response: Response<ResponseBasic>
                    ) {
                        if (response.isSuccessful) {
                            if (response.body()!!.success) {
                                Log.d("성공", response.body().toString())
                                Toast.makeText(activity,"회원가입 가능합니다.", Toast.LENGTH_SHORT).show()
                                view.findNavController().navigate(R.id.action_userCheckFragment_to_kingoFirstFragment)


                            } else {
                                Log.d("실패", "실패")
                                Toast.makeText(activity,"이미 가입된 회원입니다. 로그인해주세요.", Toast.LENGTH_SHORT).show()
                                activity!!.finish()
                            }
                        }
                    }
                })

            }
        }

        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}