package com.demoapp.ui.list

import dagger.Subcomponent

@ItemScope
@Subcomponent(modules = { ListActivityModule.class })
interface ItemComponent {
    fun inject(itemListFragment: ItemListFragment)
}