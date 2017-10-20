package com.makinduempire.devlauncher.adapters.viewholders;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SViewHolderBase<T> extends RecyclerView.ViewHolder{
    public SViewHolderBase(View itemView) {
        super(itemView);
    }

    public SViewHolderBase(ViewGroup parent, int layoutId) {
        super(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
    }

    protected <T extends View> T findViewById(@IdRes int id){
        return (T) itemView.findViewById(id);
    }
}
