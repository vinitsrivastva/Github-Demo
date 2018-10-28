package com.demoapp.main

import com.demoapp.api.ApiModule
import com.demoapp.ui.list.ListActivityModule
import dagger.Component
import javax.inject.Singleton
import com.demoapp.ui.detail.ItemDetailComponent
import com.demoapp.ui.detail.ItemDetailModule
import com.demoapp.ui.list.ItemComponent


@Singleton
@Component(modules = arrayOf(AppModule::class, ApiModule::class))
interface AppComponent {


    fun inject(baseApplication: App)

    fun itemListComponent(listModule: ListActivityModule): ItemComponent

    fun itemDetailComponent(mainModule: ItemDetailModule): ItemDetailComponent

}
