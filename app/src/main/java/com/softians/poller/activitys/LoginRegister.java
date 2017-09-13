package com.softians.poller.activitys;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
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
import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;
import com.softians.poller.Forgetpass;
import com.softians.poller.R;
import com.softians.poller.UserRegistration;
import com.softians.poller.Variables;
import com.softians.poller.links.Links;

import java.util.HashMap;
import java.util.Map;

import customfonts.MyEditText;
import customfonts.MyTextView;

public class LoginRegister extends AppCompatActivity {

    ImageView logoclick ;
    MyTextView signin,register;
    MyEditText userName,userPassword;
    TextView forgot;




    //*******************facebook lobin button***************

    LoginButton facebook_login_button;

    CallbackManager callbackmanager;
    //***********************Ends here**************************


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);

        callbackmanager.onActivityResult(requestCode,resultCode,data);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

//        if (Variables.splash == 0) {
//            setContentView(R.layout.splash2);
//            Variables.splash++;
//
//            new Handler().postDelayed(new Runnable() {
//
//            /*
//             * Showing splash screen with a timer. This will be useful when you
//             * want to show case your app logo / company
//             */
//
//                @Override
//                public void run() {
//                    // This method will be executed once the timer is over
//                    // Start your app main activity
////
//
//                    // close this activity
//
//
//                    Intent intent = new Intent(LoginRegister.this, LoginRegister.class);
//                    startActivity(intent);
//                }
//            }, 3000);
//
//        } else {


//        if (Variables.splash == 0) {
//            SystemClock.sleep(10000);
//            setTheme(R.style.AppTheme);
//            Variables.splash = 1;
//
//            Intent intent=new Intent(LoginRegister.this,LoginRegister.class);
//            startActivity(intent);
//        }


//        FacebookSdk.sdkInitialize(getApplicationContext());

            signin = (MyTextView) findViewById(R.id.sin);
            register = (MyTextView) findViewById(R.id.register);
           // logoclick = (ImageView) findViewById(R.id.onaddi);

            userName = (MyEditText) findViewById(R.id.usrtf);

            userPassword = (MyEditText) findViewById(R.id.pastf);

            forgot = (TextView) findViewById(R.id.forgot);


//        facebook_login_button= (LoginButton) findViewById(R.id.facebook_login_button);
            callbackmanager = CallbackManager.Factory.create();


//        facebook_login_button.registerCallback(callbackmanager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//
//                Intent ints = new Intent(LoginRegister.this,Tablay.class);
//                startActivity(ints);
//
//
//            }
//
//            @Override
//            public void onCancel() {
//
//            }
//
//            @Override
//            public void onError(FacebookException error) {
//
//            }
//        });


            //*************************CODE TO GET THE HASH KEY ******************************

//
//        try {
//            PackageInfo info = getPackageManager().getPackageInfo(
//                    "com.softians.poller",
//                    PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                String hashKey = new String(Base64.encode(md.digest(), 0));
//                // Log.i(TAG, "printHashKey() Hash Key: " + hashKey);
//                signin.setText(hashKey);
//                Log.d("samir",hashKey);
//                Toast.makeText(LoginRegister.this, hashKey, Toast.LENGTH_LONG).show();
//            }
//        } catch (NoSuchAlgorithmException e) {
//            // Log.e(TAG, "printHashKey()", e);
//            Toast.makeText(LoginRegister.this, "also exp", Toast.LENGTH_LONG).show();
//
//        } catch (Exception e) {
//            // Log.e(TAG, "printHashKey()", e);
//
//            Toast.makeText(LoginRegister.this, "exception", Toast.LENGTH_LONG).show();
//
//        }

//***************************Code Ends Here*************************************************

            forgot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginRegister.this, Forgetpass.class);
                    startActivity(intent);
                }
            });

            // printKeyHash(LoginRegister.this);
            signin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if (userName.getText().toString().trim().equals("")) {
                        userName.setError("Please Enter your Email");
                    }
                    if (userPassword.getText().toString().trim().equals("")) {
                        userPassword.setError("Please Enter Password");
                    } else {
                        login();
                    }


//                Intent ints = new Intent(LoginRegister.this,Tablay.class);
//                startActivity(ints);
                }
            });

            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent ints = new Intent(LoginRegister.this, UserRegistration.class);
                    startActivity(ints);
                }
            });

        }





//    public void printHashKey(Context pContext) {
//        try {
//            PackageInfo info = getPackageManager().getPackageInfo(
//                    "com.softians.poller",
//                    PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md = MessageDigest.getInstance("7B:B0:DB:9E:3B:E0:92:1C:E6:A6:2C:83:BE:47:35:21:46:6F:2C:BB");
//                md.update(signature.toByteArray());
//                String hashKey = new String(Base64.encode(md.digest(), 0));
//               // Log.i(TAG, "printHashKey() Hash Key: " + hashKey);
//
//                Toast.makeText(pContext, hashKey, Toast.LENGTH_LONG).show();
//            }
//        } catch (NoSuchAlgorithmException e) {
//           // Log.e(TAG, "printHashKey()", e);
//        } catch (Exception e) {
//           // Log.e(TAG, "printHashKey()", e);
//        }
//    }





//    public static String printKeyHash(Activity context) {
//        PackageInfo packageInfo;
//        String key = null;
//        try {
//            //getting application package name, as defined in manifest
//            String packageName = context.getApplicationContext().getPackageName();
//
//            //Retriving package info
//            packageInfo = context.getPackageManager().getPackageInfo(packageName,
//                    PackageManager.GET_SIGNATURES);
//
//            Log.e("Package Name=", context.getApplicationContext().getPackageName());
//
//            for (Signature signature : packageInfo.signatures) {
//                MessageDigest md = MessageDigest.getInstance("7B:B0:DB:9E:3B:E0:92:1C:E6:A6:2C:83:BE:47:35:21:46:6F:2C:BB");
//                md.update(signature.toByteArray());
//                key = new String(Base64.encode(md.digest(), 0));
//
//                Toast.makeText(context, key, Toast.LENGTH_SHORT).show();
//
//                // String key = new String(Base64.encodeBytes(md.digest()));
//                Log.e("Key Hash=", key);
//
//
//            }
//        } catch (PackageManager.NameNotFoundException e1) {
//            Log.e("Name not found", e1.toString());
//        }
//        catch (NoSuchAlgorithmException e) {
//            Log.e("No such an algorithm", e.toString());
//        } catch (Exception e) {
//            Log.e("Exception", e.toString());
//        }
//
//        return key;
//    }


    //***********************************************************************************
    public void login() {



        //*******************Volley for cheing validation ====================================
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Links.LOGIN,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        // myPd_ring.dismiss();
                        if(response.trim().equals("Login Successful"))
                        {


                            Variables.UserLogedin =userName.getText().toString();
                           // updatetoken();

                            Toast.makeText(LoginRegister.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(LoginRegister.this,Tablay.class);

                            startActivity(intent);


                        }
                        else
                        {
                            Toast.makeText(LoginRegister.this,"Please username or Password",Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        //  myPd_ring.dismiss();
                        if (error instanceof NetworkError)
                        {
                            Toast.makeText(LoginRegister.this,"Cannot connect to Internet...Please check your connection!",Toast.LENGTH_LONG ).show();
                        }
                        else if (error instanceof ServerError)
                        {
                            Toast.makeText(LoginRegister.this,"The server could not be found. Please try again after some time!!",Toast.LENGTH_LONG ).show();
                        }









                        else if (error instanceof AuthFailureError)
                        {
                            Toast.makeText(LoginRegister.this,"Cannot connect to Internet...Please check your connection !",Toast.LENGTH_LONG ).show();
                        }
                        else if (error instanceof ParseError)
                        {
                            Toast.makeText(LoginRegister.this,"Parsing error! Please try again after some time !!",Toast.LENGTH_LONG ).show();

                        }
                        else if (error instanceof NoConnectionError)
                        {
                            Toast.makeText(LoginRegister.this,"Cannot connect to Internet...Please check your connection !",Toast.LENGTH_LONG ).show();
                        }
                        else if (error instanceof TimeoutError)
                        {
                            Toast.makeText(LoginRegister.this,"Cannot connect to Internet...Please check your connection !",Toast.LENGTH_LONG ).show();
                        }

                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String,String> parameters  = new HashMap<String, String>();
                parameters.put("user_name",userName.getText().toString());
                parameters.put("user_password",userPassword.getText().toString());



                return parameters;
            }
        };

        RequestQueue requestQueue = com.android.volley.toolbox.Volley.newRequestQueue(LoginRegister.this);
        requestQueue.add(stringRequest);
        //******************Volley ends here****************************************
    }


    public void onBackPressed() {

        //super.onBackPressed();
        Log.d("back button", "back button pressed");
        AlertDialog.Builder ad1=new AlertDialog.Builder(this);
        ad1.setMessage("Do you want to exit ?");
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

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
                startActivity(intent);
                finish();
                System.exit(0);
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
