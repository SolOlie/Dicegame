package com.example.patrick.rolldice;

import android.content.Intent;
import android.opengl.EGLExt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ScoreView extends AppCompatActivity {
    private ListView lstView;
    private DiceScoreListAdapter dsla;
    private ArrayList<Roll> rolla;
    private Button btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_view);

        init();
    }

    private void init() {
        btnClear = (Button)findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dsla.rolls.clear();
               dsla.notifyDataSetChanged();




               MainActivity.rollshistory.clear();
            }
        });

        Intent score = this.getIntent();
        rolla = (ArrayList<Roll>)score.getSerializableExtra("history");

        lstView = (ListView) findViewById(R.id.lstView2);

        dsla = new DiceScoreListAdapter(getApplicationContext(),R.layout.item ,rolla);
        lstView.setAdapter(null);
        lstView.setAdapter(dsla);
    }
}
