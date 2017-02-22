package com.example.patrick.rolldice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Roll> rollshistory = new ArrayList<>();

    private Button btnRoll, btnHistory;
    private Spinner dropdown;
    private TextView t1, t2, t3,t4,t5,t6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        t1 = (TextView) findViewById(R.id.textView2);
        t2 = (TextView) findViewById(R.id.textView3);
        t3 = (TextView) findViewById(R.id.textView4);
        t4 = (TextView) findViewById(R.id.textView5);
        t5 = (TextView) findViewById(R.id.textView6);
        t6 = (TextView) findViewById(R.id.textView7);

        dropdown = (Spinner) findViewById(R.id.spinner);
        String[] drops = new String[]{"1", "2", "3", "4", "5", "6"};
        ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, drops);
        dropdown.setAdapter(a);


        btnRoll = (Button) findViewById(R.id.btnRoll);
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = dropdown.getSelectedItemPosition()+1;
                int[] list = new int[6];
                Random r = new Random();

                switch (i)
                {
                    case 1:
                        list[0] = r.nextInt(6)+1;
                        t1.setText(list[0]+"");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        t5.setText("");
                        t6.setText("");
                        break;
                    case 2:
                        for(int ii = 0; ii <i; ii++)
                        {
                            list[ii] = r.nextInt(6)+1;
                        }

                        t1.setText((list[0])+"");
                        t2.setText((list[1])+"");
                        t3.setText("");
                        t4.setText("");
                        t5.setText("");
                        t6.setText("");
                        break;
                    case 3:
                        for(int ii = 0; ii <i; ii++)
                        {
                            list[ii] = r.nextInt(6)+1;
                        }

                        t1.setText((list[0])+"");
                        t2.setText((list[1])+"");
                        t3.setText((list[2])+"");
                        t4.setText("");
                        t5.setText("");
                        t6.setText("");
                        break;
                    case 4:
                        for(int ii = 0; ii <i; ii++)
                        {
                            list[ii] = r.nextInt(6)+1;
                        }

                        t1.setText((list[0])+"");
                        t2.setText((list[1])+"");
                        t3.setText((list[2])+"");
                        t4.setText((list[3])+"");
                        t5.setText("");
                        t6.setText("");
                        break;
                    case 5:
                        for(int ii = 0; ii <i; ii++)
                        {
                            list[ii] = r.nextInt(6)+1;
                        }

                        t1.setText((list[0])+"");
                        t2.setText((list[1])+"");
                        t3.setText((list[2])+"");
                        t4.setText((list[3])+"");
                        t5.setText(list[4]+"");
                        t6.setText("");
                        break;
                    case 6:
                        for(int ii = 0; ii <i; ii++)
                        {
                            list[ii] = r.nextInt(6)+1;
                        }

                        t1.setText((list[0])+"");
                        t2.setText((list[1])+"");
                        t3.setText((list[2])+"");
                        t4.setText((list[3])+"");
                        t5.setText(list[4]+"");
                        t6.setText(list[5]+"");
                        break;
                    default:
                        for(int ii = 0; ii <i; ii++)
                        {
                            list[ii] = r.nextInt(6)+1;
                        }

                        t1.setText((list[0])+"");
                        t2.setText((list[1])+"");
                        t3.setText((list[2])+"");
                        t4.setText((list[3])+"");
                        t5.setText(list[4]+"");
                        t6.setText(list[5]+"");
                        break;
                }
                Roll rl = new Roll();
                rl.setDice1(list[0]);
                rl.setDice2(list[1]);
                rl.setDice3(list[2]);
                rl.setDice4(list[3]);
                rl.setDice5(list[4]);
                rl.setDice6(list[5]);
                rollshistory.add(rl);

            }
        });

        btnHistory = (Button) findViewById(R.id.btnHistory);
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent score = new Intent(getApplicationContext(), ScoreView.class);
                score.putExtra("history", rollshistory);
                startActivity(score);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
