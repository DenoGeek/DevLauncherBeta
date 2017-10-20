package com.makinduempire.devlauncher.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.makinduempire.devlauncher.R;
import com.makinduempire.devlauncher.adapters.viewholders.AppViewHolder;
import com.makinduempire.devlauncher.models.AppDetail;
import com.makinduempire.devlauncher.utils.AppClick;

import java.util.List;


public class AppFragmentAdapter extends RecyclerView.Adapter {
    public static final int TYPE_1 = 0;
    public static final int TYPE_2 = 1;
    private Context c;
    private List<AppDetail> mData;
    public AppFragmentAdapter(List<AppDetail> data,Context co){
        mData = data;
        c=co;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AppViewHolder(parent);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(mData == null || mData.size() <= position){
            return;
        }
        final AppViewHolder appholder = (AppViewHolder) holder;
        appholder.appIcon.setImageDrawable(mData.get(position).icon);
        appholder.appName.setText(mData.get(position).label);

        appholder.appIcon.setOnClickListener(new AppClick(mData.get(position).name.toString(),c));

    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        if(position < 10){
            return TYPE_1;
        }else{
            return TYPE_2;
        }
    }
}
