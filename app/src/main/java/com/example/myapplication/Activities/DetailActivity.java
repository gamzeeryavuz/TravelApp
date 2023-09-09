package com.example.myapplication.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.myapplication.Domain.PopularDomain;
import com.example.myapplication.R;

public class DetailActivity extends AppCompatActivity {

    private TextView titleTxt, locationTxt, bedTxt, quideTxt, wifiTxt, descriptionTxt, scoreTxt;
    private PopularDomain item;
    private ImageView picImg, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // XML dosyasındaki görünümleri tanımlayın
        titleTxt = findViewById(R.id.titleTxt);
        locationTxt = findViewById(R.id.locationTxt);
        bedTxt = findViewById(R.id.bedTxt);
        quideTxt = findViewById(R.id.guideTxt);
        wifiTxt = findViewById(R.id.wifiTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        scoreTxt = findViewById(R.id.scoreTxt);
        picImg = findViewById(R.id.picImg);
        backBtn = findViewById(R.id.backBtn);

        // Intent aracılığıyla gelen veriyi alın
        item = (PopularDomain) getIntent().getSerializableExtra("object");

        // Veriyi görünümlere yerleştirin
        titleTxt.setText(item.getTitle());
        scoreTxt.setText(String.valueOf(item.getScore()));
        locationTxt.setText(item.getLocation());
        bedTxt.setText(item.getBed() + " Bed");
        descriptionTxt.setText(item.getDescription());

        if (item.isGuide()) {
            quideTxt.setText("Guide");
        } else {
            quideTxt.setText("No Guide");
        }
        if (item.isWifi()) {
            wifiTxt.setText("Wifi");
        } else {
            wifiTxt.setText("No Wifi");
        }

        // Resmi yükleyin
        int drawableResId = getResources().getIdentifier(item.getPic(), "drawable", getPackageName());
        Glide.with(this).load(drawableResId).into(picImg);

        // Geri düğmesi için bir OnClickListener tanımlayın
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
