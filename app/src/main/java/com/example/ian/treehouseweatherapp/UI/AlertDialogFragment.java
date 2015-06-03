package com.example.ian.treehouseweatherapp.UI;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

import com.example.ian.treehouseweatherapp.R;

/**
 * Created by ian on 4/29/2015.
 *
*/
public class AlertDialogFragment extends DialogFragment {
   // public  Context context = getActivity();
   // public AlertDialog.Builder builder = new AlertDialog.Builder(context);

    String alertTitle;
    String alertMessage;
    String alertButtonMessage;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        //int errorCode = getArguments().getInt("INT_ERROR_CODE");
        int errorCode = getArguments().getInt("errorCode");
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        //errorState of 1 is for HTTP CallBack error
        //errorState of 2 is for unavailable network error
       if (errorCode == 1){
            alertTitle = context.getString(R.string.alert_title_http);
            alertMessage = context.getString(R.string.alert_message_http);
            alertButtonMessage = context.getString(R.string.alert_button_http);
        } else if (errorCode == 2) {
            alertTitle = context.getString(R.string.alert_title_network);
            alertMessage = context.getString(R.string.alert_message_network) +
                    context.getString(R.string.alert_title_message2);
            alertButtonMessage = context.getString(R.string.alert_button_network);
        }

        builder.setTitle(alertTitle) //(R.string.alert_title_http)))  //(alertTitle)
                .setMessage(alertMessage)//(R.string.alert_message_http))) // (alertMessage)
                        .setPositiveButton(alertButtonMessage, null);// (R.string.alert_button_http)), null); // (alertButtonMessage, null)
        AlertDialog dialog = builder.create();
        return dialog;
    }
}
        //errorState of 1 is for HTTP CallBack error
        //errorState of 2 is for unavailable network error

       /* if (errorCode == 1){
            alertTitle = context.getString(R.string.alert_title_http);
            alertMessage = context.getString(R.string.alert_message_http);
            alertButtonMessage = context.getString(R.string.alert_button_http);
        } else if (errorCode == 2) {
            alertTitle = context.getString(R.string.alert_title_network);
            alertMessage = context.getString(R.string.alert_message_network) +
                    context.getString(R.string.alert_title_message2);
            alertButtonMessage = context.getString(R.string.alert_button_network);
        }*/


// must think of way to handle multiple Dialog strings, with the same structure as this class.
    /*AlertDialogFragment (int errorState){

    }
/*
    public static final AlertDialogFragment newInstance(int errorCode){
        AlertDialogFragment fragment = new AlertDialogFragment();

        final Bundle intArg = new Bundle(1);
        intArg.putInt("INT_ERROR_CODE",errorCode);
        fragment.setArguments(intArg);

        return fragment;
    }
*/ /*
public static AlertDialog.Builder showAlertDialog(Context iContext,String errorMessage) {
    AlertDialog.Builder alertDialog = new AlertDialog.Builder(iContext).setTitle(errorMessage);
    alertDialog.setMessage(errorMessage);
    alertDialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
        }
    });
    final AlertDialog dialog = alertDialog.create();
    dialog.show(); // Show the alert dialog.
    return alertDialog;
}*/
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