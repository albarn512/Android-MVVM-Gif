package com.example.gif.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gif.R;
import com.example.gif.model.trending.Gif;
import com.example.gif.model.trending.TrendingResultsItem;

import java.util.ArrayList;

public class TrendingDiscoverAdapter extends RecyclerView.Adapter<TrendingDiscoverAdapter.ViewHolder> {

    private ArrayList<TrendingResultsItem> trendingResultsItems = new ArrayList<>();
    private Context context;
 //   private static String BASE_IMAGE_URL = "https://media.tenor.com/images/";
    public TrendingDiscoverAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<TrendingResultsItem> items){
        trendingResultsItems.clear();
        trendingResultsItems.addAll(items);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public TrendingDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingDiscoverAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(trendingResultsItems.get(position)
                .getMedia().get(0).getGif().getUrl())
                .into(holder.ivThumb);


    }

    @Override
    public int getItemCount() {
        return trendingResultsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivThumb;
        CardView cvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.itemlist_cv);
            ivThumb = itemView.findViewById(R.id.itemlist_iv_thumbnail);
        }
    }
}
