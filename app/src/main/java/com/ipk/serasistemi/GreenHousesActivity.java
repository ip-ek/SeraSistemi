package com.ipk.serasistemi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class GreenHousesActivity extends AppCompatActivity {
    LinearLayout lay_gh1, lay_gh2, lay_gh3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_houses);

        lay_gh1=findViewById(R.id.greenHouse1);
        lay_gh2=findViewById(R.id.greenHouse2);
        lay_gh3=findViewById(R.id.greenHouse3);

        final Intent intent=new Intent(getApplicationContext(),DetailedGhActivity.class);
        lay_gh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("GH_no", 1);
                startActivity(intent);
            }
        });

        lay_gh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("GH_no", 2);
                startActivity(intent);
            }
        });

        lay_gh3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("GH_no", 3);
                startActivity(intent);
            }
        });


    }
}
