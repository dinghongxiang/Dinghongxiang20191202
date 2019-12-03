package com.bawei.dinghongxiang20191203.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.AppComponentFactory;

public abstract class  BaseActivity extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(LayoutId());

        initView();

        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int LayoutId();
}
