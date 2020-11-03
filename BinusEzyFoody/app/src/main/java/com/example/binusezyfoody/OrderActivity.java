package com.example.binusezyfoody;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    private TextView name, price;
    private EditText quantity;
    private String productName, productPrice;
    private ArrayList<Order> orderList = new ArrayList<>();
    private Boolean isExist;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        name = findViewById(R.id.productName);
        price = findViewById(R.id.productPrice);


        type = getIntent().getStringExtra("type");

        if(type.equals("food")){
            orderList = (ArrayList<Order>) getIntent().getSerializableExtra("orderListFood");
        }
        else if(type.equals("drink")){
            orderList = (ArrayList<Order>) getIntent().getSerializableExtra("orderListDrink");
        }
        else if(type.equals("snack")){
            orderList = (ArrayList<Order>) getIntent().getSerializableExtra("orderListSnack");
        }
        else if(type.equals("topup")){
            orderList = (ArrayList<Order>) getIntent().getSerializableExtra("orderListTopUp");
        }

        productName = getIntent().getStringExtra("name");
        productPrice = getIntent().getStringExtra("price");

        name.setText(productName);
        price.setText(productPrice);
    }


    public void orderMore(View view) {
        quantity = findViewById(R.id.quantity);

        Intent intent = new Intent();

        if(type.equals("food")){
            intent = new Intent(OrderActivity.this, FoodsActivity.class);
        }
        else if(type.equals("drink")){
            intent = new Intent(OrderActivity.this, DrinksActivity.class);
        }
        else if(type.equals("snack")){
            intent = new Intent(OrderActivity.this, SnacksActivity.class);
        }
        else if(type.equals("topup")){
            intent = new Intent(OrderActivity.this, TopUpActivity.class);
        }

        Order order = new Order(name.getText().toString(), Integer.parseInt(price.getText().toString()), Integer.parseInt(quantity.getText().toString()));
        orderList.add(order);
        intent.putExtra("orderList", orderList);
        isExist = true;
        intent.putExtra("isExist", isExist);
        startActivity(intent);
    }

    public void toMyOrder(View view) {
        Intent intent = new Intent(OrderActivity.this, MyOrderActivity.class);
        intent.putExtra("orderList", orderList);
        startActivity(intent);
    }
}