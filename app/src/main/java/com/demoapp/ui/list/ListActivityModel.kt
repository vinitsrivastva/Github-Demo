package com.demoapp.ui.list

import io.reactivex.Observable
import com.demoapp.model.RepoData


class ListActivityModel(private var repository: Repository): ListActivityMVP.Model  {

    override fun result(data: HashMap<String, String>): Observable<List<RepoData>> {

        return repository.getRepoData(data)
    }

}