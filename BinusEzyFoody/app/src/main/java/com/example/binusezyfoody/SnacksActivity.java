package com.example.binusezyfoody;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class SnacksActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SnacksAdapter snacksAdapter;
    private ArrayList<Product> productArrayList;
    private Button btnMyOrder;
    private Boolean isExist;
    private ArrayList<Order> orderListSnack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);

        setData();

        isExist = getIntent().getBooleanExtra("isExist", false);

        if(isExist == false){
            orderListSnack = new ArrayList<>();
            isExist = true;
        }
        else{
            orderListSnack = (ArrayList<Order>)getIntent().getSerializableExtra("orderList");
        }

        recyclerView = findViewById(R.id.snackRecyclerView);
        snacksAdapter = new SnacksAdapter(productArrayList, orderListSnack, isExist);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(snacksAdapter);

        btnMyOrder = findViewById(R.id.btn_myOrderSnack);
        btnMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SnacksActivity.this, MyOrderActivity.class);
                intent.putExtra("orderList", orderListSnack);
                startActivity(intent);
            }
        });
    }

    public void setData(){
        productArrayList = new ArrayList<>();

        productArrayList.add(new Product("Chitato", 6000));
        productArrayList.add(new Product("Cheetos", 5000));
        productArrayList.add(new Product("Kusuka", 8000));
        productArrayList.add(new Product("Pringles", 12000));
        productArrayList.add(new Product("Mr. Potato", 11000));
        productArrayList.add(new Product("Oreo", 8000));
        productArrayList.add(new Product("Silverqueen", 7000));
        productArrayList.add(new Product("Lays", 5000));
        productArrayList.add(new Product("Doritos", 9000));
        productArrayList.add(new Product("Happy Tos", 10000));
    }
}