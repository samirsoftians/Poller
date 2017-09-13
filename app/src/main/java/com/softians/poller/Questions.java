package com.softians.poller;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.softians.poller.activitys.Tablay;
import com.softians.poller.links.Links;
import com.softians.poller.links.ParseJSON2;

import static com.softians.poller.activitys.Tablay.myanswer;

/**
 * Created by Lenovo on 9/4/2017.
 */

public class Questions extends AppCompatActivity {


    Button back,finished;

//    public static String[] myanswer=new String[50];
    public static ListView listView2;
    TextView finish;

    Button button_save;
    RequestQueue requestQueue;
    TextClock timer;
    int i;
    int k=0;
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display2);


        getSupportActionBar().setDisplayShowTitleEnabled(true);
        requestQueue = com.android.volley.toolbox.Volley.newRequestQueue(Questions.this);

       // finish= (TextView) findViewById(R.id.finish);
        listView2 = (ListView) findViewById(R.id.listView2);
        back= (Button) findViewById(R.id.back);
        finished= (Button) findViewById(R.id.finished);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Questions.this,Tablay.class);
                startActivity(i);
            }
        });

        finished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Questions.this, "Test Successfully Submitted", Toast.LENGTH_SHORT).show();

            }
        });


        listView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Questions.this,Questions.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        //timer= (TextClock) findViewById(R.id.timer);


//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("Pollar");
//        setSupportActionBar(toolbar);




//        finish.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(Questions.this, "Successfully Submitted", Toast.LENGTH_SHORT).show();
//            }
//        });

        //button_save= (Button) findViewById(R.id.button_save);

//        button_save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//
//
//                for (i = 0; i <= CustomList2.size; i++) {
//                    View view = listView2.getChildAt(i);
//                    EditText e = (EditText) view.findViewById(R.id.edittext_answer);
//                    String string = e.getText().toString();
//
//                    CustomList2.answers[i] = string;
//                }
//
//
//                String json_string =Links.ANSWERS;
//
////Repeat and loop this until all objects are added (and add try+catch)
////                JSONObject obj_new = new JSONObject();
////                obj_new.put("fish_id", your_looped_string_1[i]);
////                obj_new.put("fish_lat", your_looped_string_2[i]);
////                obj_new.put("fish_lon", your_looped_string_3[i]);
////                json_string = json_string + obj_new.toString() + ",";
////
//////Close JSON string
////                json_string = json_string.substring(0, json_string.length()-1);
////                json_string += "]}";
////
//
//
//
//
//
//
//               // while (k<=CustomList2.size)
//               // {
//
//
//
////                                    View view = listView2.getChildAt(k);
////                                    EditText e = (EditText) view.findViewById(R.id.edittext_answer);
////                                    String string = e.getText().toString();
////
////                                    CustomList2.answers[k] = string;
//
//
//
////                        Toast.makeText(Questions.this, CustomList2.questions[i], Toast.LENGTH_SHORT).show();
////                        Toast.makeText(Questions.this, CustomList2.answers[i], Toast.LENGTH_SHORT).show();
//
//
//                        //***************************Volley starts here*****************************************
//
//                        StringRequest request = new StringRequest(Request.Method.POST, Links.ANSWERS, new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//
//
//                                k++;
//
//                                Toast.makeText(Questions.this, "Successfully Saved ", Toast.LENGTH_SHORT).show();
//
////                                Intent intent=new Intent(UserRegistration.this, LoginRegister.class);
////                                startActivity(intent);
//
//
//
//                            }
//                        }, new Response.ErrorListener() {
//                            @Override
//                            public void onErrorResponse(VolleyError error) {
////                                myPd_ring.dismiss();
//                                if (error instanceof NetworkError) {
//                                    Toast.makeText(Questions.this, "Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
//                                } else if (error instanceof ServerError) {
//                                    Toast.makeText(Questions.this, "The server could not be found. Please try again after some time!!", Toast.LENGTH_LONG).show();
//                                } else if (error instanceof AuthFailureError) {
//                                    Toast.makeText(Questions.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
//                                } else if (error instanceof ParseError) {
//                                    Toast.makeText(Questions.this, "Parsing error! Please try again after some time !!", Toast.LENGTH_LONG).show();
//
//                                } else if (error instanceof NoConnectionError) {
//                                    Toast.makeText(Questions.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
//                                } else if (error instanceof TimeoutError) {
//                                    Toast.makeText(Questions.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
//                                }
//                                // counter++;
//                            }
//
//                            {
//
//                            }
//                        }) {
//
//                            @Override
//                            protected Map<String, String> getParams() throws AuthFailureError {
//                                Map<String, String> parameters = new HashMap<String, String>();
//
//                                for (i = 0; i <= CustomList2.size; i++) {
//                                    View view = listView2.getChildAt(i);
//                                    EditText e = (EditText) view.findViewById(R.id.edittext_answer);
//                                    String string = e.getText().toString();
//
//                                    CustomList2.answers[i] = string;
//
//
//                                    parameters.put("q_number", CustomList2.questions[i]);
//                                    parameters.put("answer", CustomList2.answers[i]);
//                                    parameters.put("user_name", LoginRegister.userLogedin);
//                                    parameters.put("m_name", Variables.module_name);
//                               }
//
//
//
//
//
//
//
//
//                                return parameters;
//                            }
//                        };
//                        requestQueue.add(request);
//
//                        //******************************Volley Ends here*****************************************
//                   //}
//
//
//
//            }
//        });
//
//



        if(Variables.refresh==0) {

            //***************************Volley to get data from the server*******************

            StringRequest stringRequest841 = new StringRequest(Links.GETQUESTION+Variables.module_name, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    showJSON(response);

                    // Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    JSONArray result = jsonObject.getJSONArray(Keyvalue.JSON_ARRAY);
//                    JSONObject collegeData = result.getJSONObject(0);
//
//                    //  mm = collegeData.getString(Keyvalue.KEY_MODULE);
////                      Toast.makeText(getContext(), m, Toast.LENGTH_SHORT).show();
//
//
//                    //  mTxtsetID.setText(collegeData.getString(Keyvalue.KEY_MODULE));
//
//                    //*********mISSING**
//
//
//
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }

                    // Toast.makeText(getContext(), mm, Toast.LENGTH_SHORT).show();


                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            if (error instanceof NetworkError) {
                                Toast.makeText(Questions.this, "Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
                            } else if (error instanceof ServerError) {
                                Toast.makeText(Questions.this, "The server could not be found. Please try again after some time!!", Toast.LENGTH_LONG).show();
                            } else if (error instanceof AuthFailureError) {
                                Toast.makeText(Questions.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                            } else if (error instanceof ParseError) {
                                Toast.makeText(Questions.this, "Parsing error! Please try again after some time !!", Toast.LENGTH_LONG).show();

                            } else if (error instanceof NoConnectionError) {
                                Toast.makeText(Questions.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                            } else if (error instanceof TimeoutError) {
                                Toast.makeText(Questions.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                            }


                        }
                    });
            RequestQueue requestQueue = com.android.volley.toolbox.Volley.newRequestQueue(this);
            requestQueue.add(stringRequest841);


        }

        else {

            CustomList2 c1 = new CustomList2(this, ParseJSON2.ids,ParseJSON2.question,myanswer);
            listView2.setAdapter(c1);

        }

        //******************************Volley Ends Here**************************



    }


    private void showJSON(String json){
        ParseJSON2 pj = new ParseJSON2(json);
        pj.parseJSON2();


        CustomList2 c1 = new CustomList2(this, ParseJSON2.ids,ParseJSON2.question,myanswer);
        listView2.setAdapter(c1);


        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {



//}

            }
        });



    }

    public void refresh()
    {
        CustomList2 c1 = new CustomList2(this, ParseJSON2.ids,ParseJSON2.question,myanswer);
        listView2.setAdapter(c1);
    }


    public void onBackPressed() {

        //super.onBackPressed();
        Log.d("back button", "back button pressed");
        AlertDialog.Builder ad1=new AlertDialog.Builder(this);
        ad1.setMessage("Are you sure you want to exit ?");
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

                Intent intent = new Intent(Questions.this, Tablay.class);
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
