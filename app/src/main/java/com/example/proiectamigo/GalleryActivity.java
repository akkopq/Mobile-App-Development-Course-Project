package com.example.proiectamigo;// GalleryActivity.java

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView imageViewLeft = findViewById(R.id.imageViewLeft);
        imageViewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GalleryActivity.this, MainActivity.class));
            }
        });

        ImageView imageViewRight = findViewById(R.id.imageViewRight);
        imageViewRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(GalleryActivity.this, imageViewRight);

                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == R.id.fullmenu) {
                            String url = "https://www.amigopitesti.ro/menu";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        } else if (menuItem.getItemId() == R.id.quiz) {
                            startActivity(new Intent(GalleryActivity.this, QuizActivity.class));
                        } else if (menuItem.getItemId() == R.id.account) {
                            startActivity(new Intent(GalleryActivity.this, LoginActivity.class));
                        } else if (menuItem.getItemId() == R.id.gallery) {
                            startActivity(new Intent(GalleryActivity.this, GalleryActivity.class));
                        }

                        Toast.makeText(GalleryActivity.this, "You Clicked " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popupMenu.show();
            }
        });

        int[] imageResources = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8 /*... add more image resource IDs ...*/};
        String[] imageDescriptions = {"Pizza Hot Hawaiian", "Pizza Double Pepperoni", "Pizza All Cheese ", "Pizza Rustic ", "Sandwich Pui", "Shawarma Vită", "Falafel", "Pui Crispy" /*... add more descriptions ...*/};

        GridView gridView = findViewById(R.id.gridView);
        ImageAdapter imageAdapter = new ImageAdapter(this, imageResources, imageDescriptions);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String gridDescription = imageDescriptions[position];
                String dialogDescription = "Comandă acum 1 " + gridDescription + " și primești 1 doză Coca Cola cadou";
                showImageMenu(view, position, imageResources[position], gridDescription, dialogDescription);
            }
        });

        gridView.setHorizontalSpacing(16);
        gridView.setVerticalSpacing(16);
    }

    private void showImageMenu(View view, int position, int imageResource, String gridDescription, String dialogDescription) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.image_dialog);

        ImageView imageView = dialog.findViewById(R.id.dialogImageView);
        TextView textView = dialog.findViewById(R.id.dialogTextView);

        imageView.setImageResource(imageResource);
        textView.setText(dialogDescription);

        dialog.show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.gallery_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
