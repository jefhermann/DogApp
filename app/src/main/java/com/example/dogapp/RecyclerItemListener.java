package com.example.dogapp;

public interface RecyclerItemListener<T> {
    void itemClick(T item, int position);
}