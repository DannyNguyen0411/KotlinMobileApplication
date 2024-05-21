package com.example.userlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MapLoggedInActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_logged_in)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.bottom_map -> {
                    replaceFragment(MapFragment())
                    true
                }

                R.id.bottom_history -> {
                    replaceFragment(HistoryFragment())
                    true
                }

                R.id.bottom_add -> {
                    replaceFragment(ActivityFragment())
                    true
                }

                R.id.bottom_my_tracker -> {
                    replaceFragment(My_TrackerFragment())
                    true
                }

                R.id.bottom_profile -> {
                    replaceFragment(AccountFragment())
                    true
                }
                else -> false
            }
        }

        replaceFragment(MapFragment())
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }
}
