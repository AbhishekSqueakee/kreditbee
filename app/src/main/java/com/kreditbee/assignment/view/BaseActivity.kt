package com.kreditbee.assignment.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.kreditbee.assignment.databinding.ActivityBaseBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Abhishek Maurya on 12-12-2021.
 */
@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityBaseBinding
    abstract fun fragment(): Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        addFragment()
    }

    open fun addFragment() {
        supportFragmentManager.beginTransaction()
            .add(_binding.fragmentContainer.id, fragment())
            .commitAllowingStateLoss()
    }
}
