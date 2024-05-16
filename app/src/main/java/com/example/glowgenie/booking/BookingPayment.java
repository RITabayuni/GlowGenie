package com.example.glowgenie.booking;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.glowgenie.R;

public class BookingPayment extends AppCompatActivity {

    ImageView bt_back;
    RadioGroup morning_list, evening_list;
    LinearLayout dana, gopay;
    RadioButton payment1, payment2;
    RelativeLayout popup_dialog, choose_yes;
    Button book, bt_yes, bt_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_booking_payment);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bt_back = findViewById(R.id.back);
        morning_list= findViewById(R.id.schedule_m);
        evening_list= findViewById(R.id.schedule_e);
        dana= findViewById(R.id.dana);
        gopay= findViewById(R.id.gopay);
        payment1= findViewById(R.id.payment1);
        payment2= findViewById(R.id.payment2);
        book = findViewById(R.id.bt_book_2);
        popup_dialog= findViewById(R.id.popup_layout);
        choose_yes= findViewById(R.id.popup_success);
        bt_yes = findViewById(R.id.btn_yes);
        bt_no = findViewById(R.id.btn_no);


        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        morning_list.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1) {
                    evening_list.clearCheck();
                }
            }
        });
        evening_list.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1) {
                    morning_list.clearCheck();
                }
            }
        });

        View.OnClickListener paymentClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.dana) {
                    payment1.setChecked(true);
                    payment2.setChecked(false);
                } else if (v.getId() == R.id.gopay) {
                    payment1.setChecked(false);
                    payment2.setChecked(true);
                }
            }
        };

        dana.setOnClickListener(paymentClickListener);
        gopay.setOnClickListener(paymentClickListener);

        payment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Atur status RadioButton lainnya
                if (payment1.isChecked()) {
                    payment2.setChecked(false);
                }
            }
        });

        payment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Atur status RadioButton lainnya
                if (payment2.isChecked()) {
                    payment1.setChecked(false);
                }
            }
        });

        book.setOnClickListener(v -> popup_dialog.setVisibility(View.VISIBLE));

        bt_yes.setOnClickListener(v -> {
            choose_yes.setVisibility(View.VISIBLE);
            popup_dialog.setVisibility(View.GONE);
        });

        bt_no.setOnClickListener(v -> popup_dialog.setVisibility(View.GONE));

    }
}