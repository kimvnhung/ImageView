package com.kimvan.hung.imageview;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;


public class Screen2 extends AppCompatActivity {

    ImageView imageView;
    public static final String tag ="wrong";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        imageView = (ImageView) findViewById(R.id.customImageView);
        Bundle info = getIntent().getExtras();
        ProgressDialog dialog = new ProgressDialog(Screen2.this);
        new ShowImageTask(imageView,dialog).execute(
                info.getString("name")
        );
    }
}
