package com.kimvan.hung.imageview;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainScreen extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        ImageView imageView1 = (ImageView) findViewById(R.id.image1);
        ImageView imageView2 = (ImageView) findViewById(R.id.image2);
        ImageView imageView3 = (ImageView) findViewById(R.id.image3);

        ProgressDialog dialog = new ProgressDialog(MainScreen.this);

        new ShowImageTask(imageView1,dialog).execute(
                "https://vcdn-giaitri.vnecdn.net/2017/01/26/ngoc-trinh-nhan-sac-nu-than-5r-5169-7410-1485410340.jpg"
        );

        new ShowImageTask(imageView3,dialog).execute(
                "https://s-media-cache-ak0.pinimg.com/originals/61/e7/8b/61e78b08a8dd18779132812218a9f2a8.jpg"
        );

        new ShowImageTask(imageView2,dialog).execute(
                "http://media.phunutoday.vn/files/tho_nguyen/2017/05/31/ngoc-trinh-4-1429-phunutoday.jpg"
        );

        imageView1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickImage1();
                    }
                }
        );

        imageView2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickImage2();
                    }
                }
        );

        imageView3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickImage3();
                    }
                }
        );

    }

    public void onClickImage3(){
        Intent intent = new Intent(this,Screen2.class);
        intent.putExtra("name","https://s-media-cache-ak0.pinimg.com/originals/61/e7/8b/61e78b08a8dd18779132812218a9f2a8.jpg");
        startActivity(intent);
    }

    public void onClickImage1(){
        Intent intent = new Intent(this,Screen2.class);
        Log.i(Screen2.tag,"just click");
        intent.putExtra("name","https://vcdn-giaitri.vnecdn.net/2017/01/26/ngoc-trinh-nhan-sac-nu-than-5r-5169-7410-1485410340.jpg");
        Log.i(Screen2.tag,"onCreate Screen2");
        startActivity(intent);
        Log.i(Screen2.tag,"after startIntent");
    }

    public void onClickImage2(){
        Intent intent = new Intent(this,Screen2.class);
        Log.i(Screen2.tag,"just click");
        intent.putExtra("name","http://media.phunutoday.vn/files/tho_nguyen/2017/05/31/ngoc-trinh-4-1429-phunutoday.jpg");
        startActivity(intent);
        Log.i(Screen2.tag,"afterStartIntent");
    }
}
