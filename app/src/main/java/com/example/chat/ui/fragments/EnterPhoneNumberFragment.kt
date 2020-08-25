package com.example.chat.ui.fragments

import androidx.fragment.app.Fragment
import com.example.chat.MainActivity
import com.example.chat.R
import com.example.chat.activities.RegisterActivity
import com.example.chat.ui.utilits.AUTH
import com.example.chat.ui.utilits.replaceActivity
import com.example.chat.ui.utilits.replaceFragment
import com.example.chat.ui.utilits.showToast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_enter_phone_number.*
import java.util.concurrent.TimeUnit


class EnterPhoneNumberFragment : Fragment(R.layout.fragment_enter_phone_number) {

    private lateinit var mainPhoneNumber: String
    private lateinit var mainCallback: PhoneAuthProvider.OnVerificationStateChangedCallbacks


    override fun onStart() {
        super.onStart()
        mainCallback = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            //Проверяет есть ли Верификация
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                AUTH.signInWithCredential(credential).addOnCompleteListener {
                    if (it.isSuccessful){
                        showToast("Welcome")
                        (activity as RegisterActivity).replaceActivity(MainActivity())
                    }else showToast(it.exception?.message.toString())
                }

        }

            override fun onCodeSent(id: String, token: PhoneAuthProvider.ForceResendingToken) {
                replaceFragment(EnterCodeFragment(mainPhoneNumber,id))
            }

            //Проблема с Верификацией
        override fun onVerificationFailed(p0: FirebaseException) {
            showToast(p0.message.toString())
        }

    }
    register_btn_next.setOnClickListener{ sendCode() }
}


private fun sendCode() {
    // проверка введен ли номер
    if (register_input_phone_numner.text.toString().isEmpty()) {
        showToast(getString(R.string.register_enter_phone))
    } else {
        autUser()
    }
}

private fun autUser() {
    mainPhoneNumber = register_input_phone_numner.text.toString()
    PhoneAuthProvider.getInstance().verifyPhoneNumber(
        mainPhoneNumber,
        60,
        TimeUnit.SECONDS,
        activity as RegisterActivity,
        mainCallback
    )
}
}