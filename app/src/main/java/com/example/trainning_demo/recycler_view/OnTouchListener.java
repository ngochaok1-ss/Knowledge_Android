package com.example.trainning_demo.recycler_view;

public interface OnTouchListener {
    void onMove(int oldPosition, int newPosition);
    void swipe(int position, int direction);
}
