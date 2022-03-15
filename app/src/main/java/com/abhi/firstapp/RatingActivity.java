package com.abhi.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class RatingActivity extends AppCompatActivity {

    private RatingBar rBar;
    private TextView tView;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        rBar = (RatingBar) findViewById(R.id.ratingBar);
        tView = (TextView) findViewById(R.id.textView5);
        btn = (Button)findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int no_of_stars = rBar.getNumStars();
                float rating = rBar.getRating();
                tView.setText("Rating : "+rating+"/"+no_of_stars);

            }
        });
    }
}