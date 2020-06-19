package com.example.pritamapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class UIActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ToggleButton t1;
    CheckBox c1,c2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_i);

        //-------------------------------------------------------------------------------------
        t1=findViewById(R.id.editStatus);
        c1=findViewById(R.id.englishbox);
        c2=findViewById(R.id.hindiBox);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t1.isChecked()){
                    Toast.makeText(UIActivity.this,"you selected Married", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(UIActivity.this,"you selected Single", Toast.LENGTH_SHORT).show();
                }
            }
        });

        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(UIActivity.this,"you selected English", Toast.LENGTH_SHORT).show();
            }
        });
        c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(UIActivity.this,"you selected Hindi", Toast.LENGTH_SHORT).show();
            }
        });

        //----------------------------------------------------------------------------------
        // Create the spinner.
        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this); //**
        }
        // Create ArrayAdapter using the string array and default spinner layout.
        // takes as arguments the Activity (this) that implements the callbacks for
        // processing the results of the Spinner, the array (labels_array),
        // and the layout for each spinner item (layout.simple_spinner_item).
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.labels_array,
                android.R.layout.simple_spinner_item
                );
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }
    public void openAlert(View view) {
        final AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setTitle("Exit");
        myAlert.setMessage("Are you sure ?");
        myAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish(); // it will close the current activity
            }
        });
        myAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // dismis the alertbox
            }
        });
        myAlert.setCancelable(false); //click out side of alertbox will not close alertbox
        myAlert.show();
    }
    public void openProgress(View view) {
        ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("Downloading");
        pd.setMessage("Please wait");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setButton(ProgressDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel(); // it will cancel downloading and close progress box
            }
        });
        pd.show();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String spinner_item = parent.getItemAtPosition(position).toString();
        // Do something with spinner_item string.
        Log.i(spinner_item, "onItemSelected:"+spinner_item);
        Toast.makeText(UIActivity.this,spinner_item+" is selected",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    // Do something with spinner_item string.
    }
}