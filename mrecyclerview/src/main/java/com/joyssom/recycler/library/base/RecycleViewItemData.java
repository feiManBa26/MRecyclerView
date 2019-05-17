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

public class RecycleViewItemData<T extends Object, T1 extends Object> implements Serializable {

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

    public RecycleViewItemData(@recyclerViewItemType int itemType) {
        this.itemType = itemType;
    }

    public RecycleViewItemData(T t, @recyclerViewItemType int itemType) {
        this.t = t;
        this.itemType = itemType;
    }

    public RecycleViewItemData(T t, T1 t1, int itemType) {
        this.t = t;
        this.t1 = t1;
        this.itemType = itemType;
    }

    public boolean isVisibieOne() {
        return isVisibieOne;
    }

    public void setVisibieOne(boolean visibieOne) {
        isVisibieOne = visibieOne;
    }

    public boolean isVisibieTwo() {
        return isVisibieTwo;
    }

    public void setVisibieTwo(boolean visibieTwo) {
        isVisibieTwo = visibieTwo;
    }

    private T t;
    private T1 t1;

    public T1 getT1() {
        return t1;
    }

    public void setT1(T1 t1) {
        this.t1 = t1;
    }

    private boolean isVisibieOne = true;
    private boolean isVisibieTwo = false;

    public RecycleViewItemData(boolean isVisibieOne, boolean isVisibieTwo, int itemType) {
        this.isVisibieOne = isVisibieOne;
        this.isVisibieTwo = isVisibieTwo;
        this.itemType = itemType;
    }

    @recyclerViewItemType
    private int itemType;

    public RecycleViewItemData(@recyclerViewItemType int itemType, @recyclerViewItemType int fooderType) {
        this.itemType = itemType;
        this.fooderType = fooderType;
    }

    //是否选中
    private boolean isSel;

    @recyclerViewItemType
    private int fooderType;

    public int getFooderType() {
        return fooderType;
    }

    public void setFooderType(int fooderType) {
        this.fooderType = fooderType;
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

    public void setT(T t) {
        this.t = t;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }
}
