package com.softians.poller;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.StringTokenizer;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * Created by Lenovo on 2/28/2017.
 */

public class CustomList extends ArrayAdapter<String> {

    private long timeCountInMilliSeconds = 1*60000;
    Handler m_handler;//= new Handler();
    Runnable m_handlerTask ;
    public int time2;
    public CountDownTimer countDownTimer;


    Handler handler = new Handler();
    Timer _t,timer;
    TextView txtsetID;
    public  TextView time;

    private int counter = 0;

//    public static String[] module=new String[100];
    private String[] ids;
    private String[] m_name;
    private String[] txtTImeID;

    int totaltime=0;
//    int number;

//    private String[] emails;
//    private String[] ratings;
//    private Activity context;
Activity context;

    public CustomList(Activity context, String[] ids, String[] m_name, String[] txtTImeID) {
        super(context, R.layout.fragment_fragment_question, ids);
        this.context = context;
        this.ids = ids;
        this.m_name = m_name;
this.txtTImeID=txtTImeID;




    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.fragment_fragment_question, null, true);

        CardView c= (CardView) listViewItem.findViewById(R.id.card_view);


        txtsetID = (TextView) listViewItem.findViewById(R.id.txtsetID);
        time= (TextView) listViewItem.findViewById(R.id.txtTImeID);



        txtsetID.setText(m_name[position]);
        time.setText(txtTImeID[position]);

        //***************************Tokinizer*************************************


        StringTokenizer tokenizer = new StringTokenizer(txtTImeID[position], ":");

        while (tokenizer.hasMoreTokens()) {

            if(totaltime==0)
            {
                Variables.number= Integer.parseInt(tokenizer.nextToken())*3600;

                totaltime=1;
            }
            else if(totaltime==1)
            {
                Variables.number=Variables.number+Integer.parseInt(tokenizer.nextToken())*60;
                String num= String.valueOf(Variables.number);
                //Toast.makeText(context, num, Toast.LENGTH_SHORT).show();
                totaltime=2;
            }
            else
            {
                Variables.number=Variables.number+Integer.parseInt(tokenizer.nextToken());
                String num= String.valueOf(Variables.number);
                // Toast.makeText(context, num, Toast.LENGTH_SHORT).show();

                // totaltime=0;
            }


            //txtTImeID[position]

        }

        //***********************************Tokinizer Ends here***********************


     //  time.setText(txtTImeID[position]);
        //String nu= String.valueOf(Variables.number);
       // time2 = Integer.parseInt(txtTImeID[position]);
        time2=Variables.number/60;
        timeCountInMilliSeconds =  time2* 60 * 1000;
       // Toast.makeText(getContext(), String.valueOf(Variables.a++), Toast.LENGTH_SHORT).show();



        countDownTimer = new CountDownTimer(timeCountInMilliSeconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                time.setText(hmsTimeFormatter(millisUntilFinished));

//                progressBarCircle.setProgress((int) (millisUntilFinished / 1000));

            }

            @Override
            public void onFinish() {

                time.setText(hmsTimeFormatter(timeCountInMilliSeconds));
                // call to initialize the progress bar values
//                setProgressBarValues();
                // hiding the reset icon
//                imageViewReset.setVisibility(View.GONE);
                // changing stop icon to start icon
//                imageViewStartStop.setImageResource(R.mipmap.ic_launcher);
                // making edit text editable
                //editTextMinute.setEnabled(true);
                // changing the timer status to stopped
               // timerStatus = TimerStatus.STOPPED;
            }

        }.start();
        countDownTimer.start();


       // time2 = Integer.parseInt(txtTImeID[position]);





//
//        //*********************************************************
//        countDownTimer = new CountDownTimer(timeCountInMilliSeconds, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//
//                time.setText(hmsTimeFormatter(millisUntilFinished));
//
//
//
//
//              //  time.setText(hms);
//
////                progressBarCircle.setProgress((int) (millisUntilFinished / 1000));
//
//            }
//
//            @Override
//            public void onFinish() {
//
//                time.setText(hmsTimeFormatter(timeCountInMilliSeconds));
//                // call to initialize the progress bar values
////                setProgressBarValues();
//                // hiding the reset icon
////                imageViewReset.setVisibility(View.GONE);
//                // changing stop icon to start icon
////                imageViewStartStop.setImageResource(R.mipmap.ic_launcher);
//                // making edit text editable
//                //editTextMinute.setEnabled(true);
//                // changing the timer status to stopped
//               // timerStatus = TimerStatus.STOPPED;
//            }
//
//        }.start();
//        countDownTimer.start();
////



        //*******************************************************


        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Variables.stop=1;

                Variables.module_name=m_name[position];
              // Toast.makeText(context, Variables.module_name, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), Questions.class);
                getContext().startActivity(intent);
            }
        });













//






/*//***************************

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {



                if(Variables.stop==0) {

                    Variables.refresh=1;

                    Variables.number = Variables.number - 1;
                    int hr = Variables.number / 3600;
                    int min = (Variables.number % 3600) / 60;
                    // int sec=(Variables.number%3600)%60;

                    String hour = String.valueOf(hr);

                    String minut = String.valueOf(min);

                    //  String second= String.valueOf(sec);

                    String print = hour + ":" + minut;//+second

                    Toast.makeText(context, print, Toast.LENGTH_SHORT).show();

                    ParseJSON.txtTImeID[position] = print;
                   // txtsetID.setText(m_name[position]);
                   // time.setText(print);

                    Intent intent = new Intent(getContext(), Tablay.class);

                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    getContext().startActivity(intent);

                }
            }
        }, 60000);


   //*******************************************************************/




        return listViewItem;
    }

    private String hmsTimeFormatter(long milliSeconds) {

        String hms = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(milliSeconds),
                TimeUnit.MILLISECONDS.toMinutes(milliSeconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliSeconds)),
                TimeUnit.MILLISECONDS.toSeconds(milliSeconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliSeconds)));

        return hms;


    }



}




