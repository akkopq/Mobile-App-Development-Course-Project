package com.example.proiectamigo;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.PopupMenu;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView imageViewLeft = findViewById(R.id.imageViewLeft);
        imageViewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

        ImageView imageViewRight = findViewById(R.id.imageViewRight);
        imageViewRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, imageViewRight);

                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == R.id.fullmenu) {
                            String url = "https://www.amigopitesti.ro/menu";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        } else if (menuItem.getItemId() == R.id.quiz) {
                            startActivity(new Intent(MainActivity.this, QuizActivity.class));
                        } else if (menuItem.getItemId() == R.id.account) {
                            startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        } else if (menuItem.getItemId() == R.id.gallery) {
                            startActivity(new Intent(MainActivity.this, GalleryActivity.class));
                        }

                        Toast.makeText(MainActivity.this, "You Clicked " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popupMenu.show();
            }
        });
        ImageView webImageView = findViewById(R.id.webImageView);

        String imageUrl = "https://images.pexels.com/photos/2725744/pexels-photo-2725744.jpeg";

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.placeholder);  // Replace with your placeholder resource
        webImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        Glide.with(this)
                .load(imageUrl)
                .apply(requestOptions)
                .into(webImageView);
    }

    }
