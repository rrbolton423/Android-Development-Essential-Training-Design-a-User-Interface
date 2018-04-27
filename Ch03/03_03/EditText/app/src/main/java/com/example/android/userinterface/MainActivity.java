package com.example.android.userinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Create TAG for logging data to Logcat
    private static final String TAG = "MainActivity";

    // Define EditText components
    EditText editName, editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the reference to the EditText views
        editName = (EditText) findViewById(R.id.editName);
        editPassword = (EditText) findViewById(R.id.editPassword);
    }

    // This method executes the java code to collect the data the user has entered
    public void clickHandler(View view) {

        // Get the Text
        String name = editName.getText().toString();
        String password = editPassword.getText().toString();

        // Output the values to Logcat
        Log.i(TAG, "clickHandler: name=" + name + ", password=" + password);
    }
}
