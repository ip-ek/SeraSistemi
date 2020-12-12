package com.ipk.serasistemi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class GreenHousesActivity extends AppCompatActivity {
    LinearLayout lay_gh1, lay_gh2, lay_gh3;
    Switch sw_gh1, sw_gh2, sw_gh3;
    TextView heat_gh1, heat_gh2, heat_gh3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_houses);

        lay_gh1=findViewById(R.id.greenHouse1);
        lay_gh2=findViewById(R.id.greenHouse2);
        lay_gh3=findViewById(R.id.greenHouse3);

        sw_gh1=findViewById(R.id.gh1_switch);
        sw_gh2=findViewById(R.id.gh2_switch);
        sw_gh3=findViewById(R.id.gh3_switch);

        heat_gh1=findViewById(R.id.gh1_heat);
        heat_gh2=findViewById(R.id.gh2_heat);
        heat_gh3=findViewById(R.id.gh3_heat);

        //bunun bilgisi nerede tutulacaksa oradan alınmalı en başta
        sw_gh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!sw_gh1.isChecked()){
                    sw_gh1.setText(R.string.open+"    ");
                    sw_gh1.setTextColor(getResources().getColor(R.color.positive));
                }else{
                    sw_gh1.setText(R.string.close+"    ");
                    sw_gh1.setTextColor(getResources().getColor(R.color.negative));
                }
            }
        });


        sw_gh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!sw_gh2.isChecked()){
                    sw_gh2.setText(R.string.open+"    ");
                    sw_gh2.setTextColor(getResources().getColor(R.color.positive));
                }else{
                    sw_gh2.setText(R.string.close+"    ");
                    sw_gh2.setTextColor(getResources().getColor(R.color.negative));
                }
            }
        });

        sw_gh3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!sw_gh3.isChecked()){
                    sw_gh3.setText(R.string.open+"    ");
                    sw_gh3.setTextColor(getResources().getColor(R.color.positive));
                }else{
                    sw_gh3.setText(R.string.close+"    ");
                    sw_gh3.setTextColor(getResources().getColor(R.color.negative));
                }
            }
        });

        final Intent intent=new Intent(getApplicationContext(),DetailedGhActivity.class);
        lay_gh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("GH_no", 1);
                String tmp=String.valueOf(heat_gh1.getText());
                tmp=tmp.substring(0,tmp.length()-2);
                Log.d("takip", ""+tmp);
                int heat=Integer.parseInt(tmp);
                intent.putExtra("GH_temp", heat);
                startActivity(intent);
            }
        });

        lay_gh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("GH_no", 2);
                String tmp=String.valueOf(heat_gh2.getText());
                tmp=tmp.substring(0,tmp.length()-2);
                Log.d("takip", ""+tmp);
                int heat=Integer.parseInt(tmp);
                intent.putExtra("GH_temp", heat);
                startActivity(intent);
            }
        });

        lay_gh3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("GH_no", 3);
                String tmp=String.valueOf(heat_gh3.getText());
                tmp=tmp.substring(0,tmp.length()-2);
                Log.d("takip", ""+tmp);
                int heat=Integer.parseInt(tmp);
                intent.putExtra("GH_temp", heat);
                startActivity(intent);
            }
        });


    }
}
