package com.demoapp.ui.detail

import dagger.Module
import dagger.Provides

@Module
class ItemDetailModule(private var view: ItemDetailMVP.View) {

    @Provides
    fun provideDetailActivityPresenter(model: ItemDetailMVP.Model) : ItemDetailMVP.Presenter {

        return ItemDetailPresenter(model)
    }

    @Provides
    fun provideDetailActivityModel() : ItemDetailMVP.Model {

        return ItemDetailModel()
    }

}