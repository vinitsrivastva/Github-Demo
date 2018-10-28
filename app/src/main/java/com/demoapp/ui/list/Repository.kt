package com.demoapp.ui.list

import com.demoapp.model.RepoData
import io.reactivex.Observable

interface Repository {

    fun getRepoData(data: HashMap<String, String>): Observable<List<RepoData>>

}