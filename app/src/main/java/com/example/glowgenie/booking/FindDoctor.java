package com.example.glowgenie.booking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glowgenie.MainActivity;
import com.example.glowgenie.R;
import com.example.glowgenie.community.Community1;

import java.util.ArrayList;
import java.util.List;

public class FindDoctor extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DoctorAdapter doctorAdapter;
    private List<Doctor> doctorList;
    private ImageView  bt_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_find_doctor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bt_back = findViewById(R.id.back);


        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        doctorList = new ArrayList<>();
        doctorList.add(new Doctor("Dr. Cameron Williamson", R.drawable.doc_a21, "5 years experience", "Skin & genital specialist", "Biffco Enterprises Clinic", "A skin specialist or dermatologist is a doctor who specializes in problems affecting the skin, hair and nails. Be it rashes, wrinkles, psoriasis, melanoma, or other skin problems. A dermatologist can also diagnose interactions between the skin and other parts of the body",4.9, 1043));
        doctorList.add(new Doctor("Dr. Brooklyn Simmons", R.drawable.doctor_b2, "7 years experience", "Cardiology specialist", "Acme Health Clinic", "Dr. Jason Simmons, MD is an internal medicine specialist in Brooklyn, NY and has over 16 years of experience in the medical field. He graduated from UNIVERSITY OF SOUTH CAROLINA AT AIKEN in 2007. ",4.8, 987));
        doctorList.add(new Doctor("Dr. Julia Beatrice", R.drawable.doctor_b7, "10 years experience", "Neurology specialist", "Good Health Clinic", "Dr. Julia Beatrice Cartaya, MD, is a compassionate pediatrician dedicated to providing comprehensive medical care to children of all ages in Saint louis, MO. With a focus on preventive medicine and early intervention, she offers personalized treatment plans to address a wide range of pediatric health concerns and promote healthy development. ",4.7, 1220));
        doctorList.add(new Doctor("Dr. Jenny Wilson", R.drawable.doctor_b8, "8 years experience", "Pediatrics specialist", "Care Clinic", "Jenny Wilson, M.D., is a pediatric neurologist providing care for children at Oregon Health & Science University and Shriners Children's Portland.She considers treatments such as medications, botulinum toxin injections, the intrathecal baclofen pump, selective dorsal rhizotomy and deep brain stimulation. ", 4.8, 1100));
        doctorList.add(new Doctor("Dr. Irvin Gabourel", R.drawable.doctor_b5, "6 years experience", "Orthopedic specialist", "Joint Care Clinic", "Dr. Irvin Anthony Gabourel obtained his Medical degree from San Carlos University in Guatemala City in 1991. Dr. Gabourel went on to the private sector as a Gastroenterologist, opening the first privately own facility offering both advanced endoscopic procedures and minimally invasive surgeries with state of the art equipment and technology.",4.6, 980));
        doctorList.add(new Doctor("Dr. Gregory D'Angelo", R.drawable.doctor_b6, "12 years experience", "Dentist", "Smile Dental Clinic", "Orthopedic surgeon Dr. D'Angelo is a senior partner in Bluegrass Orthopaedics with specialty training in adult joint reconstruction of knees and hips. He has also been fellowship trained in arthroscopic (minimally invasive) joint surgery as well. He has performed thousands of knee and hip surgery procedures.", 4.9, 1500));
        doctorList.add(new Doctor("Dr. Gregory D'Angelo", R.drawable.doctor_b6, "12 years experience", "Dentist", "Smile Dental Clinic", "Orthopedic surgeon Dr. D'Angelo is a senior partner in Bluegrass Orthopaedics with specialty training in adult joint reconstruction of knees and hips. He has also been fellowship trained in arthroscopic (minimally invasive) joint surgery as well. He has performed thousands of knee and hip surgery procedures.", 4.9, 1500));

        doctorAdapter = new DoctorAdapter(this, doctorList);
        recyclerView.setAdapter(doctorAdapter);

        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindDoctor.this, MainActivity.class);
                startActivity(intent);
//                finish();
            }
        });

    }
}