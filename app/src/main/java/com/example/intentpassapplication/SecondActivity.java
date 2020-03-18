package com.example.intentpassapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {
    @BindView(R.id.makeMessage2)
    EditText makeMessage2;
    @BindView(R.id.messageReturnView2)
    TextView messageReturnView2;
    @BindView(R.id.sendButton2)
    Button sendButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

        Intent recievedIntent = getIntent();
        String message =recievedIntent.getStringExtra("SENT_MESSAGE");
        messageReturnView2.setText(message);
    }

    public void returnToPreviousActivity(View view){

        String returnMessage = makeMessage2.getText().toString().trim();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("RETURN_MESSAGE",returnMessage );
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }

}
