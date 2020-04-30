package com.example.gif.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gif.model.kategori.KategoriItem;
import com.example.gif.model.kategori.KategoriResponse;
import com.example.gif.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KategoriViewModel extends ViewModel {
    private ApiMain apiMain;
    private MutableLiveData<ArrayList<KategoriItem>> listKategori = new MutableLiveData<>();

    public void setKategori(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiKategori().getKategori().enqueue(new Callback<KategoriResponse>() {
            @Override
            public void onResponse(Call<KategoriResponse> call, Response<KategoriResponse> response) {
                KategoriResponse kategoriResponse = response.body();
                if (kategoriResponse != null && kategoriResponse.getTags() != null){
                    ArrayList<KategoriItem> kategoriItems = kategoriResponse.getTags();
                    listKategori.postValue(kategoriItems);
                }
            }

            @Override
            public void onFailure(Call<KategoriResponse> call, Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<KategoriItem>> getKategoriResult(){
        return listKategori;
    }
}
