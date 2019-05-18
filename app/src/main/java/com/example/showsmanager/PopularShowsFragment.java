package com.example.showsmanager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.showsmanager.API.Client;
import com.example.showsmanager.API.PopularShowsModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularShowsFragment extends Fragment {
    private Context context;
    private Unbinder unbinder;

    @BindView(R.id.view_popular_shows)
    RecyclerView view_popular_shows;

    private ShowsAdapter adapter;

    private Call<PopularShowsModel> apiServiceCall;
    private Client client = new Client();

    public PopularShowsFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.popular_shows_fragment, container, false);
        context = view.getContext();

        unbinder = ButterKnife.bind(this, view);

        setupList();
        Log.d("LOCATION", "I AM BEFORE LOADING DATA");
        loadData();
        Log.d("LOCATION", "I AM AFTER LOADING DATA");

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        if (apiServiceCall != null) apiServiceCall.cancel();
    }

    private void setupList() {
        adapter = new ShowsAdapter();
        view_popular_shows.setLayoutManager(new LinearLayoutManager(context));
        view_popular_shows.setAdapter(adapter);
    }

    private void loadData() {
        apiServiceCall = client.getService().getPopularShows(BuildConfig.API_KEY);
        Log.d("BEFORE QUEUEING", "WORKING" + apiServiceCall.toString());
        apiServiceCall.enqueue(new Callback<PopularShowsModel>() {


            @Override
            public void onResponse(Call<PopularShowsModel> call, Response<PopularShowsModel> response) {
                Log.d("RESPONSE", response.toString());
                if (response.isSuccessful()) {
                    adapter.replaceAll(response.body().getResults());
                } else loadFailed();
            }

            @Override
            public void onFailure(Call<PopularShowsModel> call, Throwable t) {
                t.printStackTrace();
                Log.d("FAILURE", "NOT WORKING TRIGGERED: " + call.toString() );
                loadFailed();
            }
        });
    }

    private void loadFailed() {
        Log.d("NOT WORKING", "AN ERROR OCCURED");
        Toast.makeText(context, "Loading Failed, or didn't work as intended", Toast.LENGTH_SHORT).show();
    }


}
