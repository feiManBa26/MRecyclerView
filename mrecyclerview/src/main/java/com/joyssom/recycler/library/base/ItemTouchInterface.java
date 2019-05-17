package com.joyssom.recycler.library.base;

/**
 * File: ItemTouchInterface.java
 * Author: ejiang
 * Version: V100R001C01
 * Create: 2017-06-01 8:37
 */

public interface ItemTouchInterface {
    /**
     * 拖动排序
     * @param startIndex
     * @param endIndex
     */
    void onMove(int startIndex, int endIndex);

    /**
     * 侧滑删除
     * @param index
     */
    void onSwiped(int index);
    /**
     * 拖动完成动画
     */
    void onMoveComplete();
}
