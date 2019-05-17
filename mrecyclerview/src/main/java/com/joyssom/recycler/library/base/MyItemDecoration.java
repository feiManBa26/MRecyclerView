package com.joyssom.recycler.library.base;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * File: MyItemDecoration.java
 * Author: ejiang
 * Version: V100R001C01
 * Create: 2017-04-25 10:41
 * 设置spacing
 */

public class MyItemDecoration extends RecyclerView.ItemDecoration {

    public static final int LIST_TYPE = 0;
    public static final int GRID_VIEW_TYPE = 1;
    public static final int WATERFALL = 2;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({LIST_TYPE, GRID_VIEW_TYPE, WATERFALL})
    public @interface recycleItemDecorationListencer {
    }

    @recycleItemDecorationListencer
    private int type = LIST_TYPE;

    private int width = 0;

    public MyItemDecoration(@recycleItemDecorationListencer int type, int width) {
        this.type = type;
        this.width = width;
    }

    public MyItemDecoration(@recycleItemDecorationListencer int type) {
        this.type = type;

    }


    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {

        if (width != 0) {
            switch (type) {
                case LIST_TYPE:
                    outRect.set(0, 0, 0, width);
                    break;
                case GRID_VIEW_TYPE:
                    outRect.set(width, width, width, width);
                    break;
                default:
                    outRect.set(0, 0, 0, width);
                    break;
            }
        } else {
            switch (type) {
                case LIST_TYPE:
                    outRect.set(0, 0, 0, 1);
                    break;
                case GRID_VIEW_TYPE:
                    outRect.set(3, 3, 3, 3);
                    break;
                default:
                    outRect.set(0, 0, 0, 1);
                    break;
            }
        }
    }
}
