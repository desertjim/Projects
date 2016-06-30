package com.android.jimitjaishwal.moviesnow.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private MovieAdapter adapter;
    private RecyclerView recyclerView;
    private String api_key = "149c3ccaa00eeb61331e4da7734fd1af";


    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void inItView(View v) {
        recyclerView = (RecyclerView) v.findViewById(R.id.movies_recyclerview);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        getMovies();
    }

    public void getMovies() {

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        MovieApiService service = retrofit.create(MovieApiService.class);
        Call<Movie> call = service.loadMovies(api_key);

        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {

                String message = response.message();
                Log.d("message", message);
                String code = new Integer(response.code()).toString();
                Log.d("message", code);
                ArrayList<MovieResult> results = response.body().getResults();
                Log.d("TAG", "Number of movies received: " + results.size());
                adapter = new MovieAdapter(getActivity(), results);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Log.d("Error", t.getMessage());

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        inItView(rootView);

        return rootView;
    }
}
