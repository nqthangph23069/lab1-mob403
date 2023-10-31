package com.example.lab1_mob403.bai3;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab1_mob403.R;

public class ActivityAsyncTask extends AppCompatActivity implements View.OnClickListener, Listener {
    private TextView textView;
    private Button button;
    private ImageView imageView;
    public static final String image_url = "https://toigingiuvedep.vn/wp-content/uploads/2021/08/hinh-anh-chu-cho-cuoi-nhe-rang.jpg";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        textView = findViewById(R.id.tvBai3);
        button = findViewById(R.id.btnAsyncTask);
        imageView = findViewById(R.id.imgBai3);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnAsyncTask) {
            new loadImageTask(this, this).execute(image_url);
        }

    }

    @Override
    public void onImageLoaded(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
        textView.setText("Load is done");
    }

    @Override
    public void onError() {
        textView.setText("load is fail");
    }
}
