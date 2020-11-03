package com.example.binusezyfoody;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MyOrderActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private MyOrderAdapter myOrderAdapter;
    private ArrayList<Order> productArrayList = new ArrayList<>();
    private TextView tvTotalPrice;
    private Integer totalPrice = 0;
    private Button btnPayNow;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        productArrayList = (ArrayList<Order>) getIntent().getSerializableExtra("orderList");

        recyclerView = findViewById(R.id.myOrderRecyclerView);
        myOrderAdapter = new MyOrderAdapter(productArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MyOrderActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myOrderAdapter);

        Integer totalPrice = 0;

        for(int j = 0; j < productArrayList.size(); j++){
            totalPrice += (productArrayList.get(j).getPrice() * productArrayList.get(j).getQuantity());
        }

        tvTotalPrice = findViewById(R.id.tv_totalPrice);
        tvTotalPrice.setText(totalPrice.toString());

        btnPayNow = findViewById(R.id.btn_Pay);
        btnPayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyOrderActivity.this, OrderCompleteActivity.class);
                intent.putExtra("listOrder", productArrayList);
                startActivity(intent);
            }
        });

    }

    public void setData(){
        productArrayList = new ArrayList<>();

        productArrayList.add(new Order("Air Mineral", 20000, 2));
        productArrayList.add(new Order("Cheeseburger", 10000, 3));
        productArrayList.add(new Order("Pizza", 30000, 1));
        productArrayList.add(new Order("Saldo", 1000000, 1));
        productArrayList.add(new Order("Coca Cola", 7000, 3));
        productArrayList.add(new Order("Es Teh Tawar", 2000, 2));
        productArrayList.add(new Order("Es Teh Manis", 4000, 1));
        productArrayList.add(new Order("Chitato", 6000, 9));
        productArrayList.add(new Order("Oreo", 8000, 8));
        productArrayList.add(new Order("Lays", 5000, 2));
    }
}