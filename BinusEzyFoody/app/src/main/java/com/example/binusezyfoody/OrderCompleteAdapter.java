package com.example.binusezyfoody;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderCompleteAdapter extends RecyclerView.Adapter<OrderCompleteAdapter.OrderCompleteViewHolder> {

    private ArrayList<Order> productList;

    public OrderCompleteAdapter(ArrayList<Order> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public OrderCompleteAdapter.OrderCompleteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_order_complete, viewGroup, false);
        return new OrderCompleteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final OrderCompleteViewHolder productHolder, int i) {

        productHolder.orderName.setText(productList.get(i).getName());
        productHolder.orderPrice.setText(productList.get(i).getPrice().toString());
        productHolder.orderQuantity.setText(productList.get(i).getQuantity().toString());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class OrderCompleteViewHolder extends RecyclerView.ViewHolder{

        private TextView orderName, orderQuantity, orderPrice;

        public OrderCompleteViewHolder (View view){
            super(view);
            orderName = view.findViewById(R.id.orderName);
            orderQuantity = view.findViewById(R.id.orderQuantity);
            orderPrice = view.findViewById(R.id.orderPrice);

        }

    }
}