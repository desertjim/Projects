package com.android.jimitjaishwal.moviesnow.app;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jimit Jaishwal on 6/18/2016.
 */
public class MovieHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView textView;

    public MovieHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.poster_path);
        textView = (TextView) itemView.findViewById(R.id.original_title);
    }
}
