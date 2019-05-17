package com.joyssom.widget.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.joyssom.recycler.library.base.BaseAdapter;
import com.joyssom.recycler.library.base.RecycleViewItemData;
import com.joyssom.widget.R;

import java.util.ArrayList;

/**
 * author: mr.zang
 * date：2019-05-17
 * description:
 */
public class GroupingAdapter extends BaseAdapter<RecycleViewItemData, RecyclerView.ViewHolder> {


    public GroupingAdapter(Context context) {
        super(context);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        if (viewType == RecycleViewItemData.TYPE_ZERO)
            return new IndicatorViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.indicator_item, parent, false));
        if (viewType == RecycleViewItemData.TYPE_ONE)
            return new GroupingViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.grouping_item, parent, false));
        return null;
    }

    @Override
    protected void onBindDataViewHolder(RecyclerView.ViewHolder holder, int position, RecycleViewItemData recycleViewItemData) {
        if (holder instanceof IndicatorViewHolder) {
            String str = (String) recycleViewItemData.getT();
            ((IndicatorViewHolder) holder).mTxtIndicator.setText(str);
        }
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull final RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = (GridLayoutManager) layoutManager;
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (getItemViewType(position) == RecycleViewItemData.TYPE_ONE)
                        return 1;
                    else
                        return 4;
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        ArrayList<RecycleViewItemData> mds = getMds();
        if (mds != null && mds.size() > 0) {
            return mds.get(position).getItemType();
        } else
            return super.getItemViewType(position);
    }

    /**
     * 数据
     */
    static class GroupingViewHolder extends RecyclerView.ViewHolder {

        public GroupingViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    /**
     * 指示器
     */
    static class IndicatorViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private TextView mTxtIndicator;

        public IndicatorViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            this.mTxtIndicator = (TextView) view.findViewById(R.id.txt_indicator);
        }


    }

}
