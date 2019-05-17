package com.joyssom.recycler.library.base;


import androidx.annotation.IntDef;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * File: RecycleViewItemData.java
 * Author: ejiang
 * Version: V100R001C01
 * Create: 2017-05-13 14:49
 */

public class RecycleViewItemData<T> implements Serializable {

    public static final int TYPE_ZERO = 0;
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;
    public static final int TYPE_FOUR = 4;
    public static final int TYPE_FIVE = 5;
    public static final int TYPE_SIX = 6;
    public static final int TYPE_SEVEN = 7;
    public static final int TYPE_EIGHT = 8;
    public static final int TYPE_NINE = 9;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({TYPE_ZERO, TYPE_ONE, TYPE_TWO, TYPE_THREE, TYPE_FOUR,
            TYPE_FIVE, TYPE_SIX, TYPE_SEVEN,
            TYPE_EIGHT, TYPE_NINE})
    public @interface recyclerViewItemType {
    }

    @recyclerViewItemType
    private int itemType;
    //是否选中
    private boolean isSel;
    private T t;

    public RecycleViewItemData(@recyclerViewItemType int itemType) {
        this.itemType = itemType;
    }

    public RecycleViewItemData(T t, @recyclerViewItemType int itemType) {
        this.t = t;
        this.itemType = itemType;
    }

    public boolean isSel() {
        return isSel;
    }

    public void setSel(boolean sel) {
        isSel = sel;
    }

    public T getT() {
        return t;
    }

    public int getItemType() {
        return itemType;
    }
}
