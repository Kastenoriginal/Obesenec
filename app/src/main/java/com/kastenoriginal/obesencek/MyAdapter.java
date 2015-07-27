package com.kastenoriginal.obesencek;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter{

    private final Context context;
    private ArrayList<Letter> letters;

    public MyAdapter(Context context, ArrayList<Letter> letters){
        this.context = context;
        this.letters = letters;
    }

    @Override
    public int getCount() {
        return 0;
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
        return null;
    }
}
