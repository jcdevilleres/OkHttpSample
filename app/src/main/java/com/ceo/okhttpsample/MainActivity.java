package com.ceo.okhttpsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView) findViewById(R.id.textView);
//        textView.setText("Hello world!");
//        System.out.println("Print LN is here!");

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://www.sicurogroup.com")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    String serverResponse = response.body().string();
                    textView.setText(serverResponse);
                }
            }
        });

//        try {
//            Response response = client.newCall(request).execute();
//            String serverResponse = response.body().string();
//            textView.setText(serverResponse);
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}