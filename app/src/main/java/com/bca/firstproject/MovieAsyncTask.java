package com.bca.firstproject;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MovieAsyncTask extends AsyncTask<String, String, ArrayList<Movies>> {

    ArrayList<Movies> movieList;
    Context context;

    private onMovieLoaded movieLoaded;

    public MovieAsyncTask(
            Context ctx,
            onMovieLoaded movieLoaded) {
        this.context = ctx;
        this.movieLoaded = movieLoaded;
        movieList = new ArrayList<>();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(context, "Data Fetch Started", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected ArrayList<Movies> doInBackground(String... strings) {
        try {
            URL apiAddress = new URL(strings[0]);
            HttpURLConnection httpURLConnection =
                    (HttpURLConnection) apiAddress.openConnection();
            httpURLConnection.connect();
            InputStream dataInputStream =
                    new BufferedInputStream
                            (httpURLConnection.getInputStream());
            String response = inputStreamToString(dataInputStream);
            JSONObject data = new JSONObject(response);
            JSONObject dataObject = data.getJSONObject("data");
            JSONArray movies = dataObject.getJSONArray("movies");

            for(int i=0; i<movies.length(); i++){
                JSONObject movieObject = movies.getJSONObject(i);
                Movies movie = new Movies(
                        movieObject.getString("title"),
                        movieObject.getString("summary"),
                        movieObject.getString("large_cover_image"),
                        movieObject.getString("rating"));
                movieList.add(movie);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return movieList;
    }

    private String inputStreamToString(InputStream is) {
        String rLine = "";
        StringBuilder answer = new StringBuilder();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader rd = new BufferedReader(isr);
        try {
            while ((rLine = rd.readLine()) != null) {
                answer.append(rLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer.toString();
    }

    @Override
    protected void onPostExecute(ArrayList<Movies> movies) {
        super.onPostExecute(movies);
//        Toast.makeText(context, String.valueOf(movies.size()), Toast.LENGTH_SHORT).show();
        movieLoaded.onMovieLoaded(movies);
    }
}
