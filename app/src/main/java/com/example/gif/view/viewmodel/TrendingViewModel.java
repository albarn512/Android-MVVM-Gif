package com.example.gif.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gif.model.trending.TrendingDiscoveryResponse;
import com.example.gif.model.trending.TrendingResultsItem;
import com.example.gif.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrendingViewModel extends ViewModel {
    private ApiMain apiMain;
    private MutableLiveData<ArrayList<TrendingResultsItem>> listTrending = new MutableLiveData<>();

    public void setTrendingDiscover(){
        if(this.apiMain ==null){
            apiMain = new ApiMain();
        }

        apiMain.getApiTrending().getTrendingDiscover().enqueue(new Callback<TrendingDiscoveryResponse>() {
            @Override
            public void onResponse(Call<TrendingDiscoveryResponse> call, Response<TrendingDiscoveryResponse> response) {
                TrendingDiscoveryResponse responseTrending = response.body();
                if(responseTrending !=null && responseTrending.getResults() !=null){
                    ArrayList<TrendingResultsItem> trendingResultsItems = responseTrending.getResults();
                    listTrending.postValue(trendingResultsItems);
                }
            }

            @Override
            public void onFailure(Call<TrendingDiscoveryResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<TrendingResultsItem>> getTrending(){
        return listTrending;
    }

}
