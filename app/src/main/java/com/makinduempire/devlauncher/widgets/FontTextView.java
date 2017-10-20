package com.makinduempire.devlauncher.widgets;

/**
 * Created by Makindu Express on 11/18/2016.
 */

import android.graphics.Typeface;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.makinduempire.devlauncher.R;


public class FontTextView extends TextView {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FontTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public FontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public FontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);

    }

    public FontTextView(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.FontTextView);
            String fontName = a.getString(R.styleable.FontTextView_font);

            try {
                if (fontName != null) {
                    Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + fontName);
                    setTypeface(myTypeface);
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("Font",e.getMessage());
            }

            a.recycle();
        }
    }
}
//private void init(AttributeSet attrs) {
//        if (attrs != null) {
//        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CustomTextView);
//        String fontName = a.getString(R.styleable.CustomTextView_font);
//
//        try {
//        if (fontName != null) {
//        Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + fontName);
//        setTypeface(myTypeface);
//        }
//        } catch (Exception e) {
//        e.printStackTrace();
//        }
//
//        a.recycle();
//        }
//        }


