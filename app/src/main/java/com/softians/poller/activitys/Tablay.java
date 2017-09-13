package com.softians.poller.activitys;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.softians.poller.R;
import com.softians.poller.Variables;
import com.softians.poller.adapter.ViewPagerAdapter;
import com.softians.poller.fragments.fragment_question;
import com.softians.poller.fragments.fragment_user_stats;
import com.softians.poller.fragments.fragment_winners;


public class Tablay extends AppCompatActivity {

    public static String[] myanswer=new String[50];
    public static String[] modules=new String[50];
    Toolbar toolbar;
    TabLayout tablayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    CollapsingToolbarLayout collapingsToollbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablay);

       // getSupportActionBar().setDisplayShowTitleEnabled(true);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        for(int i=0;i<50;i++)
        {
            myanswer[i]="answer....";
        }
        bindview();
    }

    private void bindview() {



//        toolbar = (Toolbar)findViewById(R.id.toolbar);
//        toolbar.setTitle("Give Answers and win");
       // setSupportActionBar(toolbar);
        tablayout=(TabLayout)findViewById(R.id.tablayout);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new fragment_question(),"Questions");
        viewPagerAdapter.addFragment(new fragment_winners(),"Winners");
        viewPagerAdapter.addFragment(new fragment_user_stats(),"Stats");
        viewPager.setAdapter(viewPagerAdapter);
        tablayout.setupWithViewPager(viewPager);

//        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                tablayout.setSelectedTabIndicatorColor(Color.parseColor("#fff"));
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
////        } () {
////            @Override
////            public void onClick(View v) {
////                tablayout.setSelectedTabIndicatorColor(Color.parseColor("#fff"));
////            }
//        });
//        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                tab.getIcon().setColorFilter(Color.parseColor("#a8a8a8"), PorterDuff.Mode.SRC_IN);
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//      collapingsToollbar=(CollapsingToolbarLayout)findViewById(R.id.collapings);
//
//        collapingsToollbar.setTitle("Softians Technology");


    }

    public void onBackPressed() {

        //super.onBackPressed();
        Log.d("back button", "back button pressed");
        AlertDialog.Builder ad1=new AlertDialog.Builder(this);
        ad1.setMessage("Navigate to the Login Page ?");
        ad1.setCancelable(false);


        ad1.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {


            }
        });

        ad1.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Variables.module_name="";
                // int lenght =Variables.myanswer.length;

                //  Variables.myanswer=null;

                Variables.refresh=0;

//                for(int i=0; i<=50;i++)
//                {
//                   Variables.myanswer[i]="answers....";
//                }
                //   Variables.myanswer=null;

                Intent intent = new Intent(Tablay.this, LoginRegister.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
//                Intent intent = new Intent(Questions.this, Tablay.class);
//                startActivity(intent);

            }
        });
        AlertDialog alert=ad1.create();
        alert.show();

    }
}
