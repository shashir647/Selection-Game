package com.myowncompany.shashiranjan.selectiongame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by RAVI RANJAN on 8/11/2016.
 */
public class CustomGrid extends BaseAdapter {

    private Context mContext;
    private final String[] web;
    private final ArrayList<Integer> Imageid;

    public CustomGrid(Context c, String[] web, ArrayList<Integer> Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
        this.web = web;
    }
    @Override
    public int getCount() {
        return web.length;
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

        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_single, null);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            imageView.setImageResource(Imageid.get(position));
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
