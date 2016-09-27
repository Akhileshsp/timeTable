package com.example.cheryl.timetable;

import android.app.Application;
import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class customAdapter extends BaseAdapter{


    String periodList[];
    Context context;

    private static String[] time ={"08:00 - 08:50","08:50 - 09:40","09:40 - 10:30","11:00 - 11:50","11:50 - 12:40","12:40 - 01:30","02:15 - 03:05","03:05 - 03:55","03:55 - 04:45"};

    public customAdapter(MainActivity mainActivity,String[] s){

            periodList =s;
            context=mainActivity;

    }


    @Override
    public int getCount() {
        return time.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }


    @Override
    public long getItemId(int i) {
        return i;
    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null) {

            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.timetable, viewGroup,false);

            TextView t = (TextView) view.findViewById(R.id.period);
            TextView t2 = (TextView) view.findViewById(R.id.time);
            View line = (View) view.findViewById(R.id.linebottum);

            t2.setText(time[i]);
            t.setText(periodList[i]);

            if (periodList[i] == " --- "){
                t.setText(" ");
                t2.setText(" ");
                line.setVisibility(View.INVISIBLE);
            }

        }
        else{
            TextView t2 = (TextView) view.findViewById(R.id.time);
            TextView t = (TextView) view.findViewById(R.id.time);
            View line = (View) view.findViewById(R.id.linebottum);


            t.setText(periodList[i]);
            t2.setText(time[i]);

        }


        return view;

    }
}
