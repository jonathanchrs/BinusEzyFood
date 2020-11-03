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
import java.util.StringTokenizer;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private ArrayList<Product> productList;
    private ArrayList<Order> orderListFood;
    private Boolean isExist;
    private String type;

    public FoodAdapter(ArrayList<Product> productList, ArrayList<Order> orderListFood, Boolean isExist) {
        this.productList = productList;
        this.orderListFood = orderListFood;
        this.isExist = isExist;
        this.type = "food";
    }

    @NonNull
    @Override
    public FoodAdapter.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_product, viewGroup, false);
        return new FoodViewHolder(view);
    }

    private Button btnFoodProduct;
    private TextView tvProduct;
    private String name, price;

    @Override
    public void onBindViewHolder(@NonNull final FoodAdapter.FoodViewHolder productHolder, int i) {

        productHolder.foodNameTextView.setText(productList.get(i).getName());
        productHolder.foodPriceTextView.setText(productList.get(i).getPrice().toString());

        btnFoodProduct = productHolder.itemView.findViewById(R.id.btn_ProductName);
        btnFoodProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(productHolder.itemView.getContext(), OrderActivity.class);
                Button buttonProduct = (Button) view;
                tvProduct = productHolder.itemView.findViewById(R.id.tv_ProductPrice);

                intent.putExtra("name", buttonProduct.getText().toString());
                intent.putExtra("price", tvProduct.getText().toString());
                intent.putExtra("orderListFood", orderListFood);
                intent.putExtra("type", type);

                productHolder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{

        private TextView foodNameTextView, foodPriceTextView;

        public FoodViewHolder (View view){
            super(view);
            foodNameTextView = view.findViewById(R.id.btn_ProductName);
            foodPriceTextView = view.findViewById(R.id.tv_ProductPrice);
        }

    }
}