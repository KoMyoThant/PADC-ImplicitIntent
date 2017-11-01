package com.example.pyaesone.padc_implicitintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button sharingWithShareCompatBtn, navOnMapBtn, phCallBtn, sendEmailBtn, cameraBtn,
            selectImgBtn, eventOnCalendarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewsByID();

        implicitIntentSamples();
    }

    private void findViewsByID() {
        sharingWithShareCompatBtn = findViewById(R.id.btn_sharing_with_share_compat);
        navOnMapBtn = findViewById(R.id.btn_nav_on_map);
        phCallBtn = findViewById(R.id.btn_ph_call);
        sendEmailBtn = findViewById(R.id.btn_send_email);
        cameraBtn = findViewById(R.id.btn_camera);
        selectImgBtn = findViewById(R.id.btn_select_img);
        eventOnCalendarBtn = findViewById(R.id.btn_calendar_event);
    }

    private void implicitIntentSamples() {
        sharingWithShareCompatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        navOnMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        phCallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        sendEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        selectImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        eventOnCalendarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
