package com.codi.scrollingrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Codi on 2015/3/11.
 */
public class LargeAdapter extends RecyclerView.Adapter<LargeAdapter.ViewHolder> {

    private static final int LIST_SIZE = 1000;
    private ArrayList<String> items;

    public static LargeAdapter newInstance(Context context) {
        ArrayList<String> items = new ArrayList<>();
        String format = context.getString(R.string.item_string);
        for(int i = 0; i < LIST_SIZE; i++) {
            items.add(String.format(format, i + 1));
        }
        return new LargeAdapter(items);
    }

    public LargeAdapter(ArrayList<String> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_expandable_list_item_1, parent, false);
        return ViewHolder.newInstance(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String textStr = items.get(position);
        holder.setText(textStr);
    }

    @Override
    public int getItemCount() {
        return LIST_SIZE;
    }

    public static final class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        public static ViewHolder newInstance(View view) {
            TextView textView = (TextView) view.findViewById(android.R.id.text1);
            return new ViewHolder(view, textView);
        }

        public ViewHolder(View itemView, TextView textView) {
            super(itemView);
            this.textView = textView;
        }

        public void setText(CharSequence text) {
            this.textView.setText(text);
        }
    }
}
