package com.softians.poller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.softians.poller.activitys.LoginRegister;
import com.softians.poller.links.Links;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import customfonts.MyEditText;
import customfonts.MyTextView;

/**
 * Created by Lenovo on 9/2/2017.
 */

public class UserRegistration extends Activity{

    int valid=0;

    MyEditText confirm_password, email_id ,phone_no ,address ,password;
    MyTextView sign_up_button;


    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        requestQueue = com.android.volley.toolbox.Volley.newRequestQueue(UserRegistration.this);

        email_id= (MyEditText) findViewById(R.id.email_id);
        phone_no= (MyEditText) findViewById(R.id.phone_no);
        address= (MyEditText) findViewById(R.id.address);
        password= (MyEditText) findViewById(R.id.password);
        sign_up_button= (MyTextView) findViewById(R.id.sign_up_button);

        confirm_password= (MyEditText) findViewById(R.id.confirm_password);





        sign_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valid=0;

                if (!checkEmail(email_id.getText().toString())) {
                    email_id.setError("Invalid Email");

                    // Toast.makeText(SignUpActivity.this, "Paswword lenght should be greater than 6 char", Toast.LENGTH_SHORT).show();
                    valid++;

                }


                if (!isValidPassword(password.getText().toString())) {
                    password.setError("Password length should be greater than 4 character");

                    // Toast.makeText(SignUpActivity.this, "Paswword lenght should be greater than 6 char", Toast.LENGTH_SHORT).show();
                    valid++;

                }


                if (phone_no.getText().toString().length() < 10 || phone_no.getText().toString().length() >= 12) {

                    phone_no.setError("Please enter valid phone number");
                    // Toast.makeText(SignUpActivity.this,"Please enter valid phone number",Toast.LENGTH_SHORT).show();
                    valid++;
                }


                if(!confirm_password.getText().toString().equals(password.getText().toString()))
                {

                    confirm_password.setError("Password did not matched");
                    valid++;
                }

                if(address.getText().toString().trim().equals(""))
                {
                    address.setError("please enter name");
                    valid++;
                }



                if(valid>0)
                {

                }
                else {

                    StringRequest request = new StringRequest(Request.Method.POST, Links.REGISTRATION, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {


                            Toast.makeText(UserRegistration.this, "Successfully Saved ", Toast.LENGTH_SHORT).show();

                            Intent intent=new Intent(UserRegistration.this, LoginRegister.class);
                            startActivity(intent);



                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
//                                myPd_ring.dismiss();
                            if (error instanceof NetworkError) {
                                Toast.makeText(UserRegistration.this, "Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
                            } else if (error instanceof ServerError) {
                                Toast.makeText(UserRegistration.this, "The server could not be found. Please try again after some time!!", Toast.LENGTH_LONG).show();
                            } else if (error instanceof AuthFailureError) {
                                Toast.makeText(UserRegistration.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                            } else if (error instanceof ParseError) {
                                Toast.makeText(UserRegistration.this, "Parsing error! Please try again after some time !!", Toast.LENGTH_LONG).show();

                            } else if (error instanceof NoConnectionError) {
                                Toast.makeText(UserRegistration.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                            } else if (error instanceof TimeoutError) {
                                Toast.makeText(UserRegistration.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                            }
                            // counter++;
                        }

                        {

                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> parameters = new HashMap<String, String>();
                            parameters.put("user_name", email_id.getText().toString());
                            parameters.put("user_phone", phone_no.getText().toString());
                            parameters.put("user_address", address.getText().toString());
                            parameters.put("user_password", password.getText().toString());




                            return parameters;
                        }
                    };
                    requestQueue.add(request);



                }

            }
        });

    }

    private boolean checkEmail(String email) {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
    }

    public final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9+._%-+]{1,256}" +
                    "@" +
                    "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" +
                    "(" +
                    "." +
                    "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" +
                    ")+"
    );


    private boolean isValidPassword(String pass)
    {
        if (pass != null && pass.length() > 4) {
            return true;
        }
        return false;

    }
}
