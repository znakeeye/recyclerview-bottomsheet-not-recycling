package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private SheetAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new SheetAdapter(this);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.pager.setAdapter(mAdapter);

        new TabLayoutMediator(mBinding.tabs, mBinding.pager,
                (tab, position) -> tab.setText("Foo")
        ).attach();
    }
}