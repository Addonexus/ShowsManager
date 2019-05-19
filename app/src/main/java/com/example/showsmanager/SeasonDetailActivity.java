package com.example.showsmanager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.showsmanager.API.Client;
import com.example.showsmanager.API.ResultShowsItem;
import com.example.showsmanager.API.SeasonDetailsModel;
import com.example.showsmanager.API.ShowsDetailsModel;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeasonDetailActivity extends AppCompatActivity {

    public static final String SEASON_ITEM = "season_item";
//    Binding views from appbar


    @BindView(R.id.toolbar)
    Toolbar toolbar;


//    Binding views from seasons_detail_info.xml
    @BindView(R.id.season_title)
    TextView seasonTitle;

    @BindView(R.id.season_img_poster)
    ImageView imgPoster;

    @BindView(R.id.season_first_aired)
    TextView seasonFirstAired;


    @BindView(R.id.season_number_of_episodes)
    TextView seasonNumberOfEpisodes;

    @BindView(R.id.season_overview)
    TextView seasonOverview;

    @BindView(R.id.season_toggle_watch)
    ImageView seasonToggleWatch;


//    Binding views from season_episodes_fragment
    @BindView(R.id.view_episodes_of_season)
    RecyclerView viewEpisodesOfSeason;


//  Getting service and client to class namespace
    private Call<SeasonDetailsModel> apiCall;
    private Client client = new Client();

    private Gson gson = new Gson();
    private SeasonsModel item;

    private Context context;
//    Adapter to show the episodes in RecyclerView
    private EpisodesAdapter adapter;

    private Boolean isFavorite = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season_detail);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        String json = getIntent().getStringExtra(SEASON_ITEM);
        item = gson.fromJson(json, SeasonsModel.class);
        loadData();
        setUpEpisodesRV();

        seasonToggleWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("CLIKED", view.toString() + " was clicked");
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (apiCall != null) apiCall.cancel();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setUpEpisodesRV() {
        Log.d("SETTING UP RV FOR EPI", "setUpEpisodesRV: setting ");
        adapter = new EpisodesAdapter();
        Log.d("SETTING UP RV FOR EPI", "setUpEpisodesRV: working ");
        viewEpisodesOfSeason.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        viewEpisodesOfSeason.setAdapter(adapter);
        Log.d("SETTING UP RV FOR EPI", "setUpEpisodesRV: worked ");

    }

//  method to get episodes to view
    private void loadDataFromServer(String seasonItem, String seasonNumber) {
        Log.d("BEFORE CALLING EPI", "" + seasonItem + " " + seasonNumber);
        apiCall = client.getService().getSeasonDetailsFromShow(seasonItem, seasonNumber);
        Log.d("BEFORE CALLING SERVICE", "this is woring");
        apiCall.enqueue(new Callback<SeasonDetailsModel>() {


            @Override
            public void onResponse(Call<SeasonDetailsModel> call, Response<SeasonDetailsModel> response) {
                Log.d("RESPONSE", response.toString());
                if (response.isSuccessful()) {
                    SeasonDetailsModel item = response.body();

                    Log.d("EPISODSE", " "+item.getResults());
//                    showsNumberOfSeasons.setText(String.valueOf(item.getTotalSeasons()));
                    adapter.replaceAll(response.body().getResults());

                }

            }

            @Override
            public void onFailure(Call<SeasonDetailsModel> call, Throwable t) {
                loadFailed();
                t.printStackTrace();
                Log.d("FAILURE", "onFailure: SOMETHING WENT WRONG WHEN CALLING FROM SERVER");

            }
        });
    }
    private void loadFailed() {

        Toast.makeText(this, "SOMETHING WENT WRONG LOADING THE SEASONS DETAILS", Toast.LENGTH_SHORT).show();
    }

    private void loadData() {

        loadDataFromServer(String.valueOf(item.getShowId()),String.valueOf(item.getSeasonNumber()));

        getSupportActionBar().setTitle((item.getName()));

        seasonTitle.setText(item.getName());


        Glide.with(this)
                .load(BuildConfig.BASE_URL_IMG + "w154" + item.getPosterPath())
                .apply(new RequestOptions()
                        .placeholder(R.drawable.image_not_avaliable)
                        .centerCrop())
                .into(imgPoster);

        seasonFirstAired.setText(item.getAir_date());
        seasonNumberOfEpisodes.setText(String.valueOf(item.getEpisodeCount()));

        if (item.getOverview().isEmpty()){
            seasonOverview.setText("No Season Description Found");
        }
        else{
            seasonOverview.setText(item.getOverview());
        }

    }
}
