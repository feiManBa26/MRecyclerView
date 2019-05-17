package com.joyssom.recycler.library;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * author: mr.zang
 * date：2019-05-17
 * description:
 */
public class MRecyclerView extends RecyclerView {

    public MRecyclerView(@NonNull Context context) {
        this(context, null);
    }

    public MRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
