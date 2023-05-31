package com.example.myhaider;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);

        Intent intent = getIntent();
        String firstResult = intent.getStringExtra("firstResult");
        TextView resultTextView = findViewById(R.id.first_res);
        resultTextView.setText(firstResult);
    }
}
