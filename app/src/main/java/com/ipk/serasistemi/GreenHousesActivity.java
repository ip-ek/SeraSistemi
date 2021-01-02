package com.ipk.serasistemi;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class GreenHousesActivity extends AppCompatActivity {

    List<GhInfo> GhInfoList;
    boolean refreshBool;
    LinearLayout lay_gh1, lay_gh2, lay_gh3;
    Switch sw_gh1, sw_gh2, sw_gh3;
    TextView heat_gh1, heat_gh2, heat_gh3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context =getApplicationContext();
        refreshBool=true;

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

        updateValues(context);


        //bunun bilgisi nerede tutulacaksa oradan alınmalı en başta
        //TODO: swich işlemleri sonrası servera post edilmeli ve değerin 0 olması istenmeli
        sw_gh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sw_gh1.isChecked()){
                    sw_gh1.setText(context.getString(R.string.open)+"    ");
                    sw_gh1.setTextColor(getResources().getColor(R.color.positive));
                }else{
                    sw_gh1.setText(context.getString(R.string.close)+"    ");
                    sw_gh1.setTextColor(getResources().getColor(R.color.negative));
                }
            }
        });


        sw_gh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sw_gh2.isChecked()){
                    sw_gh2.setText(context.getString(R.string.open)+"    ");
                    sw_gh2.setTextColor(getResources().getColor(R.color.positive));
                }else{
                    sw_gh2.setText(context.getString(R.string.close)+"    ");
                    sw_gh2.setTextColor(getResources().getColor(R.color.negative));
                }
            }
        });

        sw_gh3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sw_gh3.isChecked()){
                    sw_gh3.setText(context.getString(R.string.open)+"    ");
                    sw_gh3.setTextColor(getResources().getColor(R.color.positive));
                }else{
                    sw_gh3.setText(context.getString(R.string.close)+"    ");
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
                intent.putExtra("GH_target", GhInfoList.get(0).getTargetHeat());
                startActivity(intent);
                refreshBool=false;
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
                intent.putExtra("GH_target", GhInfoList.get(1).getTargetHeat());
                startActivity(intent);
                refreshBool=false;
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
                intent.putExtra("GH_target", GhInfoList.get(2).getTargetHeat());
                startActivity(intent);
                refreshBool=false;
            }
        });


    } //oncreate

    private void updateValues(final Context context){
        Call<List<GhInfo>> callAll=RetrofitConnection.getApiService().getAll();
        callAll.enqueue(new Callback<List<GhInfo>>() {
            @Override
            public void onResponse(Call<List<GhInfo>> call, Response<List<GhInfo>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Veri çekilemedi!\nHata: "+response.code(),Toast.LENGTH_LONG).show();
                } else{
                    GhInfoList = response.body();

                    /*for(GhInfo each:GhInfoList){
                        Log.d("takip","."+each.getCurrentHeat());
                    }*/
                    Log.d("takip", "hi: "+GhInfoList.get(0).getCurrentHeat());

                    heat_gh1.setText(GhInfoList.get(0).getCurrentHeat()+"^C");
                    heat_gh2.setText(GhInfoList.get(1).getCurrentHeat()+"^C");
                    heat_gh3.setText(GhInfoList.get(2).getCurrentHeat()+"^C");

                    if(GhInfoList.get(0).getStatus()==1){
                        sw_gh1.setChecked(true);
                        sw_gh1.setText(context.getString(R.string.open)+"    ");
                        sw_gh1.setTextColor(getResources().getColor(R.color.positive));
                    }else{
                        sw_gh1.setChecked(false);
                        sw_gh1.setText(context.getString(R.string.close)+"    ");
                        sw_gh1.setTextColor(getResources().getColor(R.color.negative));
                    }
                    if(GhInfoList.get(1).getStatus()==1){
                        sw_gh2.setChecked(true);
                        sw_gh2.setText(context.getString(R.string.open)+"    ");
                        sw_gh2.setTextColor(getResources().getColor(R.color.positive));
                    }else{
                        sw_gh2.setChecked(false);
                        sw_gh2.setText(context.getString(R.string.close)+"    ");
                        sw_gh2.setTextColor(getResources().getColor(R.color.negative));
                    }
                    if(GhInfoList.get(2).getStatus()==1){
                        sw_gh3.setChecked(true);
                        sw_gh3.setText(context.getString(R.string.open)+"    ");
                        sw_gh3.setTextColor(getResources().getColor(R.color.positive));
                    }else{
                        sw_gh3.setChecked(false);
                        sw_gh3.setText(context.getString(R.string.close)+"    ");
                        sw_gh3.setTextColor(getResources().getColor(R.color.negative));
                    }


                }
            }

            @Override
            public void onFailure(Call<List<GhInfo>> call, Throwable t) {
                //hatalı olursa ne olacak
                Toast.makeText(getApplicationContext(),"Bağlantı hatası!\n"+ t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        Toast.makeText(context, "Veriler yenilendi.", Toast.LENGTH_SHORT).show();
        if(refreshBool){
            refresh(10000);
        }

    } //update values

    private void refresh(int milliseconds){
        final Handler handler=new Handler();
        final Runnable runnable=new Runnable() {
            @Override
            public void run() {
                updateValues(getApplicationContext());
            }
        };
        handler.postDelayed(runnable, milliseconds);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //ekrandan çıkıp geri gelindiğinde refreshin tekrar otomatik olmasını sağlar.
        refreshBool = true;
        updateValues(getApplicationContext());
    }
}
