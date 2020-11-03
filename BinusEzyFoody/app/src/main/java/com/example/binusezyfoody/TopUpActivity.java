package com.example.binusezyfoody;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class TopUpActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TopUpAdapter topUpAdapter;
    private ArrayList<Product> productArrayList;
    private Button btnMyOrder;
    private Boolean isExist;
    private ArrayList<Order> orderListTopUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        setData();

        isExist = getIntent().getBooleanExtra("isExist", false);

        if(isExist == false){
            orderListTopUp = new ArrayList<>();
            isExist = true;
        }
        else{
            orderListTopUp = (ArrayList<Order>) getIntent().getSerializableExtra("orderList");
        }

        recyclerView = findViewById(R.id.topUpRecyclerView);
        topUpAdapter = new TopUpAdapter(productArrayList, orderListTopUp, isExist);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(topUpAdapter);

        btnMyOrder = findViewById(R.id.btn_myOrderTopUp);
        btnMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TopUpActivity.this, MyOrderActivity.class);
                intent.putExtra("orderList", orderListTopUp);
                startActivity(intent);
            }
        });
    }

    public void setData(){
        productArrayList = new ArrayList<>();

        productArrayList.add(new Product("Saldo", 5000));
        productArrayList.add(new Product("Saldo", 10000));
        productArrayList.add(new Product("Saldo", 20000));
        productArrayList.add(new Product("Saldo", 25000));
        productArrayList.add(new Product("Saldo", 50000));
        productArrayList.add(new Product("Saldo", 100000));
        productArrayList.add(new Product("Saldo", 150000));
        productArrayList.add(new Product("Saldo", 200000));
        productArrayList.add(new Product("Saldo", 500000));
        productArrayList.add(new Product("Saldo", 1000000));
    }
}