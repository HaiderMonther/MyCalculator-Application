package com.example.myhaider;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText firstNum, secondNum;
    ListView resultListView;
    List<String> resultList;
    ArrayAdapter<String> adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNum = findViewById(R.id.first_num);
        secondNum = findViewById(R.id.second_num);
        resultListView = findViewById(R.id.List_view);

        resultList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, resultList);
        resultListView.setAdapter(adapter);

        Button minusBtn = findViewById(R.id.btn_minus);
        minusBtn.setOnClickListener(v -> {
            opreation("-");
        });
        Button plusBtn = findViewById(R.id.btn_plus);
        plusBtn.setOnClickListener(v -> {
            opreation("+");
        });
        Button mulBtn = findViewById(R.id.btn_mul);
        mulBtn.setOnClickListener(v -> {
            opreation("*");
        });
        Button divBtn = findViewById(R.id.btn_div);
        divBtn.setOnClickListener(v -> {
            opreation("/");
        });

        Button send = findViewById(R.id.send);
        send.setOnClickListener(view ->  {
                String firstNumber = resultList.get(0);
                Intent intent = new Intent(this,MainActivity2.class);
                intent.putExtra("firstResult", firstNumber);
                startActivity(intent);
        });

    }

    private void opreation(String s) {
        String first = firstNum.getText().toString();
        String second = secondNum.getText().toString();

        double number1 = Double.parseDouble(first);
        double number2 = Double.parseDouble(second);


        double result = 0;
        switch (s) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
        }

        resultList.add(first + " " + s + " " + second+" = "+ result);
        adapter.notifyDataSetChanged();

        firstNum.getText().clear();
        secondNum.getText().clear();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.about:
                openAboutActivity();
                return true;

            case R.id.course1:
                openCourse1Activity();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private void openAboutActivity() {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

    private void openCourse1Activity() {
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }
}