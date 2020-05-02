package com.example.gif.service;

import com.example.gif.model.search.goodnight.GoodNightResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SearchRepository {
    @GET("/v1/search?tag=good%20night&safesearch=strict")
    Call<GoodNightResponse> getSearch();
}
