package com.example.ian.treehouseweatherapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by ian on 4/29/2015.
 *
 */
public class AlertDialogFragment extends DialogFragment {
    protected  Context context = getActivity();
    //protected AlertDialog.Builder builder = new AlertDialog.Builder(context);
    String mNetworkFailureTitle = "No network detected";
    String mNetworkFailureMessage = "No network detected, or the network is not available.";
    String mButtonText = "OK";
    @Override
    // must think of way to handle multiple Dialog strings, with the same structure as this class.
    AlertDialogFragment (int errorState){
        //errorState of 1 is for HTTP CallBack error
        //errorState of 2 is for unavailable network error
        String alertTitle;
        String alertMessage;
        String alertButtonMessage;
        if (errorState == 1){
            alertTitle = context.getString(R.string.alert_title_http);
            alertMessage = context.getString(R.string.alert_message_http);
            alertButtonMessage = context.getString(R.string.alert_button_http);
        } else if (errorState == 2) {
            alertTitle = context.getString(R.string.alert_title_network);
            alertMessage = context.getString(R.string.alert_message_network) +
                    context.getString(R.string.alert_title_message2);
            alertButtonMessage = context.getString(R.string.alert_button_network);
        }
    }


    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.error_title))
                .setMessage(context.getString(R.string.error_message))
                .setPositiveButton(context.getString(R.string.error_ok_button_text), null);
        AlertDialog dialog = builder.create();
        return dialog;
    }
}
