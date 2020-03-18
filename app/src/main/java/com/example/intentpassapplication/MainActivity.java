package com.example.intentpassapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.makeMessage)
    EditText makeMessage;
    @BindView(R.id.messageReturnView)
    TextView messageReturnView;
    @BindView(R.id.sendButton)
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    protected void onStart() {
        super.onStart();

    }

    public void launchSecondActivity(View view){

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("SENT_MESSAGE",makeMessage.getText().toString().trim());
        messageReturnView.setText("");
        startActivityForResult(intent, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("RETURN_MESSAGE");
                messageReturnView.setText(result);
            }
        }
    }

    protected void onResume(){
        super.onResume();
        ButterKnife.bind(this);

    }


}
