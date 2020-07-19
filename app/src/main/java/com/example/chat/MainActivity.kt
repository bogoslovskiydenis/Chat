package com.example.chat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chat.databinding.ActivityMainBinding
import com.example.chat.ui.fragments.ChatsFragment
import com.example.chat.ui.objects.AppDrawer


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
        setSupportActionBar(mainToolbar)
        //appDrawer
        mainAppDrawer.create()
        //create ChatsFragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer,
                ChatsFragment()
            ).commit()

    }

    //initialization
    private fun initFields() {
        mainToolbar = mainBinding.mainToolbar
        mainAppDrawer = AppDrawer(this, mainToolbar)

    }

}