package com.example.realtimedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class adddonor extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String value;
    EditText name,city,contact;
    TextView bg;
    Spinner spinnercity;
    String[] cityname={"A+","A-","B+","B-","O+","O-","AB+","AB-"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddonor);

        getSupportActionBar().hide();
        spinnercity=(Spinner)findViewById(R.id.spinner);
        spinnercity.setOnItemSelectedListener(this);
        ArrayAdapter adapterspinner=new ArrayAdapter(this,android.R.layout.simple_spinner_item,cityname);
        adapterspinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnercity.setAdapter(adapterspinner);


        name=(EditText) findViewById(R.id.editTextTextPersonName);
        city=(EditText) findViewById(R.id.editTextTextPersonName2);
        contact=(EditText) findViewById(R.id.editTextPhone);
        bg=(TextView) findViewById(R.id.textView4);

    }

    public void onc(View view) {
        HashMap<String, Object> m = new HashMap<String , Object>();
        m. put ("Name" , name.getText ().toString());
        m.put ("City" ,city.getText ().toString());
        m.put ("Contact" ,contact.getText ().toString());
        m.put ("blood group",value);
        FirebaseDatabase.getInstance().getReference().child("User").push().setValue(m);
        Toast.makeText(this, "Record added successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        value=cityname[i];

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}