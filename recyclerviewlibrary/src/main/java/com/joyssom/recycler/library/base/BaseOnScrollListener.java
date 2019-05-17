package com.joyssom.recycler.library.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * File: BaseOnScrollListener.java
 * Author: ejiang
 * Version: V100R001C01
 * Create: 2017-08-25 9:48
 */

public abstract class BaseOnScrollListener extends RecyclerView.OnScrollListener {

    private boolean loading = true;
    private int mVisibleItemCount;
    private int mTotalItemCount;
    private int mPastVisibleItems;

    @Override
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
            LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (manager != null) {
                int visibleItemPosition = manager.findFirstCompletelyVisibleItemPosition();
                if (visibleItemPosition == 0) {
                    findFirstCompletelyVisibleItemPosition();
                } else {
                    completelyVisibleItemPosition();
                }
            }
        }
    }

    protected abstract void completelyVisibleItemPosition();

    /**
     * 判断mRecyclerView是否滑动到底部
     *
     * @return
     */
    boolean isScrollBottom(RecyclerView mRecyclerView) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
        if (linearLayoutManager != null && mRecyclerView.getAdapter() != null) {
            if (linearLayoutManager.findLastVisibleItemPosition() == (mRecyclerView.getAdapter().getItemCount() - 1)) {
                return true;
            } else {
                return false;
            }
        } else return false;
    }

    /**
     * Callback method to be invoked when the RecyclerView has been scrolled. This will be
     * called after the scroll has completed.
     * <p>
     * This callback will also be called if visible item range changes after a layout
     * calculation. In that case, dx and dy will be 0.
     *
     * @param recyclerView The RecyclerView which scrolled.
     * @param dx           The amount of horizontal scroll.
     * @param dy           The amount of vertical scroll.
     */
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        //        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        //        mVisibleItemCount = linearLayoutManager.getChildCount();
        //        mTotalItemCount = linearLayoutManager.getItemCount();
        //        mPastVisibleItems = linearLayoutManager.findFirstVisibleItemPosition();
        //        if ((mVisibleItemCount + mPastVisibleItems) >= mTotalItemCount) {
        //            onScrolledToTop(); //上拉加载更多
        //        }
        if (dy < 0) {
            onScrolledUp();
        } else if (dy > 0) {
            onScrolledDown();
        }
        if (!recyclerView.canScrollVertically(-1)) {
            onScrolledToBottom();
        }
        if (!recyclerView.canScrollVertically(1)) {
            onScrolledToTop();
        }
    }

    public abstract void onScrolledToTop();

    public abstract void onScrolledToBottom();

    public abstract void onScrolledUp();

    public abstract void onScrolledDown();

    public abstract void findFirstCompletelyVisibleItemPosition();
}


