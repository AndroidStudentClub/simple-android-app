package ru.mikhailskiy.simplemovieapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstFragment extends Fragment {

    MovieApiInterface apiInterface;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.movies);

        getMovies();


    }

    void getMovies() {
        apiInterface = ApiClient.getClient().create(MovieApiInterface.class);
        apiInterface.getTopRatedMovies(apiKey, "ru").enqueue(
                new Callback<MovieResponse>() {
                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                        Log.d("TEST", response.body().toString());
                        MoviesAdapter adapter = new MoviesAdapter(response.body().results);
                        // Attach the adapter to the recyclerview to populate items
                        recyclerView.setAdapter(adapter);
                        // Set layout manager to position the items
                        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {
                        Log.d("TEST", t.toString());
                    }
                }
        );
    }

    void moveToDetails() {
        NavHostFragment.findNavController(FirstFragment.this)
                .navigate(R.id.action_FirstFragment_to_SecondFragment);
    }


    String apiKey = "0bd95c30f721d1e94381142dc1ce3d50";
}
