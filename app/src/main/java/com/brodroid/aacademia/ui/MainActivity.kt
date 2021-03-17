package com.brodroid.aacademia.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.brodroid.aacademia.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottom_navigation)
    }

    override fun onStart() {
        super.onStart()
        findNavController(R.id.nav_host_fragment_container).addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.lessonFragment -> bottomNav.visibility = View.GONE
                else -> bottomNav.visibility = View.VISIBLE
            }

//                R.id.videoFragment -> { bottomNav.visibility = View.VISIBLE
//                    bottomNav.setOnNavigationItemSelectedListener { item ->
//                        when (item.itemId) {
//                            R.id.nav_slides -> {
//                                controller.navigate(R.id.action_videoFragment_to_presentationFragment, arguments)
//                                true
//                            }
//                            R.id.nav_homework -> {
//                                controller.navigate(R.id.action_videoFragment_to_homeworkFragment, arguments)
//                                true
//                            }
//                            else -> {
//                                true
//                            }
//                        }
//                    }
//                }
//                R.id.presentationFragment -> {
//                    bottomNav.setOnNavigationItemSelectedListener { item ->
//                        when (item.itemId) {
//                            R.id.nav_video -> {
//                                controller.navigate(R.id.action_presentationFragment_to_videoFragment, arguments)
//                                true
//                            }
//                            R.id.nav_homework -> {
//                                controller.navigate(R.id.action_presentationFragment_to_homeworkFragment, arguments)
//                                true
//                            }
//
//                            else -> {
//                                true
//                            }
//                        }
//                    }
//                }
//                R.id.homeworkFragment -> {
//                    bottomNav.setOnNavigationItemSelectedListener { item ->
//                        when (item.itemId) {
//                            R.id.nav_video -> {
//                                controller.navigate(R.id.action_homeworkFragment_to_videoFragment, arguments)
//                                true
//                            }
//                            R.id.nav_slides -> {
//                                controller.navigate(R.id.action_homeworkFragment_to_presentationFragment, arguments)
//                                true
//                            }
//                            else -> {
//                                true
//                            }
//                        }
//                    }
//                }
//                R.id.lessonFragment -> { bottomNav.visibility = View.GONE }
//            }
        }
    }
}