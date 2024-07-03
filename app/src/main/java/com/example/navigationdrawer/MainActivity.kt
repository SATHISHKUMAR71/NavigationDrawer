package com.example.navigationdrawer

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout:DrawerLayout
    lateinit var toolbar: Toolbar
    lateinit var navView:NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameContainer,HomeFragment())
            .addToBackStack("Home")
            .commit()
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        navView = findViewById(R.id.navView)
        drawerLayout = findViewById(R.id.drawerLayout)

        val navView = findViewById<NavigationView>(R.id.navView)

        navView.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.name -> {
                    println("Name Clicked")
                    drawerLayout.closeDrawers()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameContainer,Name())
                        .addToBackStack("Name")
                        .commit()
                }

                R.id.email -> {
                    println("Email Clicked")
                    drawerLayout.closeDrawers()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameContainer,EmailFrament())
                        .addToBackStack("Email")
                        .commit()
                }
                R.id.logout -> {
                    println("Logout Clicked")
                    drawerLayout.closeDrawers()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameContainer,LogoutFragment())
                        .addToBackStack("Logout")
                        .commit()
                    finish()
                }
            }
            true
        }

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_nav,
            R.string.close_nav
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

    }
}