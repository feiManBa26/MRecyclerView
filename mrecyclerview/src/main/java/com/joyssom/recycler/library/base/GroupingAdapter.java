package com.joyssom.recycler.library.base;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joyssom.recycler.library.data.GroupingModel;

import java.util.ArrayList;

/**
 * author: mr.zang
 * date：2019-05-17
 * description: 分组Adapter
 * 分组
 * 可折叠
 */
public abstract class GroupingAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private Context context;
    private ArrayList<GroupingModel> gModels;

    public GroupingAdapter(Context context, ArrayList<GroupingModel> gModels) {
        this.context = context;
        this.gModels = gModels;
    }

    public GroupingAdapter(Context context) {
        this.context = context;
    }

    public void initGroupingModels(ArrayList<GroupingModel> gms) {
        if (gms == null || gms.size() == 0)
            throw new NullPointerException("分组数据列表 为空 或者 长度为0");
        this.gModels = gms;
        notifyDataSetChanged();
    }

    public void addGroupingModels(ArrayList<GroupingModel> gms) {
        if (gms == null)
            throw new NullPointerException("分组数据列表 为空");
        if (gms.size() == 0) return;
        this.gModels.addAll(gms);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return gModels == null || gModels.size() == 0 ? 0 : gModels.size();
    }

    /**
     * 获取组的数量
     * @return
     */
    public abstract int getGroupCount();

    /**
     * 获取组 孩子的数量
     * @param groupPosition
     * @return
     */
    public abstract int getChildrenCount(int groupPosition);

    public abstract boolean hasHeader(int groupPosition);

    public abstract int getHeaderLayout(int viewType);

    public abstract int getChildLayout(int viewType);

    public abstract void onBindHeaderViewHolder(VH vh, int groupPosition);

    public abstract void onBindChildViewHolder(VH vh, int groupPosition, int childPosition);
}
