package com.kreditbee.assignment.view

import android.content.Context
import android.content.Intent

/**
 * Created by Abhishek Maurya on 12-12-2021.
 */
class HomeActivity: BaseActivity() {

    companion object {
        fun callingIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }

    override fun fragment() = HomeFragment()
}