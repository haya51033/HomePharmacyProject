package com.example.android.homepharmacyproject.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.homepharmacyproject.R;

public class RegistrationActivity extends AppCompatActivity {

    TextView tv, tv1, tv2, tv3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
    }
}