package com.bca.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MovieRecyclerActivity extends
        AppCompatActivity
//        implements onMovieLoaded
{

    RecyclerView rv;

    MovieRecyclerAdapter rvAdapter;

    ArrayList<Movies> moviesRecords;

    String url = "https://yts.torrentbay.to/api/v2/list_movies.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_recycler);

        rv = (RecyclerView) findViewById(R.id.movie_recycler_view);

        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(this);

        rv.setLayoutManager(layoutManager);

        moviesRecords = new ArrayList<>();

//        MovieAsyncTask movieAsyncTask = new MovieAsyncTask(
//                getApplicationContext(), this);
//        movieAsyncTask.execute("https://yts.torrentbay.to/api/v2/list_movies.json");

//        With Volley
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new ResponseListener(),
                new ErrorListener());

        queue.add(request);

    }

    private class ResponseListener implements Response.Listener {

        @Override
        public void onResponse(Object response) {
            JSONObject data = null;
            try {
                data = new JSONObject(response.toString());
                JSONObject dataObject = null;
                dataObject = data.getJSONObject("data");
                JSONArray movies = dataObject.getJSONArray("movies");

                for (int i = 0; i < movies.length(); i++) {
                    JSONObject movieObject = movies.getJSONObject(i);
                    Movies movie = new Movies(
                            movieObject.getString("title"),
                            movieObject.getString("summary"),
                            movieObject.getString("large_cover_image"),
                            movieObject.getString("rating"));
                    moviesRecords.add(movie);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            finally {
                rvAdapter = new MovieRecyclerAdapter(
                        MovieRecyclerActivity.this,
                        moviesRecords);
                rv.setAdapter(rvAdapter);
            }
        }
    }

    private class ErrorListener implements Response.ErrorListener{
        @Override
        public void onErrorResponse(VolleyError error){
            Toast.makeText(MovieRecyclerActivity.this,
                    error.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
    }

//    @Override
//    public void onMovieLoaded(ArrayList<Movies> movies) {
//        rvAdapter = new MovieRecyclerAdapter(this, movies);
//        rv.setAdapter(rvAdapter);
//    }
}