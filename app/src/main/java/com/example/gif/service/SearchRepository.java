package com.example.gif.service;

import com.example.gif.model.search.goodnight.GoodNightResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SearchRepository {
    @GET("/v1/search")
    Call<GoodNightResponse> getSearch(@Query("tag") String search);
}
