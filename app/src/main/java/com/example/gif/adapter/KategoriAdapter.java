package com.example.gif.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gif.R;
import com.example.gif.model.kategori.KategoriItem;
import com.example.gif.view.activity.IsiActivity;
import com.example.gif.view.viewmodel.SearchViewModel;

import java.util.ArrayList;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.ViewHolder> {

    private ArrayList<KategoriItem> kategoriItems = new ArrayList<>();
    private Context context;
   SearchViewModel searchViewModel;

    public KategoriAdapter(Context context){this.context = context;}

    public void setData(ArrayList<KategoriItem> items){
        kategoriItems.clear();
        kategoriItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public KategoriAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_kategori,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final KategoriAdapter.ViewHolder holder, final int position) {
        Glide.with(context).load(kategoriItems.get(position)
        .getImage()).into(holder.ivThumb);
        holder.tvTag.setText(kategoriItems.get(position).getName());

        holder.ivThumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, IsiActivity.class);
                intent.putExtra("nama",kategoriItems.get(position).getName());
                intent.putExtra("search",kategoriItems.get(position).getSearchterm());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return kategoriItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivThumb;
        TextView tvTag;
        CardView cvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.itemlist_cvk);
            ivThumb = itemView.findViewById(R.id.itemlist_ivk_thumbnail);
            tvTag = itemView.findViewById(R.id.itemlist_tv_name);
        }
    }
}
