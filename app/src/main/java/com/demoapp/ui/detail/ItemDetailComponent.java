package com.demoapp.ui.detail;

import com.demoapp.ui.list.ItemScope;

import dagger.Subcomponent;

@ItemScope
@Subcomponent(modules = {ItemDetailModule.class})
public interface ItemDetailComponent {
    void inject(ItemDetailFragment itemDetailFragment);
}