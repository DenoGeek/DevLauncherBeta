package com.makinduempire.devlauncher.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.makinduempire.devlauncher.R;
import com.makinduempire.devlauncher.adapters.AppFragmentAdapter;
import com.makinduempire.devlauncher.models.AppDetail;
import com.makinduempire.devlauncher.utils.BasicControls;
import com.makinduempire.devlauncher.utils.CompareApps;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Makindu ExpressC on 11/04/2017.
 */

public class AppFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState ) {
        View view = inflater.inflate(R.layout.apps_fragment, container, false);

        RecyclerView mRecyclerView=(RecyclerView)view.findViewById(R.id.apps_recycler_view);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(position == 1 || position == 2){
                    return 2;
                }
                if(position == 10){
                    return 2;
                }
                return 1;
            }
        });
        mRecyclerView.setLayoutManager(manager);

        AppFragmentAdapter mMyAdapter = new AppFragmentAdapter(BasicControls.loadApps(getActivity()),getActivity());
        mRecyclerView.setAdapter(mMyAdapter);


        return view;
    }


}
