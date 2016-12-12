package com.example.android.mydrink;

import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String[] drinks;
    String[] description;
    int [] images = {R.drawable.top, R.drawable.beers, R.drawable.wine, R.drawable.scotch, R.drawable.jin};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res=getResources();
        drinks=res.getStringArray(R.array.drink_type);
        description=res.getStringArray(R.array.descriptions);
        drinksAdapter adapter=new drinksAdapter(this,drinks,images,description);
        list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);


    }
    class drinksAdapter extends ArrayAdapter<String> {
        Context context;
        int[] images;
        String[] typeArray;
        String[] caption;
        public drinksAdapter(Context context, String[] drink_type, int imgs[], String[]desc) {
            super(context,R.layout.listview,R.id.textView3,drink_type);
            this.images=imgs;
            this.typeArray=drink_type;
            this.caption=desc;
            this.getContext();
        }



        @Override
        public View getView (int position , View convertView, ViewGroup parent){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService (Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.listview,parent,false);

            ImageView image = (ImageView) row.findViewById(R.id.imageView);
            TextView title = (TextView) row.findViewById(R.id.textView2);
            TextView description = (TextView) row.findViewById(R.id.textView3);

            image.setImageResource(images[position]);
            title.setText(typeArray[position]);
            description.setText(caption[position]);
            return row;
        }
    }

}