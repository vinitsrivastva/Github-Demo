package com.demoapp.api

import com.demoapp.model.RepoData
import io.reactivex.Observable
import retrofit2.http.*

interface ApiService {


    //@GET("/repositories?language=javascript&since=weekly") //?since=daily/weekly/monthly
    @GET("/repositories")
    fun getPosts(

            @QueryMap options:Map<String, String>

    ) : Observable<List<RepoData>>

}