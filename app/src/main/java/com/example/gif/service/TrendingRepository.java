package com.example.gif.service;

import com.example.gif.model.trending.TrendingDiscoveryResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TrendingRepository {
    @GET("/v1/trending?key=D6AP4CL0EGJS")
    Call<TrendingDiscoveryResponse> getTrendingDiscover();
}
