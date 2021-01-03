package com.trace.myapplication.startpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.trace.myapplication.R
import com.trace.myapplication.databinding.FragmentChoosePreferBinding


class ChoosePreferFragment : Fragment() {
    private lateinit var binding: FragmentChoosePreferBinding
    val signUpViewModel by activityViewModels<SignUpViewModel>()

    var hashtag= mutableSetOf<String>()

    var tags= arrayListOf(false, false, false, false, false)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentChoosePreferBinding.inflate(inflater, container, false)
        val view = binding.root
        //setContentView(view)


        binding.chooseBtnNext.setOnClickListener {
            if (hashtag.size!=2){
                Toast.makeText(activity,"취향을 두가지 선택해 주세요", Toast.LENGTH_SHORT).show()
            }else {
                signUpViewModel.preferences = hashtag.toMutableList()
                view.findNavController().navigate(R.id.action_choosePreferFragment_to_userCheckFragment)
            }
        }


        var buttons= mutableListOf<TextView>(binding.tvHashtag1, binding.tvHashtag2, binding.tvHashtag3, binding.tvHashtag4, binding.tvHashtag5)
        var i=0
        hashtag=signUpViewModel.preferences.toMutableSet()
        if (hashtag.size!=0){
            for (tag in hashtag){
                for (i in 0..4){
                    if (tag.toString()==buttons[i].text.toString()){
                        tags[i]=true
                        break
                    }
                }
            }
            binding.tvHashtagResult.text=hashtag.joinToString()
        }
        for (i in 0..4){
            buttons[i].setOnClickListener {
                if (tags[i]){
                    tags[i]=false
                    hashtag.remove(buttons[i].text.toString())
                    //buttons[i].highlightColor
                }
                else{
                    if(hashtag.size==2){
                        Toast.makeText(activity, "최대 2개 선택할 수 있습니다.",Toast.LENGTH_SHORT).show()
                    }
                    else {
                        tags[i] = true
                        hashtag.add(buttons[i].text.toString())
                    }
                }
                binding.tvHashtagResult.text=hashtag.joinToString()

            }
        }




        // Inflate the layout for this fragment
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //choose_btn_next.setOnClickListener {

    }


}