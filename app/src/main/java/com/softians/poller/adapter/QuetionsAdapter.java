package com.softians.poller.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.softians.poller.R;
import com.softians.poller.model.QuetiosData;

import java.util.List;

/**
 * Created by HP on 26-08-2017.
 */

public class QuetionsAdapter extends RecyclerView.Adapter<QuetionsAdapter.MyViewHolder> {

    private List<QuetiosData> moviesList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        CheckBox mOtherscheckBox;
        TextView  AnswereditText;

        public MyViewHolder(View view) {
            super(view);
//            mOtherscheckBox = (CheckBox) view.findViewById(R.id.otherscheckbox);
//            title = (TextView) view.findViewById(R.id.title);
//            genre = (TextView) view.findViewById(R.id.genre);
//            year = (TextView) view.findViewById(R.id.year);
        //    AnswereditText=(TextView)view.findViewById(R.id.edittext_answer) ;



        }
    }


    public QuetionsAdapter(List<QuetiosData> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        QuetiosData movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());

        holder.mOtherscheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    holder.AnswereditText.setVisibility(View.VISIBLE);

                }
                else {
                    holder.AnswereditText.setVisibility(View.GONE);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}