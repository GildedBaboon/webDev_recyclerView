package com.example.webdev_recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    ImageView mainImageView;
    TextView title, description;
    Button button;
    RatingBar ratingBar;

    String data1, data2;
    int myImage;
    int myRating = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainImageView = findViewById(R.id.mainImageView);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        button = findViewById(R.id.button);
        ratingBar = findViewById(R.id.ratingBar);

        getData();
        setData();

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                int rating = (int) v;
                String message = null;

                myRating = (int) ratingBar.getRating();

                switch (rating){
                    case 1:
                        message = "Sorry to hear that";
                        break;
                    case 2:
                        message = "We can always accept suggestions!";
                        break;
                    case 3:
                        message = "That's good to hear!";
                        break;
                    case 4:
                        message = "Great! Thank you!";
                        break;
                    case 5:
                        message = "Awesome! Thank you so much!";
                        break;
                }

                Toast.makeText(SecondActivity.this, message, Toast.LENGTH_SHORT).show();

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, String.valueOf(myRating), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getData(){
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") &&
                getIntent().hasExtra("data2")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            myImage = getIntent().getIntExtra("myImage", 1);
        }

        else {
            Toast.makeText(this, "no Data.", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        title.setText(data1);
        description.setText(data2);
        mainImageView.setImageResource(myImage);
    }
}
