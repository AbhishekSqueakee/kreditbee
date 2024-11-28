package com.kreditbee.assignment.di

import android.content.Context
import com.kreditbee.assignment.view.HomeActivity
import javax.inject.Inject

/**
 * Created by Abhishek Maurya on 12-12-2021.
 */
class Navigator @Inject constructor() {
    fun showHomeScreen(context: Context) {
        context.startActivity(HomeActivity.callingIntent(context))
    }
}
