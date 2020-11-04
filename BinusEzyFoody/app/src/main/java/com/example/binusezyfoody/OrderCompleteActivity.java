package com.example.binusezyfoody;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderCompleteActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private OrderCompleteAdapter orderCompleteAdapter;
    private ArrayList<Order> orderArrayList;
    private TextView tvTotalPrice;
    private Button btnMainMenu;
    private Boolean isExist = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        orderArrayList = (ArrayList<Order>)getIntent().getSerializableExtra("listOrder");

        recyclerView = findViewById(R.id.orderCompleteRecycleView);
        orderCompleteAdapter = new OrderCompleteAdapter(orderArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(OrderCompleteActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(orderCompleteAdapter);

        Integer totalPrice = 0;

        for(int j = 0; j < orderArrayList.size(); j++){
            totalPrice += (orderArrayList.get(j).getPrice() * orderArrayList.get(j).getQuantity());
        }

        tvTotalPrice = findViewById(R.id.tv_totalPrice);
        tvTotalPrice.setText(totalPrice.toString());

        btnMainMenu = findViewById(R.id.btn_MainMenu);
        btnMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderCompleteActivity.this, MainActivity.class);
                intent.putExtra("isExist", isExist);
                startActivity(intent);
            }
        });
    }
}