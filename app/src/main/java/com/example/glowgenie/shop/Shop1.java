package com.example.glowgenie.shop;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.glowgenie.R;

import java.text.NumberFormat;
import java.util.Locale;

public class Shop1 extends AppCompatActivity {

    private ImageView productImage;
    private TextView productTitle, productLocation, productPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop1);

        productImage = findViewById(R.id.productbg);
        productTitle = findViewById(R.id.P_name);
//        productLocation = findViewById(R.id.Product_Loc);
        productPrice = findViewById(R.id.p_price);

        // Retrieve data from the intent
        String title = getIntent().getStringExtra("title");
//        String location = getIntent().getStringExtra("location");
        int price = getIntent().getIntExtra("price", 0);
        int imgResource = getIntent().getIntExtra("imgresource", 0);

        // Set the data to the views
        productTitle.setText(title);
//        productLocation.setText(location);
        productPrice.setText(formatPrice(price));
        productImage.setImageResource(imgResource);
    }
    private String formatPrice(int price) {
        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
        return "Rp " + format.format(price);
    }
}
