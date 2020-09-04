package com.example.chat.ui.fragments

import androidx.fragment.app.Fragment
import com.example.chat.MainActivity


open class BaseFragment(val layout:Int): Fragment(layout) {


    override fun onStart() {
        super.onStart()
        //когда запускается любой фрагмент и отключит драйвер
        (activity as MainActivity).mainAppDrawer.disableDrawer()
    }

    override fun onStop() {
        super.onStop()
        (activity as MainActivity).mainAppDrawer.enableDrawer()
    }
}