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
import com.example.gif.model.search.goodnight.IsiItem;

import java.util.ArrayList;

public class IsiAdapter extends RecyclerView.Adapter<IsiAdapter.ViewHolder> {
    private Context context;
    private ArrayList<IsiItem> isiItems = new ArrayList<>();

    public IsiAdapter(Context context) {
        this.context = context;
    }

    public void setIsiItems(ArrayList<IsiItem> items) {
        isiItems.clear();
        isiItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_isi, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(isiItems.get(position).getMedia().get(0).getGif().getUrl()).into(holder.ivThumb);

    }

    @Override
    public int getItemCount() {
        return isiItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivThumb;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumb = itemView.findViewById(R.id.itemlist_ivi_thumbnail);
            cardView = itemView.findViewById(R.id.itemlist_cvi);
        }
    }
}
