package com.example.myapplication;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DataBindingAdapters {
    @BindingAdapter("android:adapter")
    public static void setAdapter(RecyclerView view, RecyclerView.Adapter<?> adapter) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL, false);

        // TODO: Prevent loading two of my views already!!!
        linearLayoutManager.setMeasurementCacheEnabled(true);
        linearLayoutManager.setItemPrefetchEnabled(false);
        linearLayoutManager.setInitialPrefetchItemCount(0);

        view.setLayoutManager(linearLayoutManager);

        view.setItemViewCacheSize(0);

        // NOTE: I tried pretty much all settings...
        // MyView.onDraw() will get called! :(
        view.setAdapter(adapter);
    }

    @BindingAdapter({"android:customText"})
    public static void setMyViewText(MyView myView, String text) {
        myView.setText(text);
    }
}
