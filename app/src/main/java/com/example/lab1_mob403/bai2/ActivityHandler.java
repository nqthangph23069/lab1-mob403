package com.example.lab1_mob403.bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lab1_mob403.MainActivity;
import com.example.lab1_mob403.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ActivityHandler extends AppCompatActivity implements View.OnClickListener {
    private TextView tvBai2;
    private ImageView imgBai2;
    private Button btnBai2;
    private ProgressDialog progressDialog;
    private String url_ = "https://img3.thuthuatphanmem.vn/uploads/2019/07/07/anh-meo-de-thuong_020434654.jpg";
    private Bitmap bitmap = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        imgBai2 = findViewById(R.id.imgBai2);
        btnBai2 = findViewById(R.id.btnHandler);
        tvBai2 = findViewById(R.id.tvBai2);
        btnBai2.setOnClickListener(this);
    }

    private Handler messageHandler = new Handler(){
        public void handleMessage(Message message){
            super.handleMessage(message);
            Bundle bundle = message.getData();
            String mes = bundle.getString("message");
            tvBai2.setText(mes);
            imgBai2.setImageBitmap(bitmap);
            progressDialog.dismiss();
        }
    };
    @Override
    public void onClick(View view) {
        progressDialog = ProgressDialog.show(ActivityHandler.this, "", "Downloading ...");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                bitmap = downLoadingBitmap(url_);
                Message message = messageHandler.obtainMessage();
                Bundle bundle = new Bundle();
                String threadMes = "done";
                bundle.putString("message", threadMes);
                message.setData(bundle);
                messageHandler.sendMessage(message);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
    private Bitmap downLoadingBitmap(String link) {
        try {
            URL url2 = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url2.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap bitmap1 = BitmapFactory.decodeStream(inputStream);
            return bitmap1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}