package com.example.chat.ui.fragments

import androidx.fragment.app.Fragment
import com.example.chat.MainActivity
import com.example.chat.R
import com.example.chat.activities.RegisterActivity
import com.example.chat.ui.utilits.*
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_enter_code.*


class EnterCodeFragment(val phoneNumber: String, val id: String) :
    Fragment(R.layout.fragment_enter_code) {


    override fun onStart() {
        super.onStart()
        (activity as RegisterActivity).title = phoneNumber
        //Подключаемся к Поле EditText -> Подключаем addTextChangedListener
        register_input_code.addTextChangedListener(AppTextWatcher {
            val string: String = register_input_code.text.toString()
            if (string.length == 6) {
                enterCode()
            }
        })
    }


    private fun enterCode() {
        val code = register_input_code.text.toString()
        val credential: PhoneAuthCredential = PhoneAuthProvider.getCredential(id, code)
        AUTH.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val uid = AUTH.currentUser?.uid.toString()
                val dateMap = mutableMapOf<String, Any>()
                dateMap[CHILD_ID] = uid
                dateMap[CHILD_PHONE] = phoneNumber
                dateMap[CHILD_USERNAME] = uid

                //обращение к базе данных
                REF_DATABASE_ROOT.child(NODE_USERS).child(uid).updateChildren(dateMap)
                    .addOnCompleteListener { task2 ->
                        if (task2.isSuccessful) {
                            showToast("Welcome")
                            (activity as RegisterActivity).replaceActivity(MainActivity())
                        } else showToast(task2.exception?.message.toString())
                    }

            } else showToast(task.exception?.message.toString())
        }
    }
}