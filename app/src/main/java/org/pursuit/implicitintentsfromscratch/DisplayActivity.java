package org.pursuit.implicitintentsfromscratch;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DisplayActivity extends AppCompatActivity {
    private TextView sign;
    private TextView date;
    private ImageView image;
    private Button button;
    private final String ADDRESS = "https://www.astrology.com/horoscope/daily/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        sign = findViewById(R.id.zodiac_name_view);
        date = findViewById(R.id.zodiac_date_textview);
        image = findViewById(R.id.zodiac_image_view);
        button = findViewById(R.id.zodiac_button);

        Intent intent = getIntent();
        final String zodiacName = intent.getStringExtra("name");
        String zodiacDate = intent.getStringExtra("date");
        String imageUrl = intent.getStringExtra("image");

        sign.setText(zodiacName);
        date.setText(zodiacDate);
        Picasso.get()
                .load(imageUrl)
                .into(image);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(ADDRESS + zodiacName + ".html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }


}
