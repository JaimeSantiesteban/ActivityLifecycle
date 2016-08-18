package com.mac.training.activitylifecycle;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final String MY_LOG = "FT_Main    - ";
    private String myVar = "Initial Message";
    private String myVarKey = "MY_VAR";

    EditText emailText;

    EditText lblName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeLocalization();
        setContentView(R.layout.activity_main);
        Log.d(MY_LOG, "onCreate");
        emailText = (EditText) findViewById(R.id.mailName);
        lblName = (EditText) findViewById(R.id.txtName);
    }

    public void onGoTo2(View view) {
        //Implicit intent
        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("MTP", lblName.getText().toString());
        //startActivity(i);
        startActivityForResult(i, 747);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == 747) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.

                // Do something with the contact here (bigger example below)

                lblName.setText(data.getStringExtra("MTP"));
            }
        }
        Log.d(MY_LOG, "onActivityResult");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        //Save
        savedInstanceState.putString(myVarKey, myVar);
        super.onSaveInstanceState(savedInstanceState);
        Log.d(MY_LOG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        // Restore state members from saved instance
        if (savedInstanceState != null) {
            myVar = savedInstanceState.getString(myVarKey, "Nothing");
        }
        Log.d(MY_LOG, "onRestoreInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(MY_LOG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(MY_LOG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(MY_LOG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(MY_LOG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(MY_LOG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(MY_LOG, "onDestroy");
    }

    public void onSetText(View view) {
        emailText.setText(myVar);
    }

    public void onGetText(View view) {
        myVar = emailText.getText().toString();
    }

    private void changeLocalization() {
        String languageToLoad = "fr"; // your language
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }
}
