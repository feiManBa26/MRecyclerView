package com.joyssom.recycler.library.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * File: MySimpleCallback.java
 * Author: mr.zang
 * Version: 1.0
 * Create: 2017-06-01 8:35
 * description: 拖动排序回调
 */
public class MySimpleCallback extends ItemTouchHelper.Callback {

    private ItemTouchInterface mInterface;

    public MySimpleCallback(ItemTouchInterface anInterface) {
        mInterface = anInterface;
    }

    @Override
    public int getMovementFlags( @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        /*dragFlags--拖动标志*/
        /*swipeFlags--滑动标志 GridLayoutManager滑动删除关闭*/
        if (layoutManager instanceof GridLayoutManager) {
            final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
            final int swipeFlags = 0;
            return makeMovementFlags(dragFlags, swipeFlags);
        } else if (layoutManager instanceof LinearLayoutManager) {
            final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
            final int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
            return makeMovementFlags(dragFlags, swipeFlags);
        } else {
            final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
            final int swipeFlags = 0;
            return makeMovementFlags(dragFlags, swipeFlags);
        }
    }

    //调用时与元素的用户交互已经结束，也就是它也完成了它的动画时候
    @Override
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        if (mInterface != null) {
            mInterface.onMoveComplete();
        }
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder,
                          @NonNull RecyclerView.ViewHolder target) {
        if (mInterface != null) {
            final int startIndex = viewHolder.getAdapterPosition();
            final int endIndex = target.getAdapterPosition();
            mInterface.onMove(startIndex, endIndex);
            return true;
        }
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        if (mInterface != null) {
            mInterface.onSwiped(direction);
        }
    }


}
