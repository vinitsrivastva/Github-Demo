package com.demoapp.ui.detail

public interface ItemDetailMVP {

    interface View{

        fun populateData()
    }

    interface Presenter{

        fun init()
        fun unsubscribe()
        fun setView(view: View)

    }

    interface Model {

    }
}
