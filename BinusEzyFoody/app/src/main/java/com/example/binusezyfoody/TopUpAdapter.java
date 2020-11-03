package com.example.binusezyfoody;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TopUpAdapter extends RecyclerView.Adapter<TopUpAdapter.TopUpViewHolder> {

    private ArrayList<Product> productList;
    private ArrayList<Order> orderListTopUp;
    private Boolean isExist;
    private String type;

    public TopUpAdapter(ArrayList<Product> productList, ArrayList<Order> orderListTopUp, Boolean isExist) {
        this.productList = productList;
        this.orderListTopUp = orderListTopUp;
        this.isExist = isExist;
        this.type = "topup";
    }

    @NonNull
    @Override
    public TopUpAdapter.TopUpViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_product, viewGroup, false);
        return new TopUpViewHolder(view);
    }

    private Button btnTopUpProduct;
    private TextView tvProduct;
    private String name, price;

    @Override
    public void onBindViewHolder(@NonNull final TopUpAdapter.TopUpViewHolder productHolder, int i) {

        productHolder.topUpNameButton.setText(productList.get(i).getName());
        productHolder.topUpPriceTextView.setText(productList.get(i).getPrice().toString());

        btnTopUpProduct = productHolder.itemView.findViewById(R.id.btn_ProductName);
        btnTopUpProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(productHolder.itemView.getContext(), OrderActivity.class);
                Button buttonProduct = (Button) view;
                tvProduct = productHolder.itemView.findViewById(R.id.tv_ProductPrice);

                intent.putExtra("name", buttonProduct.getText().toString());
                intent.putExtra("price", tvProduct.getText().toString());
                intent.putExtra("orderListTopUp", orderListTopUp);
                intent.putExtra("type", type);

                productHolder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class TopUpViewHolder extends RecyclerView.ViewHolder{

        private TextView topUpPriceTextView;
        private Button topUpNameButton;
        public TopUpViewHolder (View view){
            super(view);
            topUpNameButton = view.findViewById(R.id.btn_ProductName);
            topUpPriceTextView = view.findViewById(R.id.tv_ProductPrice);
        }

    }
}