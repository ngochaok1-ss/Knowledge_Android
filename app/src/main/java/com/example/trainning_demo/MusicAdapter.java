package com.example.trainning_demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder>{

    private List<ItemMusic> data;
    public MusicAdapter(List<ItemMusic> lst){
        this.data = lst;
    }
    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.music_item, parent,false);
        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {
        ItemMusic item = data.get(position);
        holder.tv_name.setText(item.getName());
        holder.tv_singer.setText(item.getSinger());
    }

    @Override
    public int getItemCount() {
        if (data != null) return data.size();
        return 0;
    }

    public void onMoveItem(int oldPosition, int newPosition) {
//        Collections.swap(data, oldPosition,newPosition);
//        ItemMusic temp = data.get(oldPosition);
//        data.set(oldPosition, data.get(newPosition));
//        data.set(newPosition,temp);
        data.set(oldPosition, data.set(newPosition, data.get(oldPosition)));
        notifyItemMoved(oldPosition,newPosition);
    }

    public void onSwipeItem(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    class MusicViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name, tv_singer;
        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name_music);
            tv_singer = itemView.findViewById(R.id.tv_singer);
        }
    }
}
