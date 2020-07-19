package com.example.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.chat.databinding.ActivityMainBinding
import com.example.chat.ui.ChatsFragment
import com.example.chat.ui.SettingsFragment
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem


class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainDrawer: Drawer
    private lateinit var mainHeader: AccountHeader
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
        //При запуске приложения устанавливаем в контейнер фрагмент Чат
        supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer,ChatsFragment()).commit()
        createHeader()
        createDrawer()
    }

    private fun createDrawer() {
        mainDrawer = DrawerBuilder()
            .withActivity(this)
            .withToolbar(mainToolbar)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .withAccountHeader(mainHeader)
            .addDrawerItems(
                PrimaryDrawerItem().withIdentifier(100)
                    .withIconTintingEnabled(true)
                    .withName("Invire")
                    .withSelectable(false)
                    .withIcon(R.drawable.icon_menu_add_user),
                PrimaryDrawerItem().withIdentifier(101)
                    .withIconTintingEnabled(true)
                    .withName("Create group")
                    .withSelectable(false)
                    .withIcon(R.drawable.icon_menu_create_group),
                PrimaryDrawerItem().withIdentifier(102)
                    .withIconTintingEnabled(true)
                    .withName("Favorites")
                    .withSelectable(false)
                    .withIcon(R.drawable.icon_menu_favorites),
                PrimaryDrawerItem().withIdentifier(103)
                    .withIconTintingEnabled(true)
                    .withName("Find")
                    .withSelectable(false)
                    .withIcon(R.drawable.icon_menu_find),
                PrimaryDrawerItem().withIdentifier(104)
                    .withIconTintingEnabled(true)
                    .withName("Invite")
                    .withSelectable(false)
                    .withIcon(R.drawable.icon_menu_invite),
                PrimaryDrawerItem().withIdentifier(105)
                    .withIconTintingEnabled(true)
                    .withName("Phone")
                    .withSelectable(false)
                    .withIcon(R.drawable.icon_menu_phone),
                PrimaryDrawerItem().withIdentifier(106)
                    .withIconTintingEnabled(true)
                    .withName("Secret chat")
                    .withSelectable(false)
                    .withIcon(R.drawable.icon_menu_secret_chat),
                PrimaryDrawerItem().withIdentifier(107)
                    .withIconTintingEnabled(true)
                    .withName("Settings")
                    .withSelectable(false)
                    .withIcon(R.drawable.icon_menu_settings),
                PrimaryDrawerItem().withIdentifier(108)
                    .withIconTintingEnabled(true)
                    .withName("Help")
                    .withSelectable(false)
                    .withIcon(R.drawable.icon_menu_help)
            ).withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    when(position){
                        8 -> supportFragmentManager.beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.dataContainer,SettingsFragment()).commit()
                    }
                    return false
                }

            }).build()
    }

    private fun createHeader() {
        mainHeader = AccountHeaderBuilder()
            .withActivity(this)
            .withHeaderBackground(R.drawable.header)
            .addProfiles(
                ProfileDrawerItem().withName("Name")
                    .withEmail("Number")
            ).build()
    }

    private fun initFields() {
        mainToolbar = mainBinding.mainToolbar
    }

}