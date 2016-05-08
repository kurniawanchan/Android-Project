package com.iak2016.chan.carabayaronline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    // global variable
    String paymentMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * set payment method and send to detail activity
     *
     * @param view
     */
    public void choosePaymentMethod(View view) {
        switch (view.getId()) {
            case (R.id.img_btn_ebanking):
                paymentMethod = "e-banking";
                break;
            case (R.id.img_btn_atm):
                paymentMethod = "atm";
                break;
            case (R.id.img_btn_ewallet):
                paymentMethod = "e-wallet";
                break;
            case (R.id.img_btn_klikpay):
                paymentMethod = "klikpay";
                break;
            case (R.id.img_btn_minimarket):
                paymentMethod = "minimarket";
                break;
        }

        // go to detail activity
        Intent intentDetailActivity = new Intent(this, DetailActivity.class);

        // send this data
        intentDetailActivity.putExtra("paymentMethod", paymentMethod);

        // start intent
        startActivity(intentDetailActivity);
    }

    /**
     * Display view about the developer information
     *
     * @param view
     */
    public void whoIsTheAwesomeDeveloper(View view) {
        // go to developer activity
        Intent intentDeveloperActivity = new Intent(this, DeveloperActivity.class);

        // start intent
        startActivity(intentDeveloperActivity);
    }
}
