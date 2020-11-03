package com.example.binusezyfoody;

import android.content.Intent;
import android.service.autofill.Dataset;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.MyOrderViewHolder> {

    private ArrayList<Order> productList;

    public MyOrderAdapter(ArrayList<Order> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public MyOrderAdapter.MyOrderViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_my_order, viewGroup, false);
        return new MyOrderViewHolder(view);
    }

    private TextView tvProduct;
    private String name, price;
    private Button btnDelete;

    @Override
    public void onBindViewHolder(@NonNull final MyOrderViewHolder productHolder, int i) {

        productHolder.orderProductName.setText(productList.get(i).getName());
        productHolder.orderProductPrice.setText(productList.get(i).getPrice().toString());
        productHolder.orderProductQuantity.setText(productList.get(i).getQuantity().toString());

        btnDelete = productHolder.itemView.findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = productHolder.getAdapterPosition();
                productList.remove(position);
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class MyOrderViewHolder extends RecyclerView.ViewHolder{

        private TextView orderProductName, orderProductQuantity, orderProductPrice, tvTotalPrice;

        public MyOrderViewHolder (View view){
            super(view);
            orderProductName = view.findViewById(R.id.orderProductName);
            orderProductQuantity = view.findViewById(R.id.orderProductQuantity);
            orderProductPrice = view.findViewById(R.id.orderProductPrice);
            tvTotalPrice = view.findViewById(R.id.tv_totalPrice);

        }

    }
}