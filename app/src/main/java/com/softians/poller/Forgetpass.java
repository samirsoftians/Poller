package com.softians.poller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.softians.poller.activitys.LoginRegister;
import com.softians.poller.links.Links;

import java.util.HashMap;
import java.util.Map;


public class Forgetpass extends Activity {

    EditText eid;
    Button submit;
    RequestQueue requestQueue7;
    //String insertUrl7 =Config.DATA_FORGOT;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgetpass);
        eid= (EditText) findViewById(R.id.emailid2);
        submit= (Button) findViewById(R.id.btnsubmit);
        requestQueue7 = Volley.newRequestQueue(getApplicationContext());
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //////========================================================================================================

                StringRequest request1 = new StringRequest(Request.Method.POST, Links.DATA_FORGOT2, new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {


                        System.out.println(response.toString());

                        Toast.makeText(Forgetpass.this,response, Toast.LENGTH_SHORT).show();
                        Intent sc=new Intent(Forgetpass.this,LoginRegister.class);
                        startActivity(sc);


                    }
                }, new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {

                    }
                })
                {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError
                    {
                        Map<String,String> parameters  = new HashMap<String, String>();
                        parameters.put("user_email",eid.getText().toString());//

                        return parameters;
                    }
                };
                requestQueue7.add(request1);
                //=============================================================================================================
//                Intent i=new Intent(Forgetpass.this,SignInActivity.class);
//                startActivity(i);
//                finish();
            }
        });

    }
}
