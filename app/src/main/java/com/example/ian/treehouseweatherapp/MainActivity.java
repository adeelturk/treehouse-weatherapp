package com.example.ian.treehouseweatherapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;


public class MainActivity extends ActionBarActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String apiKey = "3b2a6c9aed11e80da43168ee303b588c";
        double latitude = 37.8267;
        double longitude = -122.423;
        String forecastURL = "https://api.forecast.io/forecast/" + apiKey +
                "/" + latitude + "," + longitude;
        String requestBinURL = "http://requestb.in/1cr03dh1";

        // begin using OkHttp library recipe for Synchronous Get
       /* OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
               /* .url(forecastURL)   .url(requestBinURL)
                .build(); */

        /*Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

                try {
                    if (response.isSuccessful()) {
                        Log.v(TAG, response.body().string());
                    }
                } catch (IOException e) {
                    Log.e(TAG, "Exception caught: ", e);
                }

            }
        });*/
        OkHttpClient client = new OkHttpClient();
        String dataToPost = "This is the string that will be posted!";
        MediaType mediaType = MediaType.parse(dataToPost);
        RequestBody requestBody = RequestBody.create(mediaType, dataToPost);
        Request request = new Request.Builder().url(requestBinURL).post(requestBody).build();
    }
}
