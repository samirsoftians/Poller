package com.softians.poller;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.softians.poller.activitys.Tablay;
import com.softians.poller.links.ParseJSON2;

import java.util.ArrayList;

/**
 * Created by Lenovo on 9/4/2017.
 */

public class CustomList2 extends ArrayAdapter<String> {

    ArrayList<String > myList = new ArrayList<>();
    Questions questions;

    int lastposition;

    //public static String[] questions = new String[25];
    public static int size = 0;
    public String[] ids;
    public String[] question;
    public String[] myanswer;
    String value="null";

    int i=0;

    Activity context;

    public static EditText mTxtAnswer;
    TextView txtsetID;

    CardView card_view3;

    public CustomList2(Activity context, String[] ids, String[] question,String[] myanswer) {
        super(context, R.layout.movie_list_row, ids);
        this.context = context;
        this.ids = ids;
        this.question = question;
        this.myanswer = myanswer;

    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.movie_list_row, null, true);
        questions=new Questions();

        txtsetID = (TextView) listViewItem.findViewById(R.id.question);
        mTxtAnswer = (EditText) listViewItem.findViewById(R.id.txtAnswer);

        card_view3 = (CardView) listViewItem.findViewById(R.id.card_view3);
        size = position;

       // questions[position] = question[position];
        Tablay.myanswer[i]=mTxtAnswer.getText().toString();

        int incremtquestion= Integer.parseInt(ParseJSON2.questionnumber[position])+1;


        txtsetID.setText(incremtquestion +".  "+question[position]);
       // mTxtAnswer.setText(myanswer[position]);


       /* mTxtAnswer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(MotionEvent.ACTION_UP == event.getAction()) {

                    lastposition=position;

                    value=mTxtAnswer.getText().toString();
                    myanswer[position]=mTxtAnswer.getText().toString();
//****************************************************************************************************************************
                    //*************************Volley Starts And Ends Here*************
                    if(position>0) {


                        StringRequest stringRequest = new StringRequest(Request.Method.POST, Links.ANSWERS,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {

                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {

                                        if (error instanceof NetworkError) {
                                            Toast.makeText(getContext(), "Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
                                        } else if (error instanceof ServerError) {
                                            Toast.makeText(getContext(), "The server could not be found. Please try again after some time!!", Toast.LENGTH_LONG).show();
                                        } else if (error instanceof AuthFailureError) {
                                            Toast.makeText(getContext(), "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                                        } else if (error instanceof ParseError) {
                                            Toast.makeText(getContext(), "Parsing error! Please try again after some time !!", Toast.LENGTH_LONG).show();

                                        } else if (error instanceof NoConnectionError) {
                                            Toast.makeText(getContext(), "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                                        } else if (error instanceof TimeoutError) {
                                            Toast.makeText(getContext(), "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                                        }

                                    }
                                }) {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String, String> parameters = new HashMap<String, String>();

                                for (i = 0; i <= CustomList2.size; i++) {
                                    View view = Questions.listView2.getChildAt(i);
                                    EditText e = (EditText) view.findViewById(R.id.txtAnswer);
                                    String string = e.getText().toString();

                                   // CustomList2.answers[i] = string;


                                    if(lastposition-1==i) {
                                        parameters.put("q_number", question[lastposition-1]);
                                        parameters.put("answer", myanswer[lastposition-1]);
                                        parameters.put("user_name", Variables.UserLogedin);
                                        parameters.put("m_name", Variables.module_name);
                                    }
                                }




                                return parameters;
                            }
                        };

                        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
                        requestQueue.add(stringRequest);


                    }
                    //****************************Volley Ends Here***********************
                }

                return false; // return is important...
            }
        });*/
//*********************************************************************************************************************************
        //***************************************************************************************************************************
/*

        mTxtAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    LayoutInflater layoutInflater = LayoutInflater.from(getContext());
                    View rootView = layoutInflater.inflate(R.layout.dialogbox, null);
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                    alertDialogBuilder.setView(rootView);

                    final EditText yourEditText = (EditText) rootView.findViewById(R.id.etComments);
               final TextView dialogquestion= (TextView) rootView.findViewById(R.id.dialogquestion);
                dialogquestion.setText(question[position]);

                    alertDialogBuilder.setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener()
                            {
                                public void onClick(DialogInterface dialog, int id)
                                {

                                    Variables.refresh=1;
//***********************************************Volley Starts Here*****************************
                                   // String name = yourEditText.getText().toString().substring(0,1).toUpperCase() + yourEditText.getText().toString().substring(1).toLowerCase();
                                    //CustomList2.mTxtAnswer.setText(yourEditText.getText().toString());
                                   // Toast.makeText(context, question[position], Toast.LENGTH_SHORT).show();
                                  //  String Answers=yourEditText.getText().toString();
//                                    myList.add(yourEditText.getText().toString());
//
//
//                                    for(int count=0;count<=size;count++)
//                                    {
//
//                                    }

                                    Tablay.myanswer[position]=yourEditText.getText().toString();

                                    String Answers=yourEditText.getText().toString();
                                   // mTxtAnswer.setText(Answers);

                                    Intent intent=new Intent(getContext(),Questions.class);

                                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    getContext().startActivity(intent);


//                                    CustomLsit3 c1 = new CustomLsit3((Activity) getContext(), ParseJSON2.ids,ParseJSON2.question,Tablay.myanswer);
//                                    questions.listView2.setAdapter(c1);



                                    //String p= String.valueOf(position);
                                    //Toast.makeText(getContext(), p, Toast.LENGTH_SHORT).show();


                                   // Questions questions=new Questions();
//                                    for (i = 0; i <= CustomList2.size; i++) {
//
//
//
//                                        View view = questions.listView2.getChildAt(i);//getChildAt
//                                        TextView   mTxtAnswer2 = (TextView) view.findViewById(R.id.txtAnswer);
//
//                                        if(i==position)
//                                        {
//                                            mTxtAnswer2.setText(Answers);
//                                        }
//
//
//                                    }

//                                    questions.refresh();



                                    //*************************Volley Starts And Ends Here*************

                                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Links.ANSWERS,
                                            new Response.Listener<String>()
                                            {
                                                @Override
                                                public void onResponse(String response)
                                                {

                                                }
                                            },
                                            new Response.ErrorListener()
                                            {
                                                @Override
                                                public void onErrorResponse(VolleyError error)
                                                {

                                                    if (error instanceof NetworkError)
                                                    {
                                                        Toast.makeText(getContext(),"Cannot connect to Internet...Please check your connection!",Toast.LENGTH_LONG ).show();
                                                    }
                                                    else if (error instanceof ServerError)
                                                    {
                                                        Toast.makeText(getContext(),"The server could not be found. Please try again after some time!!",Toast.LENGTH_LONG ).show();
                                                    }
                                                    else if (error instanceof AuthFailureError)
                                                    {
                                                        Toast.makeText(getContext(),"Cannot connect to Internet...Please check your connection !",Toast.LENGTH_LONG ).show();
                                                    }
                                                    else if (error instanceof ParseError)
                                                    {
                                                        Toast.makeText(getContext(),"Parsing error! Please try again after some time !!",Toast.LENGTH_LONG ).show();

                                                    }
                                                    else if (error instanceof NoConnectionError)
                                                    {
                                                        Toast.makeText(getContext(),"Cannot connect to Internet...Please check your connection !",Toast.LENGTH_LONG ).show();
                                                    }
                                                    else if (error instanceof TimeoutError)
                                                    {
                                                        Toast.makeText(getContext(),"Cannot connect to Internet...Please check your connection !",Toast.LENGTH_LONG ).show();
                                                    }

                                                }
                                            })
                                    {
                                        @Override
                                        protected Map<String, String> getParams() throws AuthFailureError
                                        {
                                            Map<String,String> parameters  = new HashMap<String, String>();
                                            parameters.put("q_number", question[position]);
                                            parameters.put("answer", yourEditText.getText().toString());
                                            parameters.put("user_name", Variables.UserLogedin);
                                            parameters.put("m_name", Variables.module_name);


                                            return parameters;
                                        }
                                    };

                                    RequestQueue requestQueue = Volley.newRequestQueue(getContext());
                                    requestQueue.add(stringRequest);

                                    //****************************Volley Ends Here***********************



                                }
                            })
                            .setNegativeButton("Back",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {

                                            dialog.cancel();

                                        }
                                    });

                    AlertDialog alert = alertDialogBuilder.create();
                    alert.show();

                    //*******************************Allert Ends Here********************************



            }
        });     */

        return listViewItem;
    }

//    static class ViewHolder{
//
//        TextView text;
//    }
}
