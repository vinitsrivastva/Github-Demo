package com.demoapp.ui.list

import io.reactivex.Observable
import com.demoapp.model.RepoData


public interface ListActivityMVP {

    interface View{

        fun updateData(repoData: List<RepoData>)
        fun showProgress(show: Boolean)
        fun showMessage(msg: String)
        fun onItemSelected(result: RepoData)
        fun clearData()
    }

    interface Presenter{

        fun loadData(data: HashMap<String, String>)
        fun unsubscribe()
        fun setView(view: View)
    }

    interface Model {

        fun result(data: HashMap<String, String>):Observable<List<RepoData>>
    }

}
