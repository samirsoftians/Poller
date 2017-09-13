package com.softians.poller.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
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
import com.softians.poller.CustomList;
import com.softians.poller.Questions;
import com.softians.poller.R;
import com.softians.poller.links.Links;
import com.softians.poller.links.ParseJSON;


public class fragment_question extends Fragment {

//    private android.support.v7.widget.CardView mCard_view;
//    private RelativeLayout mTaimedateRelativelayoutID;
//    private TextView mTxtDatdID;
//    private TextView mTxtTImeID;
//    private TextView mTxtsetID;
//    private android.support.v7.widget.CardView mCard_viewsecond;
//    private RelativeLayout mTaimedateRelativelayoutIDsecond;
//    private TextView mTxtDatdIDsecond;
//    private TextView mTxtTImeIDsecond;
//    private TextView mTxtsetIDsecond;
//    private android.support.v7.widget.CardView mCard_viewsecondthird;
//    private RelativeLayout mTaimedateRelativelayoutIDthird;
//    private TextView mTxtDatdIDthird;
//    private TextView mTxtTImeIDthird;
//    private TextView mTxtsetIDthird;
//
//    String mm;
private ListView listView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


//         RequestQueue requestQueue841 = Volley.newRequestQueue(getContext());



        View view = inflater.inflate(R.layout.display,
                container, false);

        listView = (ListView) view.findViewById(R.id.listView);


        //***************************Volley to get data from the server*******************


//        if(Variables.openactivity==0) {

            StringRequest stringRequest841 = new StringRequest(Links.MODULE, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    showJSON(response);

                  //  Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
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
                    });
            RequestQueue requestQueue = com.android.volley.toolbox.Volley.newRequestQueue(getContext());
            requestQueue.add(stringRequest841);

//        }
//
//        else
//        {
//            CustomList c1 = new CustomList(getActivity(), ParseJSON.ids, ParseJSON.m_name,ParseJSON.txtTImeID);
//            listView.setAdapter(c1);
//        }

        //******************************Volley Ends Here**************************


//        View view = inflater.inflate(R.layout.fragment_fragment_question,
//                container, false);
//        mCard_view = (android.support.v7.widget.CardView) view.findViewById(R.id.card_view);
//        mTaimedateRelativelayoutID = (RelativeLayout) view.findViewById(R.id.taimedateRelativelayoutID);
//        mTxtDatdID = (TextView) view.findViewById(R.id.txtDatdID);
//        mTxtTImeID = (TextView) view.findViewById(R.id.txtTImeID);
//        mTxtsetID = (TextView) view.findViewById(R.id.txtsetID);
//        bindview(view);
        return view;
    }





    //****************************Volley ends here*****************************************

//    private void bindview(View view) {
//
//
//
//
//
//
//
//       // mCard_view.setOnClickListener(this);
//    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//
//            case R.id.card_view:
//
//                Intent intent=new Intent(getActivity(), QuetionActivity.class);
//                startActivity(intent);
//
//                break;
//
//        }
//    }




    private void showJSON(String json){
        ParseJSON pj = new ParseJSON(json);
        pj.parseJSON();

//    Toast.makeText(getContext(), ParseJSON.m_name[0], Toast.LENGTH_SHORT).show();
//        Toast.makeText(getContext(), ParseJSON.m_name[1], Toast.LENGTH_SHORT).show();
       // Toast.makeText(getContext(), pj.m_name, Toast.LENGTH_SHORT).show();
//       Toast.makeText(getContext(),ParseJSON.m_name, Toast.LENGTH_SHORT).show();
       CustomList c1 = new CustomList(getActivity(), ParseJSON.tid, ParseJSON.m_name,ParseJSON.txtTImeID);
      listView.setAdapter(c1);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                Intent intent=new Intent(getContext(), Questions.class);
                startActivity(intent);

//               ;
               // }


//I ADDED ON CLICK IMPLEMENTATION HERE, BUT THIS IS NOT WORKING
                //Toast.makeText(getApplicationContext(), "CLICKED", Toast.LENGTH_SHORT).show();
            }
        });




    }



}
