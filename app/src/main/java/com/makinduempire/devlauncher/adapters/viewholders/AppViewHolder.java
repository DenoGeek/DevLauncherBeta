package com.makinduempire.devlauncher.adapters.viewholders;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.makinduempire.devlauncher.R;
import com.makinduempire.devlauncher.models.AppDetail;

/**
 * Created by Makindu ExpressC on 11/04/2017.
 */

public class AppViewHolder extends SViewHolderBase<AppDetail> {
    public volatile TextView appName;
    public volatile ImageView appIcon;
    public AppViewHolder(ViewGroup itemView) {
        super(itemView, R.layout.apps_fragment_item);
          appName=findViewById(R.id.app_label);
          appIcon=findViewById(R.id.app_icon);
    }
}