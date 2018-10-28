package com.demoapp.ui.list

import com.demoapp.api.ApiService
import dagger.Module
import dagger.Provides


@Module
class ListActivityModule(private var view: ListActivityMVP.View) {


    @ItemScope
    @Provides
    fun provideMainActivityPresenter(model: ListActivityMVP.Model) : ListActivityMVP.Presenter {

        return ListActivityPresenter(model)
    }

    @ItemScope
    @Provides
    fun provideMainActivityModel(repository: Repository) : ListActivityMVP.Model {

        return ListActivityModel(repository)
    }

    @ItemScope
    @Provides
    fun provideRepo(apiService: ApiService) : Repository {

        return ListActivityRepository(apiService)
    }
}