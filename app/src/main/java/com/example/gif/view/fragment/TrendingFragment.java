package com.example.gif.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gif.R;
import com.example.gif.adapter.TrendingDiscoverAdapter;
import com.example.gif.model.trending.TrendingResultsItem;
import com.example.gif.view.viewmodel.TrendingViewModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrendingFragment extends Fragment {

    private TrendingDiscoverAdapter trendingDiscoverAdapter;
    private RecyclerView rvTrending;
    private TrendingViewModel trendingViewModel;
    public TrendingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trending, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        trendingDiscoverAdapter = new TrendingDiscoverAdapter(getContext());
        trendingDiscoverAdapter.notifyDataSetChanged();

        rvTrending = view.findViewById(R.id.fragmentmovie_rv);
        rvTrending.setLayoutManager(new GridLayoutManager(getContext(),2));

        trendingViewModel = new ViewModelProvider(this).get(TrendingViewModel.class);
        trendingViewModel.setTrendingDiscover();
        trendingViewModel.getTrending().observe(this, getTrendingDiscover);

        rvTrending.setAdapter(trendingDiscoverAdapter);

    }

    private Observer<ArrayList<TrendingResultsItem>> getTrendingDiscover = new Observer<ArrayList<TrendingResultsItem>>() {
        @Override
        public void onChanged(ArrayList<TrendingResultsItem> trendingResultsItems) {
            if (trendingResultsItems !=null){
                trendingDiscoverAdapter.setData(trendingResultsItems);
            }
        }
    };
}
