package com.example.android.userinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    EditText editName, editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = (EditText) findViewById(R.id.editName);
        editPassword = (EditText) findViewById(R.id.editPassword);
    }

    public void clickHandler(View view) {

        String name = editName.getText().toString();
        String password = editPassword.getText().toString();

        Log.i(TAG, "clickHandler: name=" + name + ", password=" + password);

        // Create a String message with the submitted data
        String message = String.format("name=%s, password=%s", name, password);

        // Create a Toast message, displaying the String message containing the data
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
