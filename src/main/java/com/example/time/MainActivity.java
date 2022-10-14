package com.example.time;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    TimePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        datePicker= (TimePicker) findViewById(R.id.datePicker);

      //  datePicker.setIs24HourView(true);

        datePicker.setIs24HourView(true);
        textView.setText(getCurrentTime());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(getCurrentTime());
            }
        });

    }

    public String getCurrentTime(){
        String currentTime = "Current Time" +datePicker.getCurrentHour()+ ":" +datePicker.getCurrentMinute();
        return currentTime;

    }
 }