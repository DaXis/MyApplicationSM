package com.myapplication.presenters

import com.myapplication.interactors.MainInter
import com.myapplication.interfaces.MainInteractor
import com.myapplication.interfaces.MainPresenter
import com.myapplication.interfaces.MainView
import com.myapplication.interfaces.OnMainListener

class MainPresent : MainPresenter , OnMainListener{

    private var mainView: MainView? = null
    private var mainInteractor : MainInteractor? = null

    constructor(mainView : MainView?){
        this.mainView = mainView;
        mainInteractor = MainInter(this);
    }

    override fun putAdapter() {
        mainView!!.putAdapter()
    }

    override fun showImages() {
        mainInteractor!!.showImages()
    }

    override fun onShowImages(urlList: ArrayList<String>) {
        mainView!!.showImages(urlList)
    }
}