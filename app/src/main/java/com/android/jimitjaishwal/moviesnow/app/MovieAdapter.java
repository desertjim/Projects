package com.android.jimitjaishwal.moviesnow.app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Jimit Jaishwal on 6/18/2016.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieHolder> {

    public List<MovieResult> movieList;
    Context mContext;

    public MovieAdapter(Context mContext, List<MovieResult> resultsBeen) {
        this.mContext = mContext;
        this.movieList = resultsBeen;

    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(mContext).inflate(R.layout.card_movie_item, parent, false);
        return new MovieHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        MovieResult result = movieList.get(position);

        String posterUrl = "http://image.tmdb.org/t/p/w185" + result.getPoster_path();
        Log.d("Url = = = ", posterUrl);
        holder.textView.setText(result.getOriginal_title());
        Picasso.with(mContext).load(posterUrl).resize(185, 277).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
