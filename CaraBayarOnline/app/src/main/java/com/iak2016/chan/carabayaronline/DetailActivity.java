package com.iak2016.chan.carabayaronline;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    // global variable
    String[] onlineShopArr;
    String paymentMethod, onlineShop, paymentBank, ewalletProvider, paymentMinimarket;
    EditText totalPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // set variable
        View rgBank = findViewById(R.id.rg_bank);
        View rgEwallet = findViewById(R.id.rg_ewallet);
        View rgMinimarket = findViewById(R.id.rg_minimarket);

        // get payment method
        paymentMethod = getIntent().getStringExtra("paymentMethod");

        // Populate Payment Method
        TextView tvPaymentMethodSelected = (TextView) findViewById(R.id.tv_payment_method_selected);
        tvPaymentMethodSelected.setText(paymentMethod);

        // set radio group visibility
        rgMinimarket.setVisibility(View.GONE);
        rgEwallet.setVisibility(View.GONE);
        rgBank.setVisibility(View.VISIBLE);

        // set choose provider label
        TextView tvChooseProvider = (TextView) findViewById(R.id.tv_choose_provider);
        tvChooseProvider.setText(getResources().getString(R.string.choose_bank_label));

        // set radio group visibility & choose provider label based on payment method
        switch (paymentMethod) {
            case "e-wallet":
                rgEwallet.setVisibility(View.VISIBLE);
                rgBank.setVisibility(View.GONE);
                tvChooseProvider.setText(getResources().getString(R.string.choose_ewallet_provider));
                break;
            case "minimarket":
                rgMinimarket.setVisibility(View.VISIBLE);
                rgBank.setVisibility(View.GONE);
                tvChooseProvider.setText(getResources().getString(R.string.choose_minimarket_label));
                break;
        }

        // Populate online shop spinner
        onlineShopArr = getResources().getStringArray(R.array.online_shop_array);
        Spinner spChooseOnlineShop = (Spinner) findViewById(R.id.sp_choose_online_shop);

        // Create spinner ArrayAdapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.online_shop_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spChooseOnlineShop.setAdapter(adapter);

        // get selected spinner
        spChooseOnlineShop.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                int index = arg0.getSelectedItemPosition();
                onlineShop = onlineShopArr[index];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     * get selected radio button value (bank)
     *
     * @param view
     */
    public void chooseBank(View view) {
        RadioGroup rgBank = (RadioGroup) findViewById(R.id.rg_bank);

        // get selected radio button from radioGroup
        int selectedId = rgBank.getCheckedRadioButtonId();

        // find the radio button by returned id
        RadioButton radioButton = (RadioButton) findViewById(selectedId);

        paymentBank = radioButton.getText().toString();
    }

    /**
     * get selected radio button value (e-wallet)
     *
     * @param view
     */
    public void chooseEwalletProvider(View view) {
        RadioGroup rgEwallet = (RadioGroup) findViewById(R.id.rg_ewallet);

        // get selected radio button from radioGroup
        int selectedId = rgEwallet.getCheckedRadioButtonId();

        // find the radio button by returned id
        RadioButton radioButton = (RadioButton) findViewById(selectedId);

        ewalletProvider = radioButton.getText().toString();
    }

    /**
     * get selected radio button value (minimarket)
     *
     * @param view
     */
    public void chooseMinimarket(View view) {
        RadioGroup rgMinimarket = (RadioGroup) findViewById(R.id.rg_minimarket);

        // get selected radio button from radioGroup
        int selectedId = rgMinimarket.getCheckedRadioButtonId();

        // find the radio button by returned id
        RadioButton radioButton = (RadioButton) findViewById(selectedId);

        paymentMinimarket = radioButton.getText().toString();
    }

    /**
     * return content based on payment method, bank and online shop
     *
     * @param view
     */
    public void viewResult(View view) {
        // initialize
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        // set total payment
        totalPayment = (EditText) findViewById(R.id.et_total_payment);
        String totalPaymentStr = totalPayment.getText().toString();

        // grandtotal
        int totalPaymentVal = Integer.parseInt(totalPaymentStr);

        // validate total payment
        if (totalPaymentVal == 0) {
            CharSequence totalPaymentValidation = getResources().getString(R.string.validation_total_payment);
            Toast toast = Toast.makeText(context, totalPaymentValidation, duration);
            toast.show();

            return;
        }

        // go to result activity
        Intent intentResultActivity = new Intent(this, ResultActivity.class);

        // send this data
        intentResultActivity.putExtra("paymentMethod", paymentMethod);
        intentResultActivity.putExtra("onlineShop", onlineShop);
        intentResultActivity.putExtra("paymentBank", paymentBank);
        intentResultActivity.putExtra("paymentMinimarket", paymentMinimarket);
        intentResultActivity.putExtra("ewalletProvider", ewalletProvider);
        intentResultActivity.putExtra("totalPaymentVal", totalPaymentVal);

        // start intent
        startActivity(intentResultActivity);
    }
}
