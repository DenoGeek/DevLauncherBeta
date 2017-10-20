package com.makinduempire.devlauncher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.makinduempire.devlauncher.widgets.FontTextView;

public class SplashActivity extends AppCompatActivity {

    private ImageView step1, step2, step3;
    private TextView stage_hint;
    private int stage;
    private BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        step1 = (ImageView) findViewById(R.id.image_step1);
        step2 = (ImageView) findViewById(R.id.image_step2);
        step3 = (ImageView) findViewById(R.id.image_step3);
        stage_hint = (FontTextView) findViewById(R.id.stage_hint);

        stage = 1;
        setAtage(stage);
        configureFragment(stage);

        //broadcast receiver for buttons
        //intent filter to handle incomingpush
        IntentFilter filter = new IntentFilter();
        filter.addAction("stage");
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                stage = intent.getExtras().getInt("stage");
                setAtage(stage);
                configureFragment(stage);
            }
        };
        registerReceiver(receiver, filter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    public void configureFragment(int s) {
        switch (s) {
            case 1:
//                getSupportFragmentManager().beginTransaction().replace(R.id.package_fragmenter, new DetailsFragment()).commit();
                break;
            case 2:
//                getSupportFragmentManager().beginTransaction().replace(R.id.package_fragmenter, new DestinationPicker()).commit();
                break;
            case 3:
//                getSupportFragmentManager().beginTransaction().replace(R.id.package_fragmenter, new ScanPackageFragment()).commit();
                break;
        }
    }


    public void setAtage(int s) {
        TextDrawable one = null;
        TextDrawable two = null;
        TextDrawable three = null;

        TextView a = (TextView) findViewById(R.id.step_one_right);
        TextView b = (TextView) findViewById(R.id.step_two_left);
        TextView c = (TextView) findViewById(R.id.step_two_right);
        TextView d = (TextView) findViewById(R.id.step_three_left);
        switch (s) {
            case 1:
                stage_hint.setText("Stage 1/3: Welcome to Makindu launcher");
                one = TextDrawable.builder().buildRound("1", getResources().getColor(R.color.colorAccent));
                two = TextDrawable.builder().buildRound("2", getResources().getColor(R.color.colorPrimary));
                three = TextDrawable.builder().buildRound("3", getResources().getColor(R.color.colorPrimary));
                a.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                b.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                c.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                d.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                break;
            case 2:
                stage_hint.setText("Stage 2/3: About CLI");
                one = TextDrawable.builder().buildRound("1", getResources().getColor(R.color.colorAccent));
                two = TextDrawable.builder().buildRound("2", getResources().getColor(R.color.colorAccent));
                three = TextDrawable.builder().buildRound("3", getResources().getColor(R.color.colorPrimary));
                a.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                b.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                c.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                d.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                break;
            case 3:
                stage_hint.setText("Stage 3/3: scan barcode");
                one = TextDrawable.builder().buildRound("1", getResources().getColor(R.color.colorAccent));
                two = TextDrawable.builder().buildRound("2", getResources().getColor(R.color.colorAccent));
                three = TextDrawable.builder().buildRound("3", getResources().getColor(R.color.colorAccent));
                a.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                b.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                c.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                d.setBackgroundColor(getResources().getColor(R.color.colorAccent));

                break;
        }

        step1.setImageDrawable(one);
        step2.setImageDrawable(two);
        step3.setImageDrawable(three);
    }
}