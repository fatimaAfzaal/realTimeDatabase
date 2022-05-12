package com.example.realtimedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        Map<String,Object> map=new HashMap<>();
        map.put("ID","205274");
        map.put("Name","Fatima");
        map.put("CGPA","3.94");
        FirebaseDatabase.getInstance().getReference().child("student").updateChildren(map);
    }

    public void onc(View view) {
        Intent intent=new Intent(MainActivity.this,adddonor.class);
        startActivity(intent);
    }
}