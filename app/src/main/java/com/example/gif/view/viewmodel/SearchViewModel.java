package com.example.gif.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gif.model.search.goodnight.GoodNightResponse;
import com.example.gif.model.search.goodnight.IsiItem;
import com.example.gif.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchViewModel extends ViewModel {
    private ApiMain apiMain;
    private MutableLiveData<ArrayList<IsiItem>> listSearch = new MutableLiveData<>();

    public void setSearch(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiSearch().getSearch().enqueue(new Callback<GoodNightResponse>() {
            @Override
            public void onResponse(Call<GoodNightResponse> call, Response<GoodNightResponse> response) {
                GoodNightResponse goodNightResponse = response.body();
                if (goodNightResponse != null && goodNightResponse.getResults() != null){
                    ArrayList<IsiItem> isiItems = goodNightResponse.getResults();
                    listSearch.postValue(isiItems);
                }
            }

            @Override
            public void onFailure(Call<GoodNightResponse> call, Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<IsiItem>> getIsi(){
        return listSearch;
    }
}
