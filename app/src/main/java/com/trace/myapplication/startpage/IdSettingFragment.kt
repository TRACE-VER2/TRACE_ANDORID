package com.trace.myapplication.startpage

import android.content.Intent
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
import com.trace.myapplication.Server.RequestToServer
import com.trace.myapplication.databinding.FragmentChoosePreferBinding
import com.trace.myapplication.databinding.FragmentIdSettingBinding
import com.trace.myapplication.main.MainActivity
import com.trace.myapplication.startpage.dataType.RequestLogin
import com.trace.myapplication.startpage.dataType.RequestSignUp
import com.trace.myapplication.startpage.dataType.ResponseBasic
import com.trace.myapplication.startpage.dataType.ResponseLogin
import kotlinx.android.synthetic.main.fragment_id_setting.*
import kotlinx.android.synthetic.main.fragment_kingo_first.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class IdSettingFragment : Fragment() {
    private lateinit var binding: FragmentIdSettingBinding
    val signUpViewModel by activityViewModels<SignUpViewModel>()
    val requestToServer=RequestToServer
    var agree=false
    val prefString= mutableListOf<String>("#햇살가득","#벌레_없어요","#거의_독서실","#내방크기_운동장","#저렴해요")
    val prefEng= mutableListOf<String>("SUNNY","NO_BUG","QUIET","LARGE","CHEAP")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentIdSettingBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.etIdSetting.setText(signUpViewModel.userId.toString())

        //미리 preferences형식 바꿔놓기
        val preflist=mutableListOf<String>()
        for (pref in signUpViewModel.preferences){
            for (i in 0..4){
                if(pref.toString()==prefString[i]){
                    preflist.add(prefEng[i].toString())
                    break
                }
            }
        }


        //중복확인기능
        binding.signupBtnCheck.setOnClickListener {
            if (binding.etIdSetting.text.isNullOrBlank() ){
                Toast.makeText(activity,"사용하고자 하는 아이디를 입력해주세요", Toast.LENGTH_SHORT).show()
            }else {
                requestToServer.service.idCheckRequest(
                        "${binding.etIdSetting.text.toString()}"
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
                                Log.d("중복성공", response.body().toString())
                                Toast.makeText(activity,"이용가능한 아이디입니다.", Toast.LENGTH_SHORT).show()
                                signUpViewModel.userId=binding.etIdSetting.text.toString()

                            } else {
                                Log.d("중복실패", "실패")
                                Toast.makeText(activity,"사용할 수 없는 아이디입니다. 다른 아이디를 사용해주세요.", Toast.LENGTH_SHORT).show()

                            }
                        }
                    }
                })

            }
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
        binding.signupBtnLast.setOnClickListener {


            if (binding.etSetPassword.text.isNullOrBlank() || binding.etSetPasswordCheck.text.isNullOrBlank() || binding.etIdSetting.text.isNullOrBlank()) {
                Toast.makeText(activity, "빈칸을 모두 입력하세요.", Toast.LENGTH_SHORT).show()
            }else if (binding.etSetPassword.text.toString() != binding.etSetPasswordCheck.text.toString()) {
                Log.d("확인","${binding.etSetPassword.text.toString()} 그리고 ${binding.etSetPasswordCheck.text.toString()}")
                Toast.makeText(activity, "비밀번호와 비밀번호 확인란이 동일하지 않습니다", Toast.LENGTH_SHORT).show()
            }else if (binding.etIdSetting.text.toString() != signUpViewModel.userId.toString()) {
                Toast.makeText(activity, "아이디 중복체크를 먼저 해주세요", Toast.LENGTH_SHORT).show()
            } else if (!agree) {
                Toast.makeText(activity, "서비스 이용약관에 동의해 주세요", Toast.LENGTH_SHORT).show()
            }else {
                Log.d("요청", "가입요청")
                Log.d("요청","${binding.etIdSetting.text.toString()} and ${binding.etSetPasswordCheck.text.toString()} and ${signUpViewModel.email} " +
                        "and ${signUpViewModel.username} and ${signUpViewModel.phoneNum} and ${preflist.toTypedArray().toString()}")

                //회원가입 요청
                requestToServer.service.signUpRequest(
                        RequestSignUp(
                                userId = binding.etIdSetting.text.toString(),
                                password = binding.etSetPasswordCheck.text.toString(),
                                email = signUpViewModel.email,
                                name=signUpViewModel.username,
                                phoneNum = signUpViewModel.phoneNum,
                                preferences = preflist.toTypedArray()
                        )   //로그인 정보를 전달
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
                                Toast.makeText(activity, "회원가입에 성공했습니다.", Toast.LENGTH_SHORT).show()
                                activity!!.finish()

                            } else {
                                Log.d("실패", "실패")
                                Toast.makeText(activity, "회원가입에 실패했습니다. 잠시후에 다시 시도해주세요.", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }

        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }
}