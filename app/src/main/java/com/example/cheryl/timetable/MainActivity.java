package com.example.cheryl.timetable;

import android.os.Build;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static String[][] period={{"Comp Org","Comp Org","Unix","DMS","DS","Maths 3","EC/LD lab","EC/LD lab","EC/LD lab"},
                                        {"Ec/Ld","Ec/Ld","DMS","DS","Unix","Maths 3","Tutorials","Tutorials","Tutorials"},
                                        {"DMS","DS","Maths 3","DS Lab","DS Lab","DS Lab"," --- "," --- "," --- "},
                                        {"Unix","Unix","Comp Org","Ec/Ld","DMS","DS"," --- "," --- "," --- "},
                                        {"DMS","Maths 3","Unix"," --- "," --- "," --- "," --- "," --- "," --- "},
                                        {"Comp Org","Comp Org","DS","Ec/Ld","Ec/Ld","Maths 3"," --- "," --- "," --- "}};

    private static String[] head={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

    periods p = new periods();


    Date now = new Date();
    private ListView listView;
    private int day;
    private String dayString;
    private SimpleDateFormat simpleDateformat;
    private TextView dayBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        //Remove title bar
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Hiding the action bar
        //getSupportActionBar().hide();

        //set content view AFTER ABOVE sequence (to avoid crash)
        setContentView(R.layout.activity_main);
        View mainView = (View) findViewById(R.id.mainView);

        mainView.setOnTouchListener(new OnSwipeTouchListener() {
            public boolean onSwipeTop() {
                Toast.makeText(MainActivity.this, "top", Toast.LENGTH_SHORT).show();
                return true;
            }
            public boolean onSwipeRight() {
                Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
                return true;
            }
            public boolean onSwipeLeft() {
                Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
                return true;
            }
            public boolean onSwipeBottom() {
                Toast.makeText(MainActivity.this, "bottom", Toast.LENGTH_SHORT).show();
                return true;
            }
        });





        simpleDateformat = new SimpleDateFormat("EEEE");
        dayString = simpleDateformat.format(now);
        p.setDay(dayString);

        dayBanner= (TextView) findViewById(R.id.day);
        dayBanner.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        listView = (ListView) findViewById(R.id.gridView);
        listView.setOnTouchListener(new OnSwipeTouchListener() {
            public boolean onSwipeTop() {
                return true;
            }
            public boolean onSwipeRight() {
                p.previous();
                updateView();

                return true;
            }
            public boolean onSwipeLeft() {

                p.next();
                updateView();

                return true;
            }
            public boolean onSwipeBottom() {
                return true;
            }
        });
        updateView();

    }

    private void updateView(){
        dayBanner.setText(p.getDay());
        listView.setAdapter(new customAdapter(this,p.getPeriods()));
    }

    }
