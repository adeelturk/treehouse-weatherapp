package com.example.ian.treehouseweatherapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    //public static final MediaType mediaType = MediaType.parse("text/x-markdown; charset=utf-8");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String apiKey = "3b2a6c9aed11e80da43168ee303b588c";
        double latitude = 37.8267; //  45434;
        double longitude = -122.423;
        String forecastURL = "https://api.forecast.io/forecast/" + apiKey +
                "/" + latitude + "," + longitude;

        if (isNetworkAvailable()) {
            //begin using OkHttp library recipe for Synchronous Get
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(forecastURL)   //.url(requestBinURL)
                    .build();

            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Request request, IOException e) {

                }

                @Override
                public void onResponse(Response response) throws IOException {
                    try {
                        Log.v(TAG, response.body().string());
                        if (response.isSuccessful()) {

                        } else { // This is an HTTP error, bad data was sent or received.
                                // sending error code 1
                            alertUserAboutError(1);
                        }
                    } catch (IOException e) {
                        Log.e(TAG, "Exception caught: ", e);
                    }
                }
            });
        }
            else { // attempting to make existing Toast message into an Alert Dialog Message
                 //Toast.makeText(this, "Network is unavailable!",
                   //     Toast.LENGTH_LONG).show();
            // This works, but is very messy and completely blurs the lines between the AlertDialogFragment class and this activity.
            // sending error code 2
            alertUserAboutError(2);
            }

        Log.d(TAG, "Main UI code is running");
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }
        return isAvailable;
    }

    private void alertUserAboutError(int errorCode) {
        if (errorCode == 1) {
            // HTTP error
            dialogFragmentCall(errorCode);


           // showAlertDialog(this, context.getString(R.string.alert_message_http), getString(R.string.alert_title_http), getString(R.string.alert_button_http));
           // AlertDialogFragment dialog = AlertDialogFragment.newInstance(1);
        } else if (errorCode == 2) {
            
            dialogFragmentCall(errorCode);

        }
    }
    private void dialogFragmentCall (int errorCode) {
        // pass the error code to the dialog fragment using Bundle intents
        Bundle bundle = new Bundle();
        bundle.putInt("errorCode", errorCode);
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.setArguments(bundle);
        dialog.show(getFragmentManager(), "error_dialog");

    }
    /** VERY MESSY IMPLEMENTATION OF DIALOG FRAGMENT
     * Creates an alert dialog
     * @param iContext current context`
     *
    public static AlertDialog.Builder showAlertDialog(Context iContext,String errorMessage, String errorTitle, String errorButton) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(iContext).setTitle(errorTitle);
        alertDialog.setMessage(errorMessage);
        alertDialog.setPositiveButton(errorButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });
        final AlertDialog dialog = alertDialog.create();
        dialog.show(); // Show the alert dialog.
        return alertDialog;
    }*/
}




