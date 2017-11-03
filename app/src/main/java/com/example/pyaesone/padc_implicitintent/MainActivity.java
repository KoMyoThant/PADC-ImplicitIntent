package com.example.pyaesone.padc_implicitintent;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // UI Elements
    private Button sharingWithShareCompatBtn, navOnMapBtn, phCallBtn, sendEmailBtn, cameraBtn,
            selectImgBtn, eventOnCalendarBtn;

    private Context context;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_SELECT_IMAGE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        // Linking UIs with control elements
        findViewsByID();

        // Button events
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
        // Sharing with ShareCompat sample
        sharingWithShareCompatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareCompatInt = ShareCompat.IntentBuilder.from((Activity) context)
                        .setText("text/plain")
                        .setText("This ShareCompat")
                        .getIntent();

                if (shareCompatInt.resolveActivity(getPackageManager()) == null) {
                    return;
                }

                startActivity(shareCompatInt);
            }
        });

        // Navigation on Map sample
        navOnMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapInt = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.7749,-122.4194"));
                mapInt.setPackage("com.google.android.apps.maps");
                if (mapInt.resolveActivity(getPackageManager()) == null) {
                    return;
                }

                startActivity(mapInt);
            }
        });

        // Phone call sample
        phCallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneCallInt = new Intent(Intent.ACTION_CALL);
                phoneCallInt.setData(Uri.parse("tel:09123456"));
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

        // Sending email sample
        sendEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendEmailInt = new Intent(Intent.ACTION_SEND);
                sendEmailInt.setData(Uri.parse("mailto:"));
                sendEmailInt.setType("text/plain");
                startActivity(sendEmailInt);
            }
        });

        // Opening camera sample
        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraInt = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (cameraInt.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(cameraInt, REQUEST_IMAGE_CAPTURE);
                }
                startActivity(cameraInt);
            }
        });

        // Image browse to select sample
        selectImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selectImgInt = new Intent();
                selectImgInt.setType("image/*");
                selectImgInt.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(selectImgInt, REQUEST_SELECT_IMAGE);
            }
        });

        // Creating event on Calendar sample
        eventOnCalendarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calendarInt = new Intent(Intent.ACTION_INSERT);
                calendarInt.setData(CalendarContract.Events.CONTENT_URI);
                calendarInt.putExtra(CalendarContract.Events.TITLE, "Implicit Intent Assignment");
                calendarInt.putExtra(CalendarContract.Events.EVENT_LOCATION, "PADC Class");
                calendarInt.putExtra(CalendarContract.Events.DESCRIPTION, "Samples of different types of Implicit Intent");
                startActivity(calendarInt);
            }
        });
    }
}
