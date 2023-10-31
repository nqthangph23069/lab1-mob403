package com.example.lab1_mob403.bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab1_mob403.R;

public class Activitybai4 extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private EditText editText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitybai4);
        textView = findViewById(R.id.tvBai4);
        editText = findViewById(R.id.edtBai4);
        button = findViewById(R.id.btnBai4);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnBai4){
            AsyncTaskRunner asyncTaskRunner = new AsyncTaskRunner(this, textView, editText);
            String sleeptime = editText.getText().toString();
            asyncTaskRunner.execute(sleeptime);
        }
    }
}