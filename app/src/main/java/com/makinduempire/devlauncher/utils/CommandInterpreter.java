package com.makinduempire.devlauncher.utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.widget.TextView;

import com.makinduempire.devlauncher.AppChoserActivity;

import org.w3c.dom.Text;

/**
 * Created by Makindu ExpressC on 12/04/2017.
 */

public class CommandInterpreter {

    private String pre_resolved;
    private String[] post_resolved;
    private TextView console;
    private Context context;

    public CommandInterpreter(String command, TextView cmd,Context c){
        this.pre_resolved=command;
        this.context=c;
        this.resolveCommand();
        this.console=cmd;
        operateCommand();
    }

    private void resolveCommand(){
        post_resolved=pre_resolved.split(" ");
    }

    private void operateCommand(){
        if(post_resolved.length>0){
            switch(post_resolved[0]){
                case "sudo":
                    console.append(BasicControls.basicCommandFormat("--setting database to internal--"));
                    operateSudo();
                    break;
                case "custom":
                    console.append(BasicControls.basicCommandFormat("--setting database to custom db---"));
                    operateCustom();
                    break;
                default:
                    console.append(BasicControls.basicCommandFormat("--commands must either begin in sudo or custom---"));

            }
        }else{
            console.append(BasicControls.basicCommandFormat("The command has too few arguments"));
        }
    }

    public void operateSudo(){
        for(int i=1;i<post_resolved.length;i++){
            switch (post_resolved[i]){
                case "echo":
                        StringBuilder j=new StringBuilder();
                        for (int c=i+1;c<post_resolved.length;c++){
                            j.append(post_resolved[c]+" ");
                        }
                        console.append(BasicControls.basicCommandFormat(j.toString()));
                    break;
                case "quick-apps":
                    Intent apps=new Intent(context, AppChoserActivity.class);
                    context.startActivity(apps);
                    break;
                case "open-pkg":
                        //get the next string and open it as package name
                        try{
                            String pkg=post_resolved[2];
                            new AppClick(pkg,context).forceClick();
                        }catch (NullPointerException e){
                            console.append(BasicControls.basicCommandFormat("Package is not in installed directory"));
                        }catch(IndexOutOfBoundsException f){
                            console.append(BasicControls.basicCommandFormat("Please provide the pacage name"));
                        }
                    break;

                case "bt":
                    try{
                        String pkg=post_resolved[2];
                        int state= Integer.parseInt(pkg);

                    }catch (NullPointerException e){
                        console.append(BasicControls.basicCommandFormat("Please provide a toggle state of 1 or 0"));
                    }catch(IndexOutOfBoundsException f){
                        console.append(BasicControls.basicCommandFormat("Please provide a toggle state of 1 or 0"));
                    }
                    break;
                case "wifi":
                    break;
            }
        }
    }

    public void operateCustom(){

    }
}
