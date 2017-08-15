package com.kimvan.hung.imageview;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by h on 27/07/2017.
 */

public class ShowImageTask extends AsyncTask<String,Integer,Bitmap> {
    ImageView imageView;
    ProgressDialog dialog;

    public ShowImageTask(ImageView imageView,ProgressDialog dialog){
        this.imageView = imageView;
        this.dialog=dialog;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = ProgressDialog.show(imageView.getContext(),"Loading","0%");
    }

    @Override
    protected Bitmap doInBackground(String... urls) {
        Bitmap mIcon11 = null;
        try {
            URL is = new URL(urls[0]);
            HttpURLConnection connection = (HttpURLConnection) is.openConnection();
            InputStream inputStream = connection.getInputStream();
            mIcon11 = BitmapFactory.decodeStream(inputStream);
            for(int i=0;i<100;i++){
                if (1>0){
                    synchronized (this){
                        try {
                            wait(1);
                        }catch (Exception e){

                        }
                    }
                }
                publishProgress(i);
                if (isCancelled()) break;
            }
            if (mIcon11!=null)
                return mIcon11;
        }catch (Exception e){

        }
        return mIcon11;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        showProgressDialog(String.valueOf(values[0])+"%");
    }

    protected void onPostExecute(Bitmap result) {
        imageView.setImageBitmap(result);
        if (dialog!=null){

            dialog.dismiss();
        }
    }
    private void showProgressDialog(CharSequence msg){
        if (dialog==null){
            dialog = new ProgressDialog(imageView.getContext());
            dialog.setIndeterminate(true);

        }
        this.dialog.setMessage(msg);
        this.dialog.show();
    }
}
