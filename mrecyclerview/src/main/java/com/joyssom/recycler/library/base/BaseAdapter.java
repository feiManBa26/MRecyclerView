package com.joyssom.recycler.library.base;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * author mr.zang
 * BaseAdapter
 * @param <D>
 * @param <VH>
 */
public abstract class BaseAdapter<D, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private Context mContext;
    private ArrayList<D> mds;

    public ArrayList<D> getMds() {
        return mds;
    }

    public Context getmContext() {
        return mContext;
    }

    public BaseAdapter(Context context) {
        mContext = context;
        this.mds = new ArrayList<>();
    }

    public BaseAdapter(Context context, ArrayList<D> mds) {
        mContext = context;
        this.mds = mds;
    }

    @Override
    @NonNull
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateChildViewHolder(parent, viewType);
    }

    /**
     * 创建ViewHolder
     * @param parent
     * @param viewType
     * @return
     */
    protected abstract VH onCreateChildViewHolder(ViewGroup parent, int viewType);

    /**
     *
     * @param ds
     */
    public void initMDatas(ArrayList<D> ds) {
        if (ds == null) return;
        if (ds.size() == 0) return;
        mds.clear();
        mds.addAll(ds);
        notifyDataSetChanged();
    }

    /**
     *
     * @param ds
     */
    public void initMDatasToOne(ArrayList<D> ds) {
        if (ds == null) return;
        if (ds.size() == 0) return;
        mds.clear();
        mds.addAll(0, ds);
        notifyDataSetChanged();
    }

    /**
     *
     * @param d
     */
    public void initMData(D d) {
        if (d == null) return;
        mds.add(d);
        notifyDataSetChanged();
    }

    /**
     * 初始化 添加
     * index 0 列表最前
     * @param d
     */
    public void initMDataToOne(D d) {
        if (d == null) return;
        mds.add(0, d);
        notifyDataSetChanged();
    }

    /**
     * 添加 items
     * @param ds
     */
    public void addDataModel(ArrayList<D> ds) {
        if (ds == null || ds.size() == 0) return;
        mds.addAll(ds);
        notifyDataSetChanged();
    }

    /**
     * 添加 items index 0
     * 插入列表最前
     * @param ds
     */
    public void addStartDataModel(ArrayList<D> ds) {
        if (ds == null || ds.size() == 0) return;
        mds.addAll(0, ds);
        notifyDataSetChanged();
    }

    /**
     * 添加Item
     * @param d
     */
    public void addDataModel(D d) {
        if (d == null) return;
        mds.add(d);
        notifyDataSetChanged();
    }

    /**
     * 删除所有Item
     */
    public void deleteMDatas() {
        mds.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mds != null ? mds.size() : 0;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        D d = mds.get(position);
        onBindDataViewHolder(holder, position, d);
    }

    /**
     * 绑定数据
     * @param holder
     * @param position
     * @param d
     */
    protected abstract void onBindDataViewHolder(VH holder, int position, D d);
}
