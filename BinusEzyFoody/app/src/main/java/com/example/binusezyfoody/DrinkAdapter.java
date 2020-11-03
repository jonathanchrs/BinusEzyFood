package com.example.binusezyfoody;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.net.Inet4Address;
import java.util.ArrayList;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder> {

    private Boolean isExist;
    private ArrayList<Product> productList;
    private ArrayList<Order> orderList;
    private String type;

    public DrinkAdapter(ArrayList<Product> productList, ArrayList<Order> orderList, Boolean isExist) {
        this.productList = productList;
        this.orderList = orderList;
        this.isExist = isExist;
        this.type = "drink";
    }

    @NonNull
    @Override
    public DrinkAdapter.DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_product, viewGroup, false);
        return new DrinkViewHolder(view);
    }

    private Button btnDrinkProduct;
    private TextView tvProduct;

    @Override
    public void onBindViewHolder(@NonNull final DrinkAdapter.DrinkViewHolder productHolder, int i) {

        productHolder.drinkNameButton.setText(productList.get(i).getName());
        productHolder.drinkPriceTextView.setText(productList.get(i).getPrice().toString());

        btnDrinkProduct = productHolder.itemView.findViewById(R.id.btn_ProductName);
        btnDrinkProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(productHolder.itemView.getContext(), OrderActivity.class);
                Button buttonProduct = (Button) view;
                tvProduct = productHolder.itemView.findViewById(R.id.tv_ProductPrice);

                intent.putExtra("name", buttonProduct.getText().toString());
                intent.putExtra("price", tvProduct.getText().toString());
                intent.putExtra("orderListDrink", orderList);
                intent.putExtra("type", type);
                productHolder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class DrinkViewHolder extends RecyclerView.ViewHolder{

        private TextView drinkPriceTextView;
        private Button drinkNameButton;

        public DrinkViewHolder (View view){
            super(view);
            drinkNameButton = view.findViewById(R.id.btn_ProductName);
            drinkPriceTextView = view.findViewById(R.id.tv_ProductPrice);
        }

    }
}
