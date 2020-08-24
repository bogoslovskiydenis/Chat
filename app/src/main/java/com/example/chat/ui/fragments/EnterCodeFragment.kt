package com.example.chat.ui.fragments

import androidx.fragment.app.Fragment
import com.example.chat.R
import com.example.chat.ui.utilits.AppTextWatcher
import com.example.chat.ui.utilits.showToast
import kotlinx.android.synthetic.main.fragment_enter_code.*


class EnterCodeFragment : Fragment(R.layout.fragment_enter_code) {
    override fun onStart() {
        super.onStart()
        //Подключаемся к Поле EditText -> Подключаем addTextChangedListener
        register_input_code.addTextChangedListener(AppTextWatcher {
            val string: String = register_input_code.text.toString()
            if (string.length == 6) {
                varificateCode()
            }
        })
    }


    fun varificateCode() {
        showToast("OK")
    }
}