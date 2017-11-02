package com.example.pyaesone.padc_implicitintent;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button sharingWithShareCompatBtn, navOnMapBtn, phCallBtn, sendEmailBtn, cameraBtn,
            selectImgBtn, eventOnCalendarBtn;

    private Context content;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = this;

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
                Intent phoneCallInt = new Intent(Intent.ACTION_CALL);
                phoneCallInt.setData(Uri.parse("tel:09794805399"));
                if (ActivityCompat.checkSelfPermission(content, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.



                    return;
                }
                startActivity(phoneCallInt);
            }
        });

        sendEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendEmailInt = new Intent(Intent.ACTION_SEND);
                sendEmailInt.setData(Uri.parse("mailto:"));
                sendEmailInt.setType("text/plain");
                startActivity(sendEmailInt);
            }
        });

        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraInt = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (cameraInt.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(cameraInt,REQUEST_IMAGE_CAPTURE);
                }
                startActivity(cameraInt);
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
