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
import com.makinduempire.devlauncher.adapters.AppChoserAdapter;
import com.makinduempire.devlauncher.adapters.QuickAppsAdapter;
import com.makinduempire.devlauncher.models.AppDetail;
import com.makinduempire.devlauncher.models.AppRecord;
import com.makinduempire.devlauncher.utils.BasicControls;
import com.makinduempire.devlauncher.utils.RecyclerItemClickListener;

import java.util.List;

/**
 * Created by Makindu ExpressC on 12/04/2017.
 */

public class AppsChooser extends Fragment {

    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState ) {
        View view = inflater.inflate(R.layout.app_choser_fragment, container, false);

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.apps_recycler_view);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);
        final AppChoserAdapter adapter=new AppChoserAdapter(getActivity(), BasicControls.loadApps(getActivity()));
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);


        
        //setUp the other shit
        RecyclerView mQuickRecyclerView = (RecyclerView) view.findViewById(R.id.chosen_apps_recycler_view);
        GridLayoutManager Qmanager = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);

        List<AppRecord> all=new Select().from(AppRecord.class).execute();
        final QuickAppsAdapter Qadapter=new QuickAppsAdapter(getActivity(),all);
        mQuickRecyclerView.setLayoutManager(Qmanager);
        mQuickRecyclerView.setAdapter(Qadapter);

        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), mRecyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        AppDetail clicked=adapter.getApp(position);
                        //save this as app record
                        if(BasicControls.is_quick_app(clicked.name.toString())){
                            new Delete().from(AppRecord.class).where("identify = ?", clicked.name.toString()).execute();
                        }else{
                            AppRecord j=new AppRecord();
                            j.label=clicked.label.toString();
                            j.identify=clicked.name.toString();
                            j.save();
                        }
                        Qadapter.setData(new Select().from(AppRecord.class).<AppRecord>execute());
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

        return view;

    }
}
