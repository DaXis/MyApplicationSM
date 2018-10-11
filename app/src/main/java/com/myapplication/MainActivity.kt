package com.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import com.myapplication.adapters.ImageAdapter
import com.myapplication.interfaces.MainPresenter
import com.myapplication.interfaces.MainView
import com.myapplication.presenters.MainPresent

class MainActivity : AppCompatActivity() , MainView {

    var gridView : GridView? = null
    private var mainPresent: MainPresenter? = null
    private var adapter : ImageAdapter? = null
    var urlList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresent = MainPresent(this)

        //gridView = findViewById(R.id.gridView) as GridView

        gridView = findViewById<GridView>(R.id.gridView)
        adapter = ImageAdapter(this, urlList)
        mainPresent!!.putAdapter()
        mainPresent!!.showImages()

    }

    override fun putAdapter() {
        gridView!!.adapter = adapter;
    }

    override fun showImages(urlList: ArrayList<String>) {
        adapter!!.updateAdapter(urlList)
    }
}
