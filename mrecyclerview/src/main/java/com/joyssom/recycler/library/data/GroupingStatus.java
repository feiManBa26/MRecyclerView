package com.joyssom.recycler.library.data;

/**
 * author: mr.zang
 * date：2019-05-17
 * description: 分组 状态记录
 */
public class GroupingStatus {
    private boolean hasHeader;
    private int childrenCount;

    public boolean isHasHeader() {
        return hasHeader;
    }

    public void setHasHeader(boolean hasHeader) {
        this.hasHeader = hasHeader;
    }

    public int getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(int childrenCount) {
        this.childrenCount = childrenCount;
    }

    public GroupingStatus(boolean hasHeader, int childrenCount) {
        this.hasHeader = hasHeader;
        this.childrenCount = childrenCount;
    }
}
