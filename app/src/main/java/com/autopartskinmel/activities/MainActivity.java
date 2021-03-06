package com.autopartskinmel.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.autopartskinmel.R;
import com.autopartskinmel.adapter.ItemAdapter;
import com.autopartskinmel.model.Item;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TextWatcher, NavigationView.OnNavigationItemSelectedListener, ItemAdapter.OnItemClickListener {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private MaterialCardView profileLayout;

    private EditText searchField;
    private ImageView editProfile, searchIcon, searchClear;

    private RecyclerView popularRecyclerItems, recentRecyclerItems;
    private ItemAdapter itemAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFields();
        setSupportActionBar(toolbar);

        handleNavigationEvent();

        searchField.addTextChangedListener(this);

        buildRecyclerViewOfPopularItems();
        buildRecyclerViewOfRecentItems();
    }

    private void initFields() {
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.navigation_view);
        View header = navigationView.getHeaderView(0);
        profileLayout = header.findViewById(R.id.image_card_layout);
        editProfile = header.findViewById(R.id.edit_profile);

        searchField = findViewById(R.id.search_field);
        searchIcon = findViewById(R.id.search_icon);
        searchClear = findViewById(R.id.search_bar_clear);
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



    // all navigation items event will be handled here...
    private void handleNavigationEvent() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //On navigation item clicked...
        navigationView.setNavigationItemSelectedListener(this);

        editProfile.setOnClickListener(view -> openEditProfileActivity());
        profileLayout.setOnClickListener(view -> openLoginActivity());
    }

    //On Icon clicked login will open...
    private void openLoginActivity() {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }


    //On clicked edit profile will open...
    private void openEditProfileActivity() {
        startActivity(new Intent(this, EditProfileActivity.class));
    }




    /* -------- Implemented methods -------- */


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        String itemName = searchField.getText().toString();

        if (itemName.isEmpty()){
            searchIcon.setVisibility(View.VISIBLE);
            searchClear.setVisibility(View.GONE);

            return;
        }

        searchIcon.setVisibility(View.GONE);
        searchClear.setVisibility(View.VISIBLE);

        searchClear.setOnClickListener(view -> {
            searchField.setText("");
            searchIcon.setVisibility(View.VISIBLE);
        });
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.car_accessories){
            Toast.makeText(this, "Car Accessories", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.car_parts){
            Toast.makeText(this, "Car Parts", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.motorcycle_accessories){
            Toast.makeText(this, "Motorcycle Accessories", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.motorcycle_helmet){
            Toast.makeText(this, "Motorcycle Helmet", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.motorcycle_parts){
            Toast.makeText(this, "Motorcycle Parts", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.motorcycle_riding_wear){
            Toast.makeText(this, "Motorcycle Riding Wear", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.motorcycle_tyre_and_wheel){
            Toast.makeText(this, "Motorcycle Tyre and Wheel", Toast.LENGTH_SHORT).show();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(getApplicationContext(), "Item "+position+" clicked.", Toast.LENGTH_SHORT).show();
    }
}