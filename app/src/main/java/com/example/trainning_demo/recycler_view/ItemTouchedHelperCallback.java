package com.example.trainning_demo.recycler_view;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class ItemTouchedHelperCallback extends ItemTouchHelper.Callback {
    private OnTouchListener listener;
    public ItemTouchedHelperCallback(OnTouchListener onTouchListener){
        listener = onTouchListener;
    }
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int drag = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipe = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        return makeMovementFlags(drag, swipe);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        listener.onMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        listener.swipe(viewHolder.getAdapterPosition(),direction);
    }
}
