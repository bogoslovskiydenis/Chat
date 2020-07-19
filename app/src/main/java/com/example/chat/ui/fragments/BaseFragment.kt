package com.example.chat.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chat.R


open class BaseFragment(val layout:Int): Fragment() {

    private lateinit var mainRootView :View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       mainRootView = inflater.inflate(layout,container,false)
    return mainRootView
    }

    override fun onStart() {
        super.onStart()
    }
}