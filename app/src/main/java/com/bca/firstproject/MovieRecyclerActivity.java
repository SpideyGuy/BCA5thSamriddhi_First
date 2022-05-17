package com.bca.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MovieRecyclerActivity extends
        AppCompatActivity implements onMovieLoaded
{

    RecyclerView rv;

    MovieRecyclerAdapter rvAdapter;

    ArrayList<Movies> moviesRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_recycler);

        rv = (RecyclerView) findViewById(R.id.movie_recycler_view);

        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(this);

        rv.setLayoutManager(layoutManager);

        moviesRecords = new ArrayList<>();

        MovieAsyncTask movieAsyncTask = new MovieAsyncTask(
                getApplicationContext(), this);
        movieAsyncTask.execute("https://yts.torrentbay.to/api/v2/list_movies.json");

    }

    @Override
    public void onMovieLoaded(ArrayList<Movies> movies) {
        rvAdapter = new MovieRecyclerAdapter(this, movies);
        rv.setAdapter(rvAdapter);
    }
}