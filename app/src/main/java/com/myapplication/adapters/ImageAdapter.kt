package com.myapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.myapplication.R
import kotlinx.android.synthetic.main.row.view.*

class ImageAdapter : BaseAdapter {

    var urlList = ArrayList<String>()
    var context: Context? = null

    constructor(context: Context, urlList: ArrayList<String>) : super() {
        this.context = context
        this.urlList = urlList
    }

    override fun getCount(): Int {
        return urlList.size
    }

    override fun getItem(position: Int): Any {
        return urlList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var rowView = inflator.inflate(R.layout.row, null)

        val url = this.urlList[position]

        val image = rowView.findViewById<ImageView>(R.id.image)
        Glide.with(context).load(url).into(image)

        return rowView
    }

    fun updateAdapter(urlList: ArrayList<String>){
        this.urlList = urlList
        notifyDataSetChanged()
    }
}