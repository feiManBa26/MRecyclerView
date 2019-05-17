package com.joyssom.widget;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.joyssom.recycler.library.base.RecycleViewItemData;
import com.joyssom.widget.adapter.GroupingAdapter;

import java.util.ArrayList;

/**
 * author: mr.zang
 * date：2019-05-17
 * description:
 */
public class GroupingActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private GroupingAdapter groupingAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grouping);
        initView();
        initData();
    }

    private void initData() {
        ArrayList<RecycleViewItemData> as = new ArrayList<>();
        as.add(new RecycleViewItemData<>("2019/05/17", RecycleViewItemData.TYPE_ZERO));
        for (int i = 0; i < 10; i++) {
            as.add(new RecycleViewItemData<>("", RecycleViewItemData.TYPE_ONE));
        }

        as.add(new RecycleViewItemData<>("2019/05/17", RecycleViewItemData.TYPE_ZERO));
        for (int i = 0; i < 18; i++) {
            as.add(new RecycleViewItemData<>("", RecycleViewItemData.TYPE_ONE));
        }

        as.add(new RecycleViewItemData<>("2019/05/17", RecycleViewItemData.TYPE_ZERO));
        for (int i = 0; i < 30; i++) {
            as.add(new RecycleViewItemData<>("", RecycleViewItemData.TYPE_ONE));
        }

        as.add(new RecycleViewItemData<>("2019/05/17", RecycleViewItemData.TYPE_ZERO));
        for (int i = 0; i < 22; i++) {
            as.add(new RecycleViewItemData<>("", RecycleViewItemData.TYPE_ONE));
        }

        groupingAdapter.initMDatas(as);
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        groupingAdapter = new GroupingAdapter(this);
        mRecyclerView.setAdapter(groupingAdapter);
    }
}
