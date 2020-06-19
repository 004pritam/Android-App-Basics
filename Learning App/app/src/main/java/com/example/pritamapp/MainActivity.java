package com.example.pritamapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mMessageEditText;
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
    }

    public void launchSecondActivity(View view) {
    Intent intent = new Intent(this, SecondActivity.class);
    String message = mMessageEditText.getText().toString();
    intent.putExtra("Extra_message", message);
    startActivityForResult(intent, TEXT_REQUEST);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) { //1
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY); //key of reply
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    public void launch(View view) {
        switch (view.getId()){
            case R.id.button2:
                Intent i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/"));
                startActivity(i1);
                Log.i("button2", "launch: button2");
                break;
            case R.id.button3:
                Intent i2 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:121"));
                startActivity(i2);
                Log.i("button3", "launch: button3");
                break;
            case R.id.button4:
                Intent i3 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:20.3645,71.3256"));
                startActivity(i3);
                Log.i("button4", "launch: button4");
                break;

        }
    }

    public void goToSecond(View view) {
        Intent intent= new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}