package com.demoapp.ui.detail

import android.util.Log
import com.demoapp.main.App


class ItemDetailPresenter(private var model: ItemDetailMVP.Model): ItemDetailMVP.Presenter  {


    private lateinit var view: ItemDetailMVP.View


    override fun setView(view: ItemDetailMVP.View) {

        this.view = view
    }
    override fun init() {

        view.populateData()
    }

    override fun unsubscribe() {
    }

}