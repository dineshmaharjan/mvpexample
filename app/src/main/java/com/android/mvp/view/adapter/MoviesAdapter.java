package com.android.mvp.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.mvp.R;
import com.android.mvp.entity.Movie;

import java.util.List;

/**
 * Created by Alucard on 10/20/2016.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviewViewHolder> {

    private List<Movie> movies;
    private int rowLayout;
    private Context context;

    public static class MoviewViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;

        public MoviewViewHolder(View itemView) {
            super(itemView);
            moviesLayout= (LinearLayout) itemView.findViewById(R.id.movies_layout);
            movieTitle= (TextView) itemView.findViewById(R.id.title);
            movieDescription= (TextView) itemView.findViewById(R.id.description);
            data= (TextView) itemView.findViewById(R.id.subtitle);
            rating= (TextView) itemView.findViewById(R.id.rating);

        }
    }

    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MoviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(rowLayout,parent,false);
        return new MoviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviewViewHolder holder, int position) {

        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.data.setText(movies.get(position).getReleaseDate());
        holder.movieDescription.setText(movies.get(position).getOverview());
        holder.rating.setText(movies.get(position).getVoteAverage().toString());

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


}
