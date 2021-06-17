package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "SCROLL";

    private ActivityMainBinding mBinding;
    private ItemAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ArrayList<String> items = new ArrayList<>();
        items.add("PEEK OK");
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");
        items.add("E");
        items.add("F");

        mAdapter = new ItemAdapter(items);
        mBinding.setAdapter(mAdapter);

        mBinding.bottomSheet.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                Log.d(TAG, String.format("onScrolled(%d)", dy));
            }
        });

        BottomSheetBehavior<?> behavior = BottomSheetBehavior.from(mBinding.bottomSheet);
        behavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                Log.d(TAG, String.format("onStateChanged(%d)", (int)behavior.getExpandedOffset()));
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                Log.d(TAG, String.format("onSlide(%f)", slideOffset));
            }
        });
    }
}
