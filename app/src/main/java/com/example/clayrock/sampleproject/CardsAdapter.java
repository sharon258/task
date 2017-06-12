package com.example.clayrock.sampleproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by clayrock on 13/6/17.
 */

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.MyViewHolder> {

    private List<Movie> moviesLis;

    private  Context context;

    public CardsAdapter(Context context, List<Movie> moviesLis) {
        this.moviesLis=moviesLis;
        this.context = context;
    }

    @Override
    public CardsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CardsAdapter.MyViewHolder holder, int position) {
        Movie movie = moviesLis.get(position);
        holder.text1.setText(movie.getText1());
        holder.text2.setText(movie.getText2());
        holder.text3.setText(movie.getText3());
        holder.imageView.setImageDrawable(context.getResources().getDrawable(movie.getImage()));

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView text1,text2,text3;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.image);
            text1=(TextView)itemView.findViewById(R.id.text1);
            text2=(TextView)itemView.findViewById(R.id.text2);
            text3=(TextView)itemView.findViewById(R.id.text3);
        }
    }
}

