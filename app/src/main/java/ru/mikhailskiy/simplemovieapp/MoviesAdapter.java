package ru.mikhailskiy.simplemovieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movieList;

    public MoviesAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_movie, parent, false);

        // Return a new holder instance
        MovieViewHolder viewHolder = new MovieViewHolder(contactView);
        return viewHolder;
    }

    // stores and recycles views as they are scrolled off screen
    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView movieTitle;
        TextView subtitle;
        TextView movieDescription;
        TextView rating;

        MovieViewHolder(View itemView) {
            super(itemView);
            movieTitle = itemView.findViewById(R.id.title);
            subtitle = itemView.findViewById(R.id.subtitle);

            movieDescription = itemView.findViewById(R.id.description);
            rating = itemView.findViewById(R.id.rating);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(MoviesAdapter.MovieViewHolder viewHolder, int position) {
        // Get the data model based on position
        Movie movie = movieList.get(position);

        viewHolder.movieTitle.setText(movie.title);
        viewHolder.subtitle.setText(movie.releaseDate);
        viewHolder.movieDescription.setText(movie.overview);
        viewHolder.rating.setText(Integer.toString(movie.voteCount));

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return movieList.size();
    }
}