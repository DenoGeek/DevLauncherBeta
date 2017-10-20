package com.makinduempire.devlauncher.utils;

import android.content.Context;

import com.makinduempire.devlauncher.models.AppDetail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Makindu ExpressC on 11/04/2017.
 */

public class CompareApps implements
        Comparator<AppDetail> {
    private List<AppDetail> apps = new ArrayList<AppDetail>
            ();
    Context context;
    public CompareApps(String str,List<AppDetail> apps,
                       Context context) {
        this.apps = apps;
        this.context = context;
        Collections.sort(this.apps, this);
    }
    @Override
    public int compare(AppDetail lhs, AppDetail rhs) {
        // TODO Auto-generated method stub
        return lhs.label.toString().toUpperCase().compareTo
                (rhs.label.toString().toUpperCase());
    }
}