package com.softians.poller.activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
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
import com.softians.poller.DataModel;
import com.softians.poller.DrawerItemCustomAdapter;
import com.softians.poller.R;
import com.softians.poller.adapter.QuetionsAdapter;
import com.softians.poller.fragments.ConnectFragment;
import com.softians.poller.fragments.FixturesFragment;
import com.softians.poller.fragments.TableFragment;
import com.softians.poller.links.Links;
import com.softians.poller.model.QuetiosData;

import java.util.ArrayList;
import java.util.List;

public class QuetionActivity extends AppCompatActivity {



    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    Toolbar toolbar;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;



    //*************************************

    private List<QuetiosData> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private QuetionsAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quetion);


//****************************************************************
       // printHashKey(QuetionActivity.this);

ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        mTitle = mDrawerTitle = getTitle();

        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

       setupToolbar();

        DataModel[] drawerItem = new DataModel[3];
        drawerItem[0] = new DataModel(R.drawable.connect, "Connect");
        drawerItem[1] = new DataModel(R.drawable.fixtures, "Fixtures");
        drawerItem[2] = new DataModel(R.drawable.table, "Table");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);


        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();






        //*******************************************************

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new QuetionsAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }
    private void prepareMovieData() {


        //************************************Volley Starts here**************************

        //***************************Volley to get data from the server*******************
        StringRequest stringRequest841 = new StringRequest(Links.QUESTION, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {

                //  Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();

                  //  ParseJSON pj = new ParseJSON(response);
                   // pj.parseJSON();
                   // CustomList cl = new CustomList(this, ParseJSON.ids,ParseJSON.names,ParseJSON.emails,ParseJSON.ratings);
                   // listView.setAdapter(cl);

                    //QuetiosData movie = new QuetiosData(ParseJSON.question, ParseJSON.answer, ParseJSON.m_name);
                    //movieList.add(movie);


                    mAdapter.notifyDataSetChanged();





            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {

                        if (error instanceof NetworkError)
                        {
                            Toast.makeText(QuetionActivity.this,"Cannot connect to Internet...Please check your connection!",Toast.LENGTH_LONG ).show();
                        }
                        else if (error instanceof ServerError)
                        {
                            Toast.makeText(QuetionActivity.this,"The server could not be found. Please try again after some time!!",Toast.LENGTH_LONG ).show();
                        }
                        else if (error instanceof AuthFailureError)
                        {
                            Toast.makeText(QuetionActivity.this,"Cannot connect to Internet...Please check your connection !",Toast.LENGTH_LONG ).show();
                        }
                        else if (error instanceof ParseError)
                        {
                            Toast.makeText(QuetionActivity.this,"Parsing error! Please try again after some time !!",Toast.LENGTH_LONG ).show();

                        }
                        else if (error instanceof NoConnectionError)
                        {
                            Toast.makeText(QuetionActivity.this,"Cannot connect to Internet...Please check your connection !",Toast.LENGTH_LONG ).show();
                        }
                        else if (error instanceof TimeoutError)
                        {
                            Toast.makeText(QuetionActivity.this,"Cannot connect to Internet...Please check your connection !",Toast.LENGTH_LONG ).show();
                        }



                    }
                });
        RequestQueue requestQueue = com.android.volley.toolbox.Volley.newRequestQueue(QuetionActivity.this);
        requestQueue.add(stringRequest841);



        //******************************Volley Ends Here**************************


        //*********************Volley ends here*************************************************

//
//        QuetiosData movie = new QuetiosData("What is your Favourite Game ?", "Question : 1", "2015");
//        movieList.add(movie);
//
//        movie = new QuetiosData("What is your Favourite Food ?", "Question : 2", "2015");
//        movieList.add(movie);
//
//        movie = new QuetiosData("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
//        movieList.add(movie);
//
//        movie = new QuetiosData("Shaun the Sheep", "Animation", "2015");
//        movieList.add(movie);
//
//        movie = new QuetiosData("The Martian", "Science Fiction & Fantasy", "2015");
//        movieList.add(movie);
//
//        movie = new QuetiosData("Mission: Impossible Rogue Nation", "Action", "2015");
//        movieList.add(movie);
//
//        movie = new QuetiosData("Up", "Animation", "2009");
//        movieList.add(movie);
//
//        movie = new QuetiosData("Star Trek", "Science Fiction", "2009");
//        movieList.add(movie);
//
//        movie = new QuetiosData("The LEGO QuetiosData", "Animation", "2014");
//        movieList.add(movie);
//
//        movie = new QuetiosData("Iron Man", "Action & Adventure", "2008");
//        movieList.add(movie);
//
//        movie = new QuetiosData("Aliens", "Science Fiction", "1986");
//        movieList.add(movie);
//
//        movie = new QuetiosData("Chicken Run", "Animation", "2000");
//        movieList.add(movie);
//
//        movie = new QuetiosData("Back to the Future", "Science Fiction", "1985");
//        movieList.add(movie);
//
//        movie = new QuetiosData("Raiders of the Lost Ark", "Action & Adventure", "1981");
//        movieList.add(movie);
//
//        movie = new QuetiosData("Goldfinger", "Action & Adventure", "1965");
//        movieList.add(movie);
//
//        movie = new QuetiosData("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
//        movieList.add(movie);
//
//        mAdapter.notifyDataSetChanged();
    }



    //*******************************************

    void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
       //setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new ConnectFragment();
                break;
            case 1:
                fragment = new FixturesFragment();
                break;
            case 2:
                fragment = new TableFragment();
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }




}
