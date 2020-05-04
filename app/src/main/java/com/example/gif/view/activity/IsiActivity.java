package com.example.gif.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.gif.R;
import com.example.gif.adapter.IsiAdapter;
import com.example.gif.model.search.goodnight.IsiItem;
import com.example.gif.view.viewmodel.SearchViewModel;

import java.util.ArrayList;

public class IsiActivity extends AppCompatActivity {
    private RecyclerView rvIsi;
   private SearchViewModel searchViewModel;
   private IsiAdapter isiAdapter;
    private TextView tvTag;
    private String getSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);

        isiAdapter = new IsiAdapter(getApplicationContext());
        isiAdapter.notifyDataSetChanged();

        tvTag = findViewById(R.id.activity_k_tv);
        rvIsi = findViewById(R.id.activity_k_rv);
        rvIsi.setLayoutManager(new GridLayoutManager(this, 2));

        getInten();
        searchViewModel = new ViewModelProvider(this).get(SearchViewModel.class);
        searchViewModel.setSearch(getSearch);
        searchViewModel.getIsi().observe(this,getIsiList);

    }

    private Observer<ArrayList<IsiItem>> getIsiList = new Observer<ArrayList<IsiItem>>() {
        @Override
        public void onChanged(ArrayList<IsiItem> isiItems) {
            if (isiItems !=null){
                isiAdapter.setIsiItems(isiItems);
                rvIsi.setAdapter(isiAdapter);
            }
        }
    };


    public void getInten(){
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String getTitle = bundle.getString("nama");
             getSearch = bundle.getString("search");
            tvTag.setText(getTitle);
        }
    }
}
