package com.example.chat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chat.activities.RegisterActivity
import com.example.chat.databinding.ActivityMainBinding
import com.example.chat.models.User
import com.example.chat.ui.fragments.ChatsFragment
import com.example.chat.ui.objects.AppDrawer
import com.example.chat.ui.utilits.*


class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    lateinit var mainAppDrawer: AppDrawer
    private lateinit var mainToolbar: androidx.appcompat.widget.Toolbar

    //    auth FireBase
    //    private lateinit var mainAuth: FirebaseAuth
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
        //Проверка пользователя
        if (AUTH.currentUser != null) {
            setSupportActionBar(mainToolbar)
            mainAppDrawer.create()
            replaceFragment(ChatsFragment(), false)
        } else {
            //Utils -> function replaseActivity
            replaceActivity(RegisterActivity())
        }
    }

    //initialization
    private fun initFields() {
        //mainToolbar initialization
        mainToolbar = mainBinding.mainToolbar
        mainAppDrawer = AppDrawer(this, mainToolbar)
        //firebase initialization
        initFirebase()
        initUser()
    }

    private fun initUser() {
        REF_DATABASE_ROOT.child(NODE_USERS).child(UID)
            .addListenerForSingleValueEvent(AppValueEventListener {
                USER = it.getValue(User::class.java) ?: User()

            })
    }
}

