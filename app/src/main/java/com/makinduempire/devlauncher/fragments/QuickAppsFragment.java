package com.makinduempire.devlauncher.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.makinduempire.devlauncher.R;
import com.makinduempire.devlauncher.adapters.QuickAppsAdapter;
import com.makinduempire.devlauncher.models.AppDetail;
import com.makinduempire.devlauncher.models.AppRecord;
import com.makinduempire.devlauncher.utils.AppClick;
import com.makinduempire.devlauncher.utils.BasicControls;
import com.makinduempire.devlauncher.utils.RecyclerItemClickListener;

import java.util.List;

/**
 * Created by Makindu ExpressC on 13/04/2017.
 */

public class QuickAppsFragment extends Fragment {

    private List<AppRecord> all;
    private QuickAppsAdapter adapter;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quick_apps_fragment, container, false);

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.apps_recycler_view);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);

        all=new Select().from(AppRecord.class).execute();
        adapter=new QuickAppsAdapter(getActivity(),all);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);

        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), mRecyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        AppRecord clicked=adapter.getApp(position);
                        new AppClick(clicked.identify,getActivity()).forceClick();
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

        return view;
    }

    public void refreshData(){
        all=new Select().from(AppRecord.class).execute();
        adapter.notifyDataSetChanged();
    }

}
