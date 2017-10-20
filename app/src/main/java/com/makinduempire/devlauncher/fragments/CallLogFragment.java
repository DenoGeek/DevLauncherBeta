package com.makinduempire.devlauncher.fragments;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.CallLog;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.makinduempire.devlauncher.R;

import java.util.Date;
import java.util.Random;

/**
 * Created by Makindu ExpressC on 11/04/2017.
 */

public class CallLogFragment extends Fragment {

    private TextView console;
    private String[] calls;
    private  int ticks;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.call_log_fragment, container, false);

        console = (TextView) view.findViewById(R.id.console);
        console.setText("initializing...");
        calls = new String[]{
                "..attempting retieval"
        };
        getCallDetails(getActivity());

        //do hack shit with the data
        ticks=0;
        ticker();

        return view;
    }

    public void ticker(){
        new CountDownTimer(3000, 500) { // adjust the
            //milli seconds here
            int progress;
            public void onTick(long millisUntilFinished) {
                Random r = new Random();
                int max=calls.length;
                int i1 = r.nextInt(max - 0) + 0;
                console.append(calls[i1]+"\n");
                ticks++;
            }
            public void onFinish() {
                if(ticks>15){
                    console.setText("");
                }
                ticker();
            }
        }.start();
    }
    private void getCallDetails(Context c) {
        if (ActivityCompat.checkSelfPermission(c, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        StringBuilder sb = new StringBuilder();

        Cursor managedCursor = c.getContentResolver().query
                (android.provider.CallLog.Calls.CONTENT_URI, null, null,
                        null, null);int number = managedCursor.getColumnIndex
                ( CallLog.Calls.NUMBER );
        int type = managedCursor.getColumnIndex
                ( CallLog.Calls.TYPE );
        int date = managedCursor.getColumnIndex
                ( CallLog.Calls.DATE);
        int duration = managedCursor.getColumnIndex
                ( CallLog.Calls.DURATION);
        sb.append( "Call Details :");
        while ( managedCursor.moveToNext() ) {
            String phNumber = managedCursor.getString( number );
            String callType = managedCursor.getString( type );
            String callDate = managedCursor.getString( date );
            Date callDayTime = new Date(Long.valueOf(callDate));
            String callDuration = managedCursor.getString( duration );
            String dir = null;
            int dircode = Integer.parseInt( callType );
            switch( dircode ) {
                case CallLog.Calls.OUTGOING_TYPE:
                    dir = "OUTGOING";
                    break;
                case CallLog.Calls.INCOMING_TYPE:
                    dir = "INCOMING";
                    break;
                case CallLog.Calls.MISSED_TYPE:
                    dir = "MISSED";
                    break;
            }
            sb.append( "Retrieving log of "+phNumber +"Activity under:--- "+dir+"On :--- "+callDayTime+" Over--- "+callDuration );
            sb.append(";");
        }
        managedCursor.close();
        calls=sb.toString().split(";");

    }

}
