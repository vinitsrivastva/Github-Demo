package com.demoapp.ui.list

import com.demoapp.api.ApiService
import io.reactivex.Observable
import com.demoapp.model.RepoData


class ListActivityRepository(private var apiService: ApiService) : Repository {

    override fun getRepoData(data: HashMap<String, String>): Observable<List<RepoData>> {

        return apiService.getPosts(data)
    }

}
