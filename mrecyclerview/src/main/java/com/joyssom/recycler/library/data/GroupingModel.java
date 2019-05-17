package com.joyssom.recycler.library.data;

import java.util.ArrayList;

/**
 * author: mr.zang
 * date：2019-05-17
 * description:
 */
public class GroupingModel {

    private String groupName; //分组名称
    private boolean isSel; //是否选中
    private ArrayList<ChildModel> childModels; //孩子列表

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean isSel() {
        return isSel;
    }

    public void setSel(boolean sel) {
        isSel = sel;
    }

    public ArrayList<ChildModel> getChildModels() {
        return childModels;
    }

    public void setChildModels(ArrayList<ChildModel> childModels) {
        this.childModels = childModels;
    }
}
