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

public class SnacksAdapter extends RecyclerView.Adapter<SnacksAdapter.SnackViewHolder> {

    private ArrayList<Product> productList;
    private ArrayList<Order> orderListSnack;
    private Boolean isExist;
    private String type;

    public SnacksAdapter(ArrayList<Product> productList, ArrayList<Order> orderListSnack, Boolean isExist) {
        this.productList = productList;
        this.orderListSnack = orderListSnack;
        this.isExist = isExist;
        this.type = "snack";
    }

    @NonNull
    @Override
    public SnacksAdapter.SnackViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_product, viewGroup, false);
        return new SnackViewHolder(view);
    }

    private Button btnDrinkProduct;
    private TextView tvProduct;

    @Override
    public void onBindViewHolder(@NonNull final SnacksAdapter.SnackViewHolder productHolder, int i) {

        productHolder.snackNameButton.setText(productList.get(i).getName());
        productHolder.snackPriceTextView.setText(productList.get(i).getPrice().toString());

        btnDrinkProduct = productHolder.itemView.findViewById(R.id.btn_ProductName);
        btnDrinkProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(productHolder.itemView.getContext(), OrderActivity.class);
                Button buttonProduct = (Button) view;
                tvProduct = productHolder.itemView.findViewById(R.id.tv_ProductPrice);

                intent.putExtra("name", buttonProduct.getText().toString());
                intent.putExtra("price", tvProduct.getText().toString());
                intent.putExtra("orderListSnack", orderListSnack);
                intent.putExtra("type", type);

                productHolder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class SnackViewHolder extends RecyclerView.ViewHolder{

        private TextView snackPriceTextView;
        private Button snackNameButton;
        public SnackViewHolder (View view){
            super(view);
            snackNameButton = view.findViewById(R.id.btn_ProductName);
            snackPriceTextView = view.findViewById(R.id.tv_ProductPrice);
        }

    }
}