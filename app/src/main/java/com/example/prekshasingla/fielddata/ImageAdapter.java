package com.example.prekshasingla.fielddata;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

//import com.squareup.picasso.Picasso;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

class ImageAdapter extends ArrayAdapter<FieldData>
{
    public ArrayList<FieldData> fieldDataList;

    public ImageAdapter(Activity context, ArrayList<FieldData> fieldDataList) {
        super(context, 0, fieldDataList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FieldData fieldData = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_view, parent, false);
        }


        ImageView posterView = (ImageView) convertView.findViewById(R.id.imageView);

        byte[] img=fieldData.image;
        ByteArrayInputStream imageStream = new ByteArrayInputStream(img);
        Bitmap photo = BitmapFactory.decodeStream(imageStream);
        posterView.setImageBitmap(photo);
  //        Picasso.with(getContext()).load(movie.image).into(posterView);

        return convertView;
    }


}
