package com.makinduempire.devlauncher.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import com.activeandroid.query.Select;
import com.makinduempire.devlauncher.models.AppDetail;
import com.makinduempire.devlauncher.models.AppRecord;
import com.makinduempire.devlauncher.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Makindu ExpressC on 12/04/2017.
 */

public class BasicControls {

    public static User AuthUser(){
        User x=new Select().from(User.class).executeSingle();
        if(x==null){
            BasicControls.DummifyAuthUser();
        }
        return new Select().from(User.class).executeSingle();
    }

    public static void DummifyAuthUser(){
        User n=new User();
        n.username="Makindu";
        n.save();
    }

    public static String basicCommandFormat(String s){
        StringBuilder f=new StringBuilder();
        f.append(BasicControls.AuthUser().username);
        f.append(":>> ");
        f.append(s+"\n");
        return f.toString();
    }

    public static List<AppDetail> loadApps(Context c){
        PackageManager manager = c.getPackageManager();
        List<AppDetail> apps = new ArrayList<AppDetail>();
        Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> availableActivities = manager.queryIntentActivities(i, 0);
        for(ResolveInfo ri:availableActivities){
            AppDetail app = new AppDetail();
            app.label = ri.loadLabel(manager);
            app.name = ri.activityInfo.packageName;
            app.icon = ri.activityInfo.loadIcon(manager);
            apps.add(app);
        }
        new CompareApps("g",apps,c);
        return apps;
    }

    public static boolean is_quick_app(String package_name){
        List<AppRecord> fromdb=new Select()
                .from(AppRecord.class)
                .where("identify = ?", package_name)
                .execute();

        if(fromdb.size()>0){
            return true;
        }else{
            return false;
        }

    }
}