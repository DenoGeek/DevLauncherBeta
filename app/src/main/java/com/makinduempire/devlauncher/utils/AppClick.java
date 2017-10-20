package com.makinduempire.devlauncher.utils;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.content.pm.*;
import android.view.View.*;
public class AppClick implements
OnClickListener
   {
     String myLovelyVariable;
	 Context c;
     public AppClick(String myLovelyVariable,Context c) {
          this.myLovelyVariable = myLovelyVariable;
		  this.c=c;
     }
     @Override
     public void onClick(View v)
     {

		 Intent LaunchIntent = c.getPackageManager()
			 .getLaunchIntentForPackage(myLovelyVariable);
			 LaunchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		 c.startActivity( LaunchIntent );

		 
     }

     public void forceClick(){
         Intent LaunchIntent = c.getPackageManager()
                 .getLaunchIntentForPackage(myLovelyVariable);
         LaunchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
         c.startActivity( LaunchIntent );

     }
  };
