package com.autopartskinmel.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import com.autopartskinmel.R;
import com.autopartskinmel.adapter.ItemAdapter;
import com.autopartskinmel.model.Item;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemAdapter.OnItemClickListener {
    private ImageView profileIcon;

    private RecyclerView popularRecyclerItems, recentRecyclerItems;
    private ItemAdapter itemAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFields();

        profileIcon.setOnClickListener(view -> openLoginActivity());

        buildRecyclerViewOfPopularItems();
        buildRecyclerViewOfRecentItems();
    }

    private void initFields() {
        profileIcon = findViewById(R.id.profile_icon);
        popularRecyclerItems = findViewById(R.id.popular_recycler_items);
        recentRecyclerItems = findViewById(R.id.recent_recycler_items);
    }

    private void buildRecyclerViewOfPopularItems() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        popularRecyclerItems.setLayoutManager(layoutManager);

        itemAdapter = new ItemAdapter(this, getItems(), MainActivity.this);
        popularRecyclerItems.setAdapter(itemAdapter);
    }

    private void buildRecyclerViewOfRecentItems() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recentRecyclerItems.setLayoutManager(layoutManager);

        itemAdapter = new ItemAdapter(this, getItems(), MainActivity.this);
        recentRecyclerItems.setAdapter(itemAdapter);
    }

    private ArrayList<Item> getItems(){
        ArrayList<Item> itemArrayList = new ArrayList<>();
        itemArrayList.add(new Item("Item 0", R.drawable.item_image, "Rs. 2000", "(Like New)"));
        itemArrayList.add(new Item("Item 1", R.drawable.item_image, "Rs. 2000", "(Like New)"));
        itemArrayList.add(new Item("Item 2", R.drawable.item_image, "Rs. 1500", "(Used)"));
        itemArrayList.add(new Item("Item 3", R.drawable.item_image, "Rs. 5000", "(Brand New)"));
        itemArrayList.add(new Item("Item 4", R.drawable.item_image, "Rs. 1000", "(Used)"));
        itemArrayList.add(new Item("Item 5", R.drawable.item_image, "Rs. 900", "(Used)"));
        itemArrayList.add(new Item("Item 6", R.drawable.item_image, "Rs. 500", "(Used)"));
        itemArrayList.add(new Item("Item 7", R.drawable.item_image, "Rs. 1100", "(Used)"));
        itemArrayList.add(new Item("Item 8", R.drawable.item_image, "Rs. 10,000", "(Brand New)"));
        itemArrayList.add(new Item("Item 9", R.drawable.item_image, "Rs. 4000", "(Like New)"));

        return itemArrayList;
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(getApplicationContext(), "Item "+position+" clicked.", Toast.LENGTH_SHORT).show();
    }


    //On Icon clicked login will open...
    private void openLoginActivity() {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }
}