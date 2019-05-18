package com.example.showsmanager;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.FragmentTransaction;
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
import com.example.showsmanager.API.Client;
import com.example.showsmanager.API.ResultShowsItem;
import com.example.showsmanager.API.ShowsDetailsModel;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    public static final String SHOW_ITEM = "show_item";


    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsing_toolbar;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.show_title)
    TextView showTitle;

    @BindView(R.id.img_backdrop)
    ImageView imgBackdrop;

    @BindView(R.id.img_poster)
    ImageView imgPoster;

    @BindView(R.id.show_first_aired)
    TextView showFirstAired;
    @BindView(R.id.show_rating)
    TextView showRating;


    @BindView(R.id.shows_number_of_seasons)
    TextView showsNumberOfSeasons;

    @BindView(R.id.show_overview)
    TextView showOverview;

    @BindView(R.id.show_rating_bar)
    RatingBar showRatingBar;

    @BindView(R.id.show_toggle_watch)
    ImageView showToggleWatch;

    @BindView(R.id.view_seasons_of_show)
    RecyclerView viewSeasonsOfShow;


    private Call<ShowsDetailsModel> apiCall;
    private Client client = new Client();

    private Gson gson = new Gson();
    private ResultShowsItem item;

    private Context context;
    private SeasonsAdapter adapter;

    private Boolean isFavorite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsing_toolbar.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

        String json = getIntent().getStringExtra(SHOW_ITEM);
        item = gson.fromJson(json, ResultShowsItem.class);
        loadData();
        setUpSeasonsRV();

        showToggleWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("CLIKED", view.toString() + " was clicked");
            }
        });

    }

    private void setUpSeasonsRV() {
        adapter = new SeasonsAdapter();
        viewSeasonsOfShow.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        viewSeasonsOfShow.setAdapter(adapter);

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
    private void loadData() {

        loadDataFromServer(String.valueOf(item.getId()));

        getSupportActionBar().setTitle(item.getName());
        showTitle.setText(item.getName());

        Glide.with(this)
                .load(BuildConfig.BASE_URL_IMG + "w342" + item.getBackdropPath())
                .into(imgBackdrop);

        Glide.with(this)
                .load(BuildConfig.BASE_URL_IMG + "w154" + item.getPosterPath())
                .into(imgPoster);

        showFirstAired.setText(item.getFirstAirDate());
        showRating.setText(String.valueOf(item.getVoteAverage()));
        showOverview.setText(item.getOverview());

        double userRating = item.getVoteAverage() / 2;
        showRatingBar.setRating((float)userRating);

    }

    private void loadDataFromServer(String show_item) {
        apiCall = client.getService().getDetailsAboutShow(show_item);
        apiCall.enqueue(new Callback<ShowsDetailsModel>() {

            @Override
            public void onResponse(Call<ShowsDetailsModel> call, Response<ShowsDetailsModel> response) {
                if (response.isSuccessful()) {
                    ShowsDetailsModel item = response.body();

                    Log.d("SEAONS", " "+item.getTotalSeasons());
                    showsNumberOfSeasons.setText(String.valueOf(item.getTotalSeasons()));
                    adapter.replaceAll(response.body().getSeasons());

                }

            }

            @Override
            public void onFailure(Call<ShowsDetailsModel> call, Throwable t) {
                loadFailed();

            }
        });
    }

    private void loadFailed() {
        Toast.makeText(this, "SOMETHING WENT WRONG LOADING THE DETAILS", Toast.LENGTH_SHORT).show();
    }


}
