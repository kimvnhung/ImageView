package com.kimvan.hung.imageview;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class CustomImageViewActivity extends AppCompatActivity {

    CustomImageView customImageView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        customImageView = (CustomImageView) findViewById(R.id.customImageViewid);
        ProgressDialog dialog = null;
        new ShowImageTask( customImageView,dialog).execute(
              ""
        );
        setContentView(R.layout.activity_custom_image_view);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
}
