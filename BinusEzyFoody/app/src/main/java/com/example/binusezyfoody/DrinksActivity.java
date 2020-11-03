package com.example.binusezyfoody;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class DrinksActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DrinkAdapter drinkAdapter;
    private ArrayList<Product> productArrayList;
    private ArrayList<Order> orderListDrink;
    private Boolean isExist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        setData();

        isExist = getIntent().getBooleanExtra("isExist", false);

        if(isExist == false){
            orderListDrink = new ArrayList<>();
            isExist = true;
        }
        else{
            orderListDrink = (ArrayList<Order>)getIntent().getSerializableExtra("orderList");
        }

        recyclerView = findViewById(R.id.drinkRecyclerView);
        drinkAdapter = new DrinkAdapter(productArrayList, orderListDrink, isExist);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(drinkAdapter);
    }

    public void toMyOrderDrink(View view) {
        Intent intent = new Intent(DrinksActivity.this, MyOrderActivity.class);
        intent.putExtra("orderList", orderListDrink);
        startActivity(intent);
    }

    public void setData(){
        productArrayList = new ArrayList<>();

        productArrayList.add(new Product("Air Mineral", 20000));
        productArrayList.add(new Product("Jus Apel", 10000));
        productArrayList.add(new Product("Jus Alpukat", 15000));
        productArrayList.add(new Product("Coca Cola", 7000));
        productArrayList.add(new Product("Sprite", 8000));
        productArrayList.add(new Product("Jus Mangga", 12000));
        productArrayList.add(new Product("Es Teh Manis", 4000));
        productArrayList.add(new Product("Es Teh Tawar", 2000));
        productArrayList.add(new Product("Milkshake Coklat", 14000));
        productArrayList.add(new Product("Milkshake Strawberry", 15000));
    }
}