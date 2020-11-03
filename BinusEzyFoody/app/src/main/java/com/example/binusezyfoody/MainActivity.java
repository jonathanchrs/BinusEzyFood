package com.example.binusezyfoody;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnDrink, btnFoods, btnSnacks, btnTopUp, btnMyOrder;
    private Boolean isExist = false;
    private ArrayList<Order> orderListInit = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDrink = findViewById(R.id.btn_drinks);
        btnDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DrinksActivity.class);
                intent.putExtra("isExist", isExist);
                startActivity(intent);
            }
        });

        btnFoods = findViewById(R.id.btn_foods);
        btnFoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FoodsActivity.class);
                intent.putExtra("isExist", isExist);
                startActivity(intent);
            }
        });

        btnSnacks = findViewById(R.id.btn_snacks);
        btnSnacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SnacksActivity.class);
                intent.putExtra("isExist", isExist);
                startActivity(intent);
            }
        });

        btnTopUp = findViewById(R.id.btn_topUp);
        btnTopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TopUpActivity.class);
                intent.putExtra("isExist", isExist);
                startActivity(intent);
            }
        });

        btnMyOrder = findViewById(R.id.btn_myOrderMain);
        btnMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyOrderActivity.class);
                intent.putExtra("orderList", orderListInit);
                startActivity(intent);
            }
        });
    }

}