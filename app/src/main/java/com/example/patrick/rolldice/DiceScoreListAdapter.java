package com.example.patrick.rolldice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 16-02-2017.
 */

public class DiceScoreListAdapter extends ArrayAdapter<Roll> {
    Context context;
    int resource;
    ArrayList<Roll> rolls = null;

    public DiceScoreListAdapter(Context context, int resource, ArrayList<Roll> rolls) {
        super(context, resource, rolls);
        this.context = context;
        this.resource = resource;
        this.rolls = rolls;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Roll r = rolls.get(position);
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        }
            TextView d1 = (TextView) convertView.findViewById(R.id.dice1);
           String c = ", ";
        ArrayList<Integer> nozero = new ArrayList<>();
        if(r.getDice1()!=0)
        {
            nozero.add(r.getDice1());
        }
        if(r.getDice2()!=0)
        {
            nozero.add(r.getDice2());
        }
        if(r.getDice3()!=0)
        {
            nozero.add(r.getDice3());
        }
        if(r.getDice4()!=0)
        {
            nozero.add(r.getDice4());
        }
        if(r.getDice5()!=0)
        {
            nozero.add(r.getDice5());
        }
        if(r.getDice6()!=0)
        {
            nozero.add(r.getDice6());
        }

        String s="";
        for(int i = 0; i<nozero.size(); i++)
        {
            s+=nozero.get(i)+", ";
        }
       d1.setText("roll: " +s);


            return convertView;

    }
}
