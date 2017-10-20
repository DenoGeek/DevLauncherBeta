package com.makinduempire.devlauncher.models;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.makinduempire.devlauncher.R;

/**
 * Created by Makindu ExpressC on 12/04/2017.
 */

@Table(name = "appsrecord")
public class AppRecord extends Model {
    // If name is omitted, then the field name is used.
    @Column(name = "label")
    public String label;

    @Column(name = "identify")
    public String identify;

    public Drawable getIcon(Context c){
        Drawable d;
        d=null;
        try {
            d = c.getPackageManager().getApplicationIcon(this.identify);
        } catch(Exception  e) {
            e.printStackTrace();
        }
        return d;
    }

}