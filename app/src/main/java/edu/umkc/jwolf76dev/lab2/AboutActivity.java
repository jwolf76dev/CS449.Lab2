package edu.umkc.jwolf76dev.lab2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView t2 = (TextView) findViewById(R.id.AppIconSource);
        t2.setMovementMethod(LinkMovementMethod.getInstance());
/*
        // Receive extra data or parameter
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_DATA);

        Context context = getApplicationContext();
        CharSequence text = message;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
*/    }
}
