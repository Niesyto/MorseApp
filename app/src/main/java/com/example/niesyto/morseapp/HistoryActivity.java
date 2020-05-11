package com.example.niesyto.morseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        final Button buttonBack = findViewById(R.id.back);
        final TextView historyTextView = findViewById(R.id.historyTextView);
        historyTextView.setMovementMethod(new ScrollingMovementMethod());


        DBHandler dbHandler = new DBHandler(this, null, null, 1);



        historyTextView.setText(dbHandler.loadHandler());



        buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}
