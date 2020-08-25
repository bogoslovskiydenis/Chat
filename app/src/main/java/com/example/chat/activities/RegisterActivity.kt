package com.example.chat.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chat.R
import com.example.chat.databinding.ActivityRegisterBinding
import com.example.chat.ui.fragments.EnterPhoneNumberFragment
import com.example.chat.ui.utilits.replaceFragment


class RegisterActivity : AppCompatActivity() {

    private lateinit var mBiRegisterBinding: ActivityRegisterBinding
    private lateinit var mainToolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBiRegisterBinding=ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(mBiRegisterBinding.root)
    }

    override fun onStart() {
        super.onStart()
        mainToolbar = mBiRegisterBinding.registerToolbar
        setSupportActionBar(mainToolbar)
        title = getString(R.string.register_title_your_phone)
        replaceFragment(EnterPhoneNumberFragment(), false)
    }
}