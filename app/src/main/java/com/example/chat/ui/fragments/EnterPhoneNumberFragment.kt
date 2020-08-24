package com.example.chat.ui.fragments

import androidx.fragment.app.Fragment
import com.example.chat.R
import com.example.chat.ui.utilits.replaceFragment
import com.example.chat.ui.utilits.showToast
import kotlinx.android.synthetic.main.fragment_enter_phone_number.*


class EnterPhoneNumberFragment : Fragment(R.layout.fragment_enter_phone_number) {
    override fun onStart() {
        super.onStart()
        register_btn_next.setOnClickListener { sendCode() }
    }


    private fun sendCode() {
        if(register_input_phone_numner.text.toString().isEmpty()){
            showToast(getString(R.string.register_enter_phone))
        }else{
            replaceFragment(EnterCodeFragment())

        }
    }
}