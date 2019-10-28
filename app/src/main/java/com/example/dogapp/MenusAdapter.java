package com.example.dogapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class MenusAdapter extends RecyclerView.Adapter<MenusAdapter.ViewHolder> {

    private RecyclerItemListener<Menu> listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View menuView = inflater.inflate(R.layout.menu_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(menuView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        // Get the data model based on position
        final Menu menus = mMenus.get(position);

        // Set item views based on your views and data model
        ImageView imageView = holder.nomImageView;
        imageView.setImageResource(menus.getImgMenu());
        TextView textView = holder.nomTextView;
        textView.setText(menus.getNomMenu());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.itemClick(menus, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMenus == null ? 0 : mMenus.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nomTextView;
        public ImageView nomImageView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nomTextView = (TextView) itemView.findViewById(R.id.tvMenu);
            nomImageView = (ImageView) itemView.findViewById(R.id.imgMenu);
        }
    }

    // Store a member variable for the contacts
    private ArrayList<Menu> mMenus;

    // Pass in the contact array into the constructor
    public MenusAdapter(ArrayList<Menu> menus) {
        mMenus = menus;
    }

    public void setListener(RecyclerItemListener listener) {
        this.listener = listener;
    }
}
