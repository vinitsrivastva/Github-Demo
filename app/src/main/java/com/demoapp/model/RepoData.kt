package com.demoapp.model

import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class RepoData(

    @SerializedName("author")
    @Expose
    val author: String,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("url")
    @Expose
    val url: String,
    @SerializedName("description")
    @Expose
    val description: String,
    @SerializedName("language")
    @Expose
    val language: String,
    @SerializedName("stars")
    @Expose
    val stars: String,
    @SerializedName("forks")
    @Expose
    val forks: String,
    @SerializedName("currentPeriodStars")
    @Expose
    val currentPeriodStars: String


): Parcelable
