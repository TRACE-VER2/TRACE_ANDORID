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
import com.trace.myapplication.network.Repository
import com.trace.myapplication.databinding.FragmentKingoFirstBinding
import com.trace.myapplication.startpage.dataType.ResponseKingo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class KingoFirstFragment : Fragment() {
    private lateinit var binding: FragmentKingoFirstBinding
    val requestToServer= Repository
    val signUpViewModel by activityViewModels<SignUpViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentKingoFirstBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.etKingoEmail.setText(signUpViewModel.email.toString())

        binding.kingofirstBtnPrev.setOnClickListener {
            view.findNavController().popBackStack()
        }
        binding.kingofirstBtnNext.setOnClickListener {
            if (binding.etKingoEmail.text.isNullOrBlank()){
                Toast.makeText(activity,"빈칸을 모두 채워주세요", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(activity,"메일 요청중 입니다. 잠시만 기다려주세요.", Toast.LENGTH_SHORT).show()


                requestToServer.service.kingoRequest(
                        "${binding.etKingoEmail.text.toString()}"
                ).enqueue(object : Callback<ResponseKingo> {
                    override fun onFailure(call: Call<ResponseKingo>, t: Throwable) {
                        Log.d("통신 실패", "${t.message }")
                    }

                    override fun onResponse(
                            call: Call<ResponseKingo>,
                            response: Response<ResponseKingo>
                    ) {
                        if (response.isSuccessful) {
                            if (response.body()!!.success) {
                                Log.d("성공", response.body().toString())
                                Toast.makeText(activity,"메일이 발송되었습니다.", Toast.LENGTH_SHORT).show()
                                signUpViewModel.verificationKey=response.body()!!.data!!.verificationKey.toString()
                                signUpViewModel.email=binding.etKingoEmail.text.toString()
                                view.findNavController().navigate(R.id.action_kingoFirstFragment_to_kingoSecondFragment)

                            } else {
                                Log.d("실패", "실패")
                                Toast.makeText(activity,"메일발송에 실패하였습니다. 다시 시도해주세요", Toast.LENGTH_SHORT).show()
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