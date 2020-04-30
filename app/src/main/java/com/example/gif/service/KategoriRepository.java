package com.example.gif.service;

import com.example.gif.model.kategori.KategoriResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KategoriRepository {
    @GET("/v1/categories?key=D6AP4CL0EGJS")
    Call<KategoriResponse> getKategori();
}
