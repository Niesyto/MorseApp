package com.example.niesyto.morseapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String translated;
    String toTrans;
    String mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView TextView = (TextView) findViewById(R.id.toTranslate);
        final MorseCode translator = new MorseCode();
        final AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        final Button buttonTo = findViewById(R.id.to);
        final Button buttonFrom = findViewById(R.id.from);
        final Button buttonHistory = findViewById(R.id.history);



        dlgAlert.setMessage("Nothing yet");
        dlgAlert.setTitle("Your sentence is:");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);


        buttonHistory.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,HistoryActivity.class));
            }
        });

        buttonTo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               translated=translator.translateToMorse(TextView.getText().toString().toCharArray());
               mode="to";
               toTrans=TextView.getText().toString();

                dlgAlert.setMessage(translated);
                dlgAlert.create().show();

                insertToDB(v,translated,toTrans,mode);

            }
        });

        buttonFrom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                translated=translator.translateFromMorse(TextView.getText().toString().toCharArray());
                mode="from";
                toTrans=TextView.getText().toString();

                dlgAlert.setMessage(translated);
                dlgAlert.create().show();

                insertToDB(v,translated,toTrans,mode);
            }
        });
    }


    public void insertToDB(View view, String translated, String toTrans, String mode){
        DBHandler dbHandler = new DBHandler(this, null, null, 1);

        Translation translation = new Translation(toTrans,translated,mode);
        dbHandler.addHandler(translation);
    }

}
