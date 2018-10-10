package com.wulias.project.tool;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;

/**
 * Created by 曹小贼 on 2018/8/15.
 */

public class ImagLoad {
    private static volatile ImagLoad glideImagLoad;
    private RequestManager requestManager;
    private RequestBuilder<Drawable> requestBuilder;

    public static ImagLoad install() {
        if (glideImagLoad == null) {
            synchronized (ImagLoad.class) {
                if (glideImagLoad == null) {
                    glideImagLoad = new ImagLoad();
                }
            }
        }
        return glideImagLoad;
    }

    /**
     * with方法
     **/
    public ImagLoad with(Activity context) {
        requestManager = Glide.with(context);
        return this;
    }

    public ImagLoad with(FragmentActivity context) {
        requestManager = Glide.with(context);
        return this;
    }

    public ImagLoad with(Fragment context) {
        requestManager = Glide.with(context);
        return this;
    }

    public ImagLoad with(android.support.v4.app.Fragment context) {
        requestManager = Glide.with(context);
        return this;
    }

    public ImagLoad with(Context context) {
        requestManager = Glide.with(context);
        return this;
    }

    /**
     * load方法
     **/
    public ImagLoad load(int value) {
        requestBuilder = requestManager.load(value);
        return this;
    }

    public ImagLoad load(File value) {
        requestBuilder = requestManager.load(value);
        return this;
    }

    public ImagLoad load(String value) {
        requestBuilder = requestManager.load(value);
        return this;
    }

    public ImagLoad load(Object[] value) {
        requestBuilder = requestManager.load(value);
        return this;
    }

    public ImagLoad load(Object value) {
        requestBuilder = requestManager.load(value);
        return this;
    }

    public ImagLoad apply(int w, int h, BitmapTransformation transform) {
        RequestOptions options = new RequestOptions();
        if (w > 0 && h > 0) {

            options.override(w, h);
        }

        if (transform != null) {

            options.transform(transform);
        }
        requestBuilder.apply(options);
        return this;
    }

    public ImagLoad apply(ImageView imageView) {
        requestBuilder.into(imageView);
        return this;
    }

    public ImagLoad into(ImageView imageView) {
        requestBuilder.into(imageView);
        return this;
    }

}
