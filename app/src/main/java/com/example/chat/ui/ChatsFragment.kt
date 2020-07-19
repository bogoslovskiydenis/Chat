package com.example.chat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chat.R
import com.example.chat.databinding.FragmentChatsBinding


class ChatsFragment : Fragment() {
    private lateinit var mainBinding: FragmentChatsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       mainBinding = FragmentChatsBinding.inflate(layoutInflater)
        return mainBinding.root
    }

    override fun onResume() {
        super.onResume()
    }
}