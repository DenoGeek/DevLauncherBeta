package com.makinduempire.devlauncher;

import android.app.WallpaperManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RelativeLayout;

import com.makinduempire.devlauncher.fragments.AppFragment;
import com.makinduempire.devlauncher.fragments.CallLogFragment;
import com.makinduempire.devlauncher.fragments.CliFragment;
import com.makinduempire.devlauncher.fragments.QuickAppsFragment;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

/**
 * Created by Makindu ExpressC on 11/04/2017.
 */

public class HomeActivity extends AppCompatActivity {

    private FlowingDrawer mDrawer;
    private QuickAppsFragment quick_apps;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_basic);

        mDrawer = (FlowingDrawer) findViewById(R.id.drawerlayout);
        mDrawer.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL);
        mDrawer.setOnDrawerStateChangeListener(new ElasticDrawer.OnDrawerStateChangeListener() {
            @Override
            public void onDrawerStateChange(int oldState, int newState) {
                if (newState == ElasticDrawer.STATE_CLOSED) {
                    Log.i("MainActivity", "Drawer STATE_CLOSED");
                }
            }

            @Override
            public void onDrawerSlide(float openRatio, int offsetPixels) {
                Log.i("MainActivity", "openRatio=" + openRatio + " ,offsetPixels=" + offsetPixels);
            }
        });

        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        Drawable wallpaperDrawable = wallpaperManager.getDrawable();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mDrawer.setBackground(wallpaperDrawable);
        }

        setPage(1);
        SetUpHomeScreen();
    }

    public void SetUpHomeScreen(){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();

        //CallLog fragment
        quick_apps=new QuickAppsFragment();
        ft.replace(R.id.top_right, new CallLogFragment(), "callsfragment");
        ft.replace(R.id.cli_bottom, new CliFragment(), "callsfragment");
        ft.replace(R.id.top_left,quick_apps,"quick_apps");
        ft.commit();

    }

    public void setPage(int x){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        switch(x){
            case 1:
                ft.replace(R.id.id_container_menu, new AppFragment(), "appsfragment");
                ft.commit();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        quick_apps.refreshData();
    }
}
