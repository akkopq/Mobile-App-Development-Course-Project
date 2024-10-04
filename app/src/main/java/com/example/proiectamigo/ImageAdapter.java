package com.example.proiectamigo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {

    private final Context context;
    private final int[] imageResources;
    private final String[] imageDescriptions;

    public ImageAdapter(Context context, int[] imageResources, String[] imageDescriptions) {
        this.context = context;
        this.imageResources = imageResources;
        this.imageDescriptions = imageDescriptions;
    }

    @Override
    public int getCount() {
        return imageResources.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridViewItem;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            gridViewItem = new View(context);
            gridViewItem = inflater.inflate(R.layout.grid_item, null);

            ImageView imageView = gridViewItem.findViewById(R.id.gridImageView);
            TextView textView = gridViewItem.findViewById(R.id.gridTextView);

            imageView.setImageResource(imageResources[position]);
            textView.setText(imageDescriptions[position]);

            return gridViewItem;
        } else {
            gridViewItem = convertView;
        }

        return gridViewItem;
    }
}
