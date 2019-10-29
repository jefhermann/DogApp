package com.example.dogapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerItemListener<Menu> {

    ArrayList<Menu> menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        // create an array list
        ArrayList<Menu> menu = new ArrayList();

        menu.add(new Menu("Ajouter un chien", R.drawable.plus));
        menu.add(new Menu("Voir un chien", R.drawable.view));
        menu.add(new Menu("Modifier un chien", R.drawable.plus));
        menu.add(new Menu("Supprimer un chien", R.drawable.minus));

        RecyclerView rvMenus = (RecyclerView) findViewById(R.id.rvMenus);

        // Create adapter passing in the sample user data
        MenusAdapter adapter = new MenusAdapter(menu);
        adapter.setListener(this);

        // Attach the adapter to the recyclerview to populate items
        rvMenus.setAdapter(adapter);
        // Set layout manager to position the items
        rvMenus.setLayoutManager(new LinearLayoutManager(this));
        // That's all!

    }

    @Override
    public void itemClick(Menu menu, int position) {
        Toast.makeText(this, menu.getNomMenu(), Toast.LENGTH_LONG).show();
        switch (position){
            case 0: {
                Intent i = new Intent(MainActivity.this, AddDogActivity.class);
                startActivity(i);

                break;
            }
            case 1: {
                Intent i = new Intent(MainActivity.this, ViewDogActivity.class);
                startActivity(i);
                break;
            }
            case 2: {
                Intent i = new Intent(MainActivity.this, EditDogActivity.class);
                startActivity(i);
                break;
            }
            case 3: {
                Intent i = new Intent(MainActivity.this, DeleteDogActivity.class);
                startActivity(i);
                break;
            }
        }
    }
}
