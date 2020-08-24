package com.example.chat

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chat.activities.RegisterActivity
import com.example.chat.databinding.ActivityMainBinding
import com.example.chat.ui.fragments.ChatsFragment
import com.example.chat.ui.objects.AppDrawer
import com.example.chat.ui.utilits.replaceActivity
import com.example.chat.ui.utilits.replaceFragment



class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainAppDrawer: AppDrawer
    private lateinit var mainToolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {

        if (true) {
            setSupportActionBar(mainToolbar)
            mainAppDrawer.create()
            replaceFragment(ChatsFragment())
        } else {
            //Utils -> function replaseActivity
            replaceActivity(RegisterActivity())
        }
    }

    //initialization
    private fun initFields() {
        mainToolbar = mainBinding.mainToolbar
        mainAppDrawer = AppDrawer(this, mainToolbar)

    }

}