package com.joyssom.widget;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * author: mr.zang
 * date：2019-05-17
 * description:
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 分组跳转
     *
     * @param view
     */
    public void grouping(View view) {
        startActivity(new Intent(this, GroupingActivity.class));
    }
}
