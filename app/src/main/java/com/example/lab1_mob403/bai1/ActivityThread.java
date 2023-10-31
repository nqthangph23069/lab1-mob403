package com.example.lab1_mob403.bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab1_mob403.R;

import java.io.IOException;
import java.net.URL;

public class ActivityThread extends AppCompatActivity implements View.OnClickListener {
    private ImageView img;
    private Button btn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        img = findViewById(R.id.imgBai1);
        btn = findViewById(R.id.btnThread);
        tv = findViewById(R.id.tvbai1);
        btn.setOnClickListener(this);
    }
    private Bitmap loadImageFromNetwork(String link) {
        URL url;
        Bitmap bitmap = null;

        try {
            url = new URL(link);
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
    @Override
    public void onClick(View view) {
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = loadImageFromNetwork("https://th.bing.com/th/id/R.f00b06eeff077ab74795ba10b598a6a6?rik=DTxdRL3EvuvbxA&riu=http%3a%2f%2fpictures.topspeed.com%2fIMG%2fjpg%2f201509%2fbmw-s-future-quad-tu.jpg&ehk=7LwcI9%2bOD8llqDZAp8a8byFMjPCWmO4SpOCgQdVfiB4%3d&risl=&pid=ImgRaw&r=0");
                img.post(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText("Load ảnh thành công");
                        img.setImageBitmap(bitmap);
                    }
                });
            }
        });
        thread.start();
    }

}