package com.kreditbee.assignment.view.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.kreditbee.assignment.R
import com.kreditbee.assignment.model.AlbumDetailsResponse

/**
 * Created by Abhishek Maurya on 12-12-2021.
 */
class AlbumDetailsAdapter(private val context: Context,
                          private val mList: ArrayList<AlbumDetailsResponse>) :
    RecyclerView.Adapter<AlbumDetailsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_album_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val model = mList[position]

        Glide.with(context)
            .load(model.thumbnailUrl)
            .into(holder.imageView)
        holder.textView.text = model.title
        holder.clAlbum.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(model.url))
            context.startActivity(intent)
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imgAlbum)
        val textView: TextView = itemView.findViewById(R.id.txtTitle)
        val clAlbum: ConstraintLayout = itemView.findViewById(R.id.clAlbum)
    }
}