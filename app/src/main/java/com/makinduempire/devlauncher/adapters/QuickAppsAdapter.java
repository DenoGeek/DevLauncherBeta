package com.makinduempire.devlauncher.adapters;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.makinduempire.devlauncher.R;
import com.makinduempire.devlauncher.models.AppRecord;

import java.util.List;

/**
 * Created by Makindu ExpressC on 12/04/2017.
 */

public class QuickAppsAdapter extends RecyclerView.Adapter {
    private List<AppRecord> apps;
    private Context context;

    public QuickAppsAdapter(Context c, List<AppRecord> appsi){
        this.apps=appsi;
        this.context=c;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView app_name;
        public ImageView app_icon;
        private ImageView check_box;
        public ViewHolder(View v) {
            super(v);
            app_icon=(ImageView)v.findViewById(R.id.app_icon);
            app_name=(TextView)v.findViewById(R.id.app_label);
            check_box=(ImageView)v.findViewById(R.id.checkbox);
        }

    }

    @Override
    public QuickAppsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.quick_apps_fragment_item, parent, false);
        QuickAppsAdapter.ViewHolder vh = new QuickAppsAdapter.ViewHolder(rowView);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final QuickAppsAdapter.ViewHolder hold=(QuickAppsAdapter.ViewHolder)holder;
        hold.app_name.setText(apps.get(position).label);
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);

        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        hold.app_icon.setColorFilter(filter);
        try{
            hold.app_icon.setImageDrawable(apps.get(position).getIcon(context));
        }catch (NullPointerException r){

        }
    }

    public AppRecord getApp(int position){
        return apps.get(position);
    }
    public void setData(List<AppRecord> newlist){
        this.apps=null;
        this.apps=newlist;
        this.notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return apps.size();
    }
}
