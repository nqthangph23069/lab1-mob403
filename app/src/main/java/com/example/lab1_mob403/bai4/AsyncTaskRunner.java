package com.example.lab1_mob403.bai4;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

public class AsyncTaskRunner extends AsyncTask<String, String, String> {
    private String resp;
    ProgressDialog progressDialog;
    TextView textView;
    EditText editText;
    Context context;

    public AsyncTaskRunner(Context context, TextView textView, EditText editText) {
        this.textView = textView;
        this.editText = editText;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context, "ProgressDialog", "Wait for " +
                editText.getText().toString() + " seconds");
    }

    @Override
    protected String doInBackground(String... strings) {
        publishProgress("sleeping...");
        try{
            int time = Integer.parseInt(strings[0]) * 1000;
            Thread.sleep(time);
            resp = "sleep for " + strings[0] + " seconds";
        }catch (Exception e){
            e.printStackTrace();
            resp = e.getMessage();
        }
        return resp;

    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        textView.setText(result);
    }
}
