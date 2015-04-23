package com.flesh.simplecolorfiltersviewslibrary;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by afleshner on 4/23/2015.
 */
public class cfImageView extends ImageView {

    private Context mContext;
    //Default is SRC_ATOP
    private PorterDuff.Mode ColorFilterMode = PorterDuff.Mode.SRC_ATOP;

    public cfImageView(Context context) {
        super(context);
        mContext = context;

    }

    public cfImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        accessAttrs(attrs);
    }

    private void accessAttrs(AttributeSet attrs) {
        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.ColorOptionsView, 0, 0);
        int colorFilter = a.getColor(R.styleable.ColorOptionsView_colorFilter, android.R.color.transparent);
        String colorFilterType = a.getString(R.styleable.ColorOptionsView_colorFilterType);
        a.recycle();
        this.setColorFilter(colorFilter, GetColorFilterType(colorFilterType));
    }

    // Sets the color filter for that image.
    private PorterDuff.Mode GetColorFilterType(String colorFilterType) {
        try {
            switch (colorFilterType) {
                case "ADD":
                    ColorFilterMode = PorterDuff.Mode.ADD;
                    break;
                case "CLEAR":
                    ColorFilterMode = PorterDuff.Mode.CLEAR;
                    break;
                case "DARKEN":
                    ColorFilterMode = PorterDuff.Mode.DARKEN;
                    break;
                case "DST":
                    ColorFilterMode = PorterDuff.Mode.DST;
                    break;
                case "DST_ATOP":
                    ColorFilterMode = PorterDuff.Mode.DST_ATOP;
                    break;
                case "DST_IN":
                    ColorFilterMode = PorterDuff.Mode.DST_IN;
                    break;
                case "DST_OUT":
                    ColorFilterMode = PorterDuff.Mode.DST_OUT;
                    break;
                case "DST_OVER":
                    ColorFilterMode = PorterDuff.Mode.DST_OVER;
                    break;
                case "LIGHTEN":
                    ColorFilterMode = PorterDuff.Mode.LIGHTEN;
                    break;
                case "MULTIPLY":
                    ColorFilterMode = PorterDuff.Mode.MULTIPLY;
                    break;
                case "OVERLAY":
                    ColorFilterMode = PorterDuff.Mode.OVERLAY;
                    break;
                case "SCREEN":
                    ColorFilterMode = PorterDuff.Mode.SCREEN;
                    break;
                case "SRC":
                    ColorFilterMode = PorterDuff.Mode.SRC;
                    break;
                case "SRC_ATOP":
                    ColorFilterMode = PorterDuff.Mode.SRC_ATOP;
                    break;
                case "SRC_IN":
                    ColorFilterMode = PorterDuff.Mode.SRC_IN;
                    break;
                case "SRC_OUT":
                    ColorFilterMode = PorterDuff.Mode.SRC_OUT;
                    break;
                case "SRC_OVER":
                    ColorFilterMode = PorterDuff.Mode.SRC_OVER;
                    break;
                case "XOR":
                    ColorFilterMode = PorterDuff.Mode.XOR;
                    break;
            }
        } catch (NullPointerException e) {
            //Do nothing because it is not there.
        }
        return ColorFilterMode;
    }
}

