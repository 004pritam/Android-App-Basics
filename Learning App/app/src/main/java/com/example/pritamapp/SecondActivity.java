package com.example.pritamapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import javax.xml.transform.Result;

public class SecondActivity extends AppCompatActivity {
    private EditText mReply;
    public static final String EXTRA_REPLY= "com.example.pritamapp.secondactivity.extra.REPLY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // Read message from main activity
        Intent intent = getIntent();
        String message = intent.getStringExtra("Extra_message");
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);
        mReply= findViewById(R.id.editText_second);
    }

    public void returnReply(View view) {
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}