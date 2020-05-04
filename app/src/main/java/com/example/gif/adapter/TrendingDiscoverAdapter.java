package com.example.gif.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.gif.R;
import com.example.gif.model.trending.Gif;
import com.example.gif.model.trending.TrendingResultsItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class TrendingDiscoverAdapter extends RecyclerView.Adapter<TrendingDiscoverAdapter.ViewHolder> {

    private ArrayList<TrendingResultsItem> trendingResultsItems = new ArrayList<>();
    private Context context;

    private int position;

    //   private static String BASE_IMAGE_URL = "https://media.tenor.com/images/";
    public TrendingDiscoverAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<TrendingResultsItem> items) {
        trendingResultsItems.clear();
        trendingResultsItems.addAll(items);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public TrendingDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TrendingDiscoverAdapter.ViewHolder holder, final int position) {
        Glide.with(context).load(trendingResultsItems.get(position)
                .getMedia().get(0).getGif().getUrl())
                .placeholder(R.drawable.user_placeholder)
                .error(R.drawable.user_placeholder)
                .into(holder.ivThumb);

        holder.ivThumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");

                String link = trendingResultsItems.get(position).getMedia().get(0).getGif().getUrl();
                shareIntent.putExtra(Intent.EXTRA_TEXT,link);
                context.startActivity(Intent.createChooser(shareIntent, context.getResources().getText(R.string.send_to)));

                /*Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/*");
                intent.setPackage("com.whatsapp");
                new Download_GIF(resourceName).execute();
                Uri imageUri = Uri.parse("file:///storage/emulated/0/downloadedFile.gif");
                intent.putExtra(Intent.EXTRA_STREAM, imageUri);
                    context.startActivity(Intent.createChooser(intent, "Share Gif"));*/
            }

        });
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