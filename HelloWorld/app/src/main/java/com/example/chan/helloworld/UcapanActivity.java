package com.example.chan.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class UcapanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucapan);

        String namaKiriman = getIntent().getStringExtra("kirimNama");
        String tahunKiriman = getIntent().getStringExtra("kirimTahun");
        int umurKiriman = getIntent().getIntExtra("kirimUmur", 0);

        TextView txtCongrats = (TextView) findViewById(R.id.txtCongrats);
        String congrats = getResources().getString(R.string.happy_birthday) + " " + namaKiriman + "\n" + getResources().getString(R.string.wish) + "\n" + namaKiriman + ", lahir tahun " + tahunKiriman + ", umurnya " + umurKiriman + " Tahun";
        txtCongrats.setText(congrats);
    }
}
