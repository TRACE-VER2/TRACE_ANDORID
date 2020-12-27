package com.trace.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.trace.myapplication.auth.AuthResource
import com.trace.myapplication.model.User

class SessionManager {
    companion object{
        const val TAG = "SessionManager"
    }

    val cachedUser = MediatorLiveData<AuthResource<User>>()

    fun authenticateWithId(source: LiveData<AuthResource<User>>){
        cachedUser.value = AuthResource.Loading(null)
        cachedUser.addSource(source){
            cachedUser.value = it
            cachedUser.removeSource(source)
        }
    }

    fun logout(){
        cachedUser.value = AuthResource.Logout()
    }
}