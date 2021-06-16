package com.example.myapplication;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.ItemViewBinding;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    private final ItemViewBinding mBinding;

    public ItemViewHolder(ItemViewBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    void bind(String s) {
    }
}
