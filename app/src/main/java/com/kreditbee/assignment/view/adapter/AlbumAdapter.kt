package com.kreditbee.assignment.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.kreditbee.assignment.model.AlbumResponse
import com.kreditbee.assignment.view.AlbumDetailsFragment

/**
 * Created by Abhishek Maurya on 12-12-2021.
 */
class AlbumAdapter(fm: FragmentManager, var data: ArrayList<AlbumResponse>) :
    FragmentStatePagerAdapter(fm) {

    var fragment: Fragment? = null

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Fragment {
        for (i in 0 until data.size) {
            if (i == position) {
                fragment = AlbumDetailsFragment.newInstance(data[position].id)
                break
            }
        }
        return fragment!!
    }
}