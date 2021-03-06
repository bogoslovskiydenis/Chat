package com.example.chat.ui.objects

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.example.chat.R
import com.example.chat.ui.fragments.SettingsFragment
import com.example.chat.ui.utilits.replaceFragment
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

class AppDrawer(val mainActivity: AppCompatActivity, val toolbar: Toolbar) {

    private lateinit var mainDrawer: Drawer
    private lateinit var mainHeader: AccountHeader
    private lateinit var mainDrawerLayout: DrawerLayout

    fun create() {
        createHeader()
        createDrawer()
        mainDrawerLayout = mainDrawer.drawerLayout
    }
        //переход по стеку назад
    fun disableDrawer() {
        mainDrawer.actionBarDrawerToggle?.isDrawerIndicatorEnabled = false
        mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mainDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        toolbar.setNavigationOnClickListener {
            mainActivity.supportFragmentManager.popBackStack()
        }
    }

    fun enableDrawer() {
        //Сначала отключить кнопку Тогл после включить Тогл назад и разблокировать
        mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        mainDrawer.actionBarDrawerToggle?.isDrawerIndicatorEnabled = true
        mainDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        toolbar.setNavigationOnClickListener {
            mainDrawer.openDrawer()
        }
    }

    private fun createDrawer() {
        mainDrawer = DrawerBuilder()
            .withActivity(mainActivity)
            .withToolbar(toolbar)
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
                    when (position) {
                        8 -> mainActivity.replaceFragment(SettingsFragment())
                    }
                    return false
                }

            }).build()
    }

    private fun createHeader() {
        mainHeader = AccountHeaderBuilder()
            .withActivity(mainActivity)
            .withHeaderBackground(R.drawable.header)
            .addProfiles(
                ProfileDrawerItem().withName("Name")
                    .withEmail("Number")
            ).build()
    }
}
