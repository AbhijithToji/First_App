package com.abhi.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PhoneSMSEx extends AppCompatActivity {

    EditText phonenumber,message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_smsex);
        send=findViewById(R.id.send);
        phonenumber=findViewById(R.id.phone);
        message=findViewById(R.id.msg);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = phonenumber.getText().toString();
                String msg =  message.getText().toString();
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(number,null,msg,null,null);
                    Toast.makeText(getApplicationContext(), "Message sent ",Toast.LENGTH_LONG).show();
                }catch (Exception ex){
                    Toast.makeText(getApplicationContext(),"Some files are empty ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}