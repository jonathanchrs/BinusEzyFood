package com.example.binusezyfoody;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class FoodsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FoodAdapter foodAdapter;
    private ArrayList<Product> productArrayList;
    private Button btnMyOrder;
    private ArrayList<Order> orderListFood;
    private Boolean isExist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);

        setData();

        isExist = getIntent().getBooleanExtra("isExist", false);

        if(isExist == false){
            orderListFood = new ArrayList<>();
            isExist = true;
        }
        else{
            orderListFood = (ArrayList<Order>)getIntent().getSerializableExtra("orderList");
        }

        recyclerView = findViewById(R.id.foodRecyclerView);
        foodAdapter = new FoodAdapter(productArrayList, orderListFood, isExist);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(foodAdapter);

        btnMyOrder = findViewById(R.id.btn_myOrderFood);
        btnMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(FoodsActivity.this, MyOrderActivity.class);
//                startActivity(intent);
            }
        });

    }

    public void setData(){
        productArrayList = new ArrayList<>();

        productArrayList.add(new Product("Pizza", 30000));
        productArrayList.add(new Product("Mie Ayam", 12000));
        productArrayList.add(new Product("Nasi Goreng", 10000));
        productArrayList.add(new Product("Hot Dog", 9000));
        productArrayList.add(new Product("Cheeseburger", 10000));
        productArrayList.add(new Product("Bubur", 10000));
        productArrayList.add(new Product("Ayam Goreng", 7000));
        productArrayList.add(new Product("Nasi Putih", 3000));
        productArrayList.add(new Product("Soto Ayam", 12000));
        productArrayList.add(new Product("Soto Mie", 10000));
    }
}