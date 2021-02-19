package com.mbinfo.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.mbinfo.testui.MainActivity;
import com.mbinfo.testui.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter <CustomAdapter.MyViewHolder>{
    public Context context;
    public List<BannercardDatum> mData;
    public CustomAdapter(Context context, ArrayList<BannercardDatum> mData) {
        this.context = context;
        this.mData = mData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        CustomAdapter.MyViewHolder viewHolder = new CustomAdapter.MyViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder , int position) {
        String imgurl = mData.get(position).getBackgroundImage();
        if(imgurl!=null) {
            Glide.with(context)
                    .load(imgurl)
                    .apply(new RequestOptions()
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .skipMemoryCache(true))
                    .into(holder.product_image);
        }else {
            Glide.with(context)
                    .load(R.mipmap.ic_launcher)
                    .apply(new RequestOptions()
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .skipMemoryCache(true))
                    .into(holder.product_image);
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView product_image;
        CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            product_image =  view.findViewById(R.id.info_text);

        }
    }
}
