package com.example.loginpageapi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.DnsResolver;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button getData;
    TextView t1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.textView);

        getData = (Button) findViewById(R.id.getData);
        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
                Call<Model> call = methods.getAllData();

                call.enqueue(new DnsResolver.Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        Log.e(TAG, "onResponse: code: "+response.code());

                        ArrayList<Model.data> data = response.body().getData();

//                       t1.setText(data.);
                        t1.setText(data.get(4).getEmail());

//                       for (Model.data data1 : data){
//                           data1 = null;
////                            Log.d(TAG, "onResponse: emails: "+data1.getEmail());
//                           t1.setText(data1.getEmail());
//                           Toast.makeText(getApplicationContext(),"mhvchks",Toast.LENGTH_LONG).show();
//                       }

                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Log.d(TAG, "onFailure: " +t.getMessage());
                    }
                });
            }
        });
    }
}