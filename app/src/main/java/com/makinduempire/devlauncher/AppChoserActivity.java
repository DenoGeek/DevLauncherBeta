package com.makinduempire.devlauncher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.makinduempire.devlauncher.fragments.AppsChooser;

/**
 * Created by Makindu ExpressC on 13/04/2017.
 */

public class AppChoserActivity extends AppCompatActivity{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooser_activity);

        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container,new AppsChooser(),"chooser fragment");
        ft.commit();

    }
}

