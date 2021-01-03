package com.trace.myapplication.startpage

import androidx.lifecycle.ViewModel

class SignUpViewModel: ViewModel(){
    var preferences=mutableListOf<String>()
    var userId=""
    var password=""
    var email=""
    var username=""
    var phoneNum=""
    var verificationKey=""
}