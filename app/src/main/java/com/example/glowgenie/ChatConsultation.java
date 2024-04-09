package com.example.glowgenie;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChatConsultation extends AppCompatActivity {
    ImageView iconBack;
    Button btnEnd, btnYes, btnNo;
    TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chat_consultation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        iconBack = findViewById(R.id.back);
        iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(ChatConsultation.this, Appointment3.class);
                startActivity(I);
            }
        });

        btnEnd = findViewById(R.id.end_chat);
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });
    }

    public void showAlertDialog (){
        message = new TextView(ChatConsultation.this);
        message.setText("Are you sure to end this appointment?");
        Typeface font = ResourcesCompat.getFont(ChatConsultation.this, R.font.poppins_regular);
        message.setTypeface(font);
        message.setTextSize(20);
        message.setTextColor(Color.parseColor("#7B1FA2"));
        message.setGravity(Gravity.CENTER);
        // Memberikan margin ke TextView
        LinearLayout.LayoutParams layoutParamsTV = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        int tvTopInDp = 60;
        int tvTopInPixel = (int) (tvTopInDp  * getResources().getDisplayMetrics().density);
        int tvBottomInDp = 30;
        int tvBottomInPixel = (int) (tvBottomInDp  * getResources().getDisplayMetrics().density);

        int tvStartInDp = 20;
        int tvStartInPixel = (int) (tvStartInDp  * getResources().getDisplayMetrics().density);
        int tvEndInDp = 20;
        int tvEndInPixel = (int) (tvEndInDp  * getResources().getDisplayMetrics().density);
        layoutParamsTV.setMargins(tvStartInPixel, tvTopInPixel, tvEndInPixel, tvBottomInPixel);

        btnYes = new Button(ChatConsultation.this);
        btnYes.setText("Yes");
        Typeface fontButton = ResourcesCompat.getFont(ChatConsultation.this, R.font.poppins_medium);
        btnYes.setTypeface(fontButton);
        btnYes.setTextColor(Color.parseColor("#FFFFFF"));
        btnYes.setTextSize(16);
        btnYes.setAllCaps(false);
        // Memberikan margin ke Button Yes
        LinearLayout.LayoutParams layoutParamsBtnYes = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        int btnYesTopInDp = 0;
        int btnYesTopInPixel = (int) (btnYesTopInDp  * getResources().getDisplayMetrics().density);
        int btnYesBottomInDp = 15;
        int btnYesBottomInPixel = (int) (btnYesBottomInDp  * getResources().getDisplayMetrics().density);

        int btnYesStartInDp = 20;
        int btnYesStartInPixel = (int) (btnYesStartInDp  * getResources().getDisplayMetrics().density);
        int btnYesEndInDp = 20;
        int btnYesEndInPixel = (int) (btnYesEndInDp  * getResources().getDisplayMetrics().density);
        layoutParamsBtnYes.setMargins(btnYesStartInPixel, btnYesTopInPixel, btnYesEndInPixel, btnYesBottomInPixel);

        btnNo = new Button(ChatConsultation.this);
        btnNo.setText("No");
        btnNo.setTypeface(fontButton);
        btnNo.setTextColor(Color.parseColor("#FFFFFF"));
        btnNo.setTextSize(16);
        btnNo.setAllCaps(false);
        // Memberikan margin ke Button No
        LinearLayout.LayoutParams layoutParamsBtnNo = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        int btnNoTopInDp = 0;
        int btnNoTopInPixel = (int) (btnNoTopInDp  * getResources().getDisplayMetrics().density);
        int btnNoBottomInDp = 60;
        int btnNoBottomInPixel = (int) (btnNoBottomInDp  * getResources().getDisplayMetrics().density);

        int btnNoStartInDp = 20;
        int btnNoStartInPixel = (int) (btnNoStartInDp  * getResources().getDisplayMetrics().density);
        int btnNoEndInDp = 20;
        int btnNoEndInPixel = (int) (btnNoEndInDp  * getResources().getDisplayMetrics().density);
        layoutParamsBtnNo.setMargins(btnNoStartInPixel, btnNoTopInPixel, btnNoEndInPixel, btnNoBottomInPixel);

        message.setLayoutParams(layoutParamsTV);
        btnYes.setLayoutParams(layoutParamsBtnYes);
        btnNo.setLayoutParams(layoutParamsBtnNo);

        int btnRadiusInDp = 25;
        int btnRadiusInPixel = (int) (btnRadiusInDp * getResources().getDisplayMetrics().density);

        // Membuat gradient drawable untuk mengatur style button
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#A137CD"));
        gradientDrawable.setCornerRadius(btnRadiusInPixel);

        // Set drawable background ke Button "Yes" dan "No"
        btnYes.setBackground(gradientDrawable);
        btnNo.setBackground(gradientDrawable);

        // Mengatur isi kotak Dialog dengan LinearLayout
        LinearLayout linearLayout = new LinearLayout(ChatConsultation.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.addView(message);
        linearLayout.addView(btnYes);
        linearLayout.addView(btnNo);

        AlertDialog.Builder builder = new AlertDialog.Builder(ChatConsultation.this);
        builder.setView(linearLayout);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        // Mengatur layout kotak dialog
        alertDialog.getWindow().setLayout(750, 850);
        alertDialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_popup);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(ChatConsultation.this, Rating.class);
                startActivity(I);
                alertDialog.dismiss();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }
}