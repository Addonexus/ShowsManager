package com.example.showsmanager;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import com.example.showsmanager.API.Client;
import com.example.showsmanager.API.PopularShowsModel;

import butterknife.BindView;
import butterknife.Unbinder;
import retrofit2.Call;

public class ShowSeasonsFragment extends Fragment {

    private Context context;
    private Unbinder unbinder;

    @BindView(R.id.view_seasons_of_show)
    RecyclerView viewSeasonsOfShow;


    private Call<PopularShowsModel> apiServiceCall;
    private Client client = new Client();
}
