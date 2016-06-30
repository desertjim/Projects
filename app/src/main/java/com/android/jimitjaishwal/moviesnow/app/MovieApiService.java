package com.android.jimitjaishwal.moviesnow.app;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jimit Jaishwal on 6/18/2016.
 */
public interface MovieApiService {

    @GET("movie/top_rated")
    Call<Movie> loadMovies(@Query("api_key") String sort_by);
}
