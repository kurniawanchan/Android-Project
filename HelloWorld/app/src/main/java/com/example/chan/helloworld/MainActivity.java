package com.example.chan.helloworld;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView birthdayWord;
    EditText nameBirthday, birthYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        birthdayWord = (TextView) findViewById(R.id.txtCongrats);
        nameBirthday = (EditText) findViewById(R.id.etxtNameBirthday);
        birthYear = (EditText) findViewById(R.id.etxtBirthYear);
    }

    public void sayBirthday(View view) {
        String name = nameBirthday.getText().toString();
        String yearBirth = birthYear.getText().toString();
        if (name.isEmpty() || yearBirth.isEmpty()) {
            // Toast
            Context context = getApplicationContext();
            String text = "Silahkan sempurnakan data!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else {
            int intYear = Integer.parseInt(yearBirth);

            int age = 2016 - intYear;

            //String happyBirthday = getResources().getString(R.string.happy_birthday) + " " + name + "\n" + getResources().getString(R.string.wish) + "\n" + name + ", lahir tahun " + yearBirth + ", umurnya " + age;
            //birthdayWord.setText(happyBirthday);
/*
            // Toast
            Context context = getApplicationContext();
            String text = birthdayWord.getText().toString();
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();*/

            Intent intentUcapanActivity = new Intent(this, UcapanActivity.class);

            intentUcapanActivity.putExtra("kirimNama", name);
            intentUcapanActivity.putExtra("kirimTahun", yearBirth);
            intentUcapanActivity.putExtra("kirimUmur", age);
            startActivity(intentUcapanActivity);
        }
    }
}
