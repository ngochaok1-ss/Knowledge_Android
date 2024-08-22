package com.example.trainning_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainning_demo.recycler_view.ItemTouchedHelperCallback;
import com.example.trainning_demo.recycler_view.OnTouchListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MusicAdapter musicAdapter;
    private ItemTouchedHelperCallback itemTouchedHelperCallback;
    private List<ItemMusic> data= new ArrayList<>();
    int value = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mRecyclerView = findViewById(R.id.recycle_view);
        InitData();
        musicAdapter = new MusicAdapter(data);
        mRecyclerView.setAdapter(musicAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        mRecyclerView.setLayoutManager(linearLayoutManager);
        itemTouchedHelperCallback = new ItemTouchedHelperCallback(new OnTouchListener() {
            @Override
            public void onMove(int oldPosition, int newPosition) {
                musicAdapter.onMoveItem(oldPosition,newPosition);
            }

            @Override
            public void swipe(int position, int direction) {
                musicAdapter.onSwipeItem(position);
            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchedHelperCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

    }

    private void InitData() {
        data.add(new ItemMusic("Cơn mưa ngang qua", "Sơn Tùng MTP"));
        data.add(new ItemMusic("Khuôn mặt đáng thương", "Sơn Tùng MTP"));
        data.add(new ItemMusic("Em đừng đi", "Sơn Tùng MTP"));
        data.add(new ItemMusic("Lạc trôi", "Sơn Tùng MTP"));
        data.add(new ItemMusic("Chúng ta không thuộc về nhau", "Sơn Tùng MTP"));
        data.add(new ItemMusic("Đừng về trễ", "Sơn Tùng MTP"));
        data.add(new ItemMusic("Cơn mưa ngang qua", "Sơn Tùng MTP"));
        data.add(new ItemMusic("Khuôn mặt đáng thương", "Sơn Tùng MTP"));
        data.add(new ItemMusic("Em đừng đi", "Sơn Tùng MTP"));
        data.add(new ItemMusic("Lạc trôi", "Sơn Tùng MTP"));
        data.add(new ItemMusic("Chúng ta không thuộc về nhau", "Sơn Tùng MTP"));
        data.add(new ItemMusic("Đừng về trễ", "Sơn Tùng MTP"));
    }
}