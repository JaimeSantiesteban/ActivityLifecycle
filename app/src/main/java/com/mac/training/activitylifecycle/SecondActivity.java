package com.mac.training.activitylifecycle;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String MY_LOG = "FT_Second    - ";
    private EditText lblMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lblMessage = (EditText) findViewById(R.id.textView2);
        Intent i = getIntent();
        lblMessage.setText(i.getStringExtra("MTP"));

        Log.d(MY_LOG, "onCreate");
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

    public void onGoTo1(View view) {
        //Implicit intent
        Intent returnIntent = new Intent();
        returnIntent.putExtra("MTP", lblMessage.getText().toString());
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("MTP", lblMessage.getText().toString());
        setResult(Activity.RESULT_OK, returnIntent);
        // finish activity
        // always use finish if it is no the back button
        finish();

        // if you put super...
        // put it after
    }
}
