package com.ipk.serasistemi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DetailedGhActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener{
    TextView tw_name, tw_curr_temp, tw_wanted_temp, tw_temp_space, tw_change_temp_btn, tw_change_space_btn, tw_save_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_gh);

        tw_name=findViewById(R.id.gh_name);
        tw_curr_temp=findViewById(R.id.gh_curr_temp);
        tw_wanted_temp=findViewById(R.id.gh_wanted_temp);
        //tw_temp_space=findViewById(R.id.gh_temp_space);
        tw_change_temp_btn=findViewById(R.id.gh_change_temp_btn);
        //tw_change_space_btn=findViewById(R.id.gh_change_space_btn);
        tw_save_btn=findViewById(R.id.gh_save);

        int gh_no = getIntent().getIntExtra("GH_no",0);
        int heat= getIntent().getIntExtra("GH_temp", 0);
        int target_heat= getIntent().getIntExtra("GH_target",0);

        tw_name.setText(getApplicationContext().getString(R.string.gh)+" "+ gh_no);
        tw_curr_temp.setText(heat+"^C");
        tw_wanted_temp.setText(target_heat+"^C");

        tw_change_temp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(1,0,100);
            }
        });

        /*tw_change_space_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(2,0,100);
            }
        });*/

        tw_save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: push everything to server.
                //id ve değerler
                finish();
            }
        });

    }

    public void show(final int type, int min_val, int max_val){

        final Dialog d = new Dialog(DetailedGhActivity.this);
        d.setTitle("NumberPicker");
        d.setContentView(R.layout.dialog);
        Button set = (Button) d.findViewById(R.id.button_set);
        Button canc = (Button) d.findViewById(R.id.button_cancel);
        final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);
        np.setMaxValue(max_val); // max value 100
        np.setMinValue(min_val);   // min value 0
        np.setWrapSelectorWheel(false);
        np.setOnValueChangedListener(this);
        Log.d("takip", "hetyy");
        set.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(type==1){
                    tw_wanted_temp.setText(String.valueOf(np.getValue())+"^C"); //set the value to textview
                }else{
                    if(type==2){
                        //tw_temp_space.setText(String.valueOf(np.getValue())+"^C");
                    }
                }

                d.dismiss();

            }
        });
        canc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.dismiss(); // dismiss the dialog
            }
        });
        d.show();


    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        Log.i("value is",""+newVal);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
