package com.flip.sudhanshu.collapse;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("dev2qa.com - Android Collapsing Toolbar Example.");

        // Get Toolbar component.
        Toolbar toolbar = (Toolbar)findViewById(R.id.collapsing_toolbar);
        // Use Toolbar to replace default activity action bar.
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null)
        {
            // Display home menu item.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Set collapsing tool bar title.
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar_layout);
        collapsingToolbarLayout.setTitle("Collapsing Tool Bar");

        // Set collapsing tool bar image.
        ImageView collapsingToolbarImageView = (ImageView)findViewById(R.id.collapsing_toolbar_image_view);
        collapsingToolbarImageView.setImageResource(R.drawable.img1);

        // Create the RecyclerView items list.
        List<CollapsingRecyclerViewItem> itemList = new ArrayList<CollapsingRecyclerViewItem>();
        itemList.add(new CollapsingRecyclerViewItem(R.drawable.car_austin));
        itemList.add(new CollapsingRecyclerViewItem(R.drawable.car_camero));
        itemList.add(new CollapsingRecyclerViewItem(R.drawable.car_bmw));
        itemList.add(new CollapsingRecyclerViewItem(R.drawable.car_hummer));
        itemList.add(new CollapsingRecyclerViewItem(R.drawable.car_ferrari));


        // Create RecyclerView.
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.collapsing_toolbar_recycler_view);
        // Create the linear layout manager.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        // Use above layout manager for RecyclerView..
        recyclerView.setLayoutManager(linearLayoutManager);

        // Create recycler view data adapter with item list.
        Recyclerview dataAdapter = new Recyclerview(itemList);
        // Set RecyclerView data adapter.
        recyclerView.setAdapter(dataAdapter);

        // When click floating action button, popup a Toast message.
        FloatingActionButton floatingActionButton = (FloatingActionButton)findViewById(R.id.collapsing_toolbar_floating_action_button);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You click floating action button.", Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        // When user click home menu item then quit this activity.
        if(itemId==android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
