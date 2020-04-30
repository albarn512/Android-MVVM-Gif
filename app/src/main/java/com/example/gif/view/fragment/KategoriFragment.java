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
import com.example.gif.adapter.KategoriAdapter;
import com.example.gif.model.kategori.KategoriItem;
import com.example.gif.view.viewmodel.KategoriViewModel;

import java.util.ArrayList;
import java.util.Observable;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KategoriFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KategoriFragment extends Fragment {

    private KategoriAdapter kategoriAdapter;
    private RecyclerView rvKategori;
    private KategoriViewModel kategoriViewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public KategoriFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KategoriFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static KategoriFragment newInstance(String param1, String param2) {
        KategoriFragment fragment = new KategoriFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kategori, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        kategoriAdapter = new KategoriAdapter(getContext());
        kategoriAdapter.notifyDataSetChanged();

        rvKategori = view.findViewById(R.id.fragmentkategori_rv);
        rvKategori.setLayoutManager(new GridLayoutManager(getContext(),3));

        kategoriViewModel = new ViewModelProvider(this).get(KategoriViewModel.class);
        kategoriViewModel.setKategori();
        kategoriViewModel.getKategoriResult().observe(this,getKategori);

        rvKategori.setAdapter(kategoriAdapter);
    }

    private androidx.lifecycle.Observer<ArrayList<KategoriItem>> getKategori = new Observer<ArrayList<KategoriItem>>() {
        @Override
        public void onChanged(ArrayList<KategoriItem> trendingResultsItems) {
            if (trendingResultsItems !=null){
                kategoriAdapter.setData(trendingResultsItems);
            }
        }
    };
}
