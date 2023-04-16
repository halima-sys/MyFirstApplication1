package com.example.myfirstapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextAmount=findViewById(R.id.editTextAmount);
        Button buttonCalculate=findViewById(R.id.buttonCalculate);
        TextView textViewResults=findViewById(R.id.textViewResults);
        ListView listViewResults=findViewById(R.id.listViewResults);
        List<String> data=new ArrayList<>();
        ArrayAdapter<String> stringArrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);
        listViewResults.setAdapter(stringArrayAdapter);

        /*buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount=Double.parseDouble(editTextAmount.getText().toString());
                double result=amount*3.14;
                textViewResults.setText(String.valueOf(result));
                data.add(amount+"===>"+result);
                stringArrayAdapter.notifyDataSetChanged();
                editTextAmount.setText("");
            }
        });*/
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amountString = editTextAmount.getText().toString();
                if (amountString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Type a number", Toast.LENGTH_SHORT).show();
                } else {
                    double amount = Double.parseDouble(amountString);
                    double result = amount * 11;
                    textViewResults.setText(String.valueOf(result));
                    data.add(amount + " Euro===>" + result+" DH");
                    stringArrayAdapter.notifyDataSetChanged();
                    editTextAmount.setText("");
                }
            }
        });
    }
}