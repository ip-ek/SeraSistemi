package com.ipk.serasistemi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailedGhActivity extends AppCompatActivity {
    TextView tw_deneme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_gh);

        tw_deneme=findViewById(R.id.deneme);

        int gh_no = getIntent().getIntExtra("GH_no",0);

        tw_deneme.setText("aboooo: "+ gh_no);


    }
}
