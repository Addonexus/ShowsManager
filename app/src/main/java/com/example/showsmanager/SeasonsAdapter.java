package com.example.showsmanager;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.showsmanager.API.ResultShowsItem;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

class SeasonsAdapter extends RecyclerView.Adapter<SeasonsAdapter.SeasonViewHolder> {
    private List<SeasonsModel> list = new ArrayList<>();
    private int showId;

    public SeasonsAdapter(int id) {
        Log.d(TAG, "SeasonsAdapter: value of id passed " + id);
        showId = id;
    }

    @Override
    public SeasonViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.season_item, viewGroup, false);
        return new SeasonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SeasonViewHolder holder, int position) {
        holder.bind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void replaceAll(List<SeasonsModel> items) {
        list.clear();
        list = items;
        notifyDataSetChanged();
    }

    public class SeasonViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.show_season_image)
        ImageView seasonImage;

        @BindView(R.id.season_title)
        TextView seasonTitle;

        @BindView(R.id.season_episodes)
        TextView seasonEpisodes;

        @BindView(R.id.season_item)
        LinearLayout seasonItem;
        public SeasonViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        public void bind(final SeasonsModel item) {
            seasonTitle.setText(item.getName());
            seasonEpisodes.setText(String.valueOf(item.getEpisodeCount()));
            Glide.with(itemView.getContext())
                    .load(BuildConfig.BASE_URL_IMG + "w154" + item.getPosterPath())
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.image_not_avaliable)
                            .centerCrop()
                    )
                    .into(seasonImage);


            seasonItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
////                    intent.putExtra(DetailActivity.MOVIE_ITEM, new Gson().toJson(item));
////                    itemView.getContext().startActivity(intent);
                    Log.d("ITEM CLIECKED", "Season SHOW WAS CLICKED" + item.getName());
                    Intent intent = new Intent(itemView.getContext(), SeasonDetailActivity.class);
                    item.setShowId(showId);
                    intent.putExtra(SeasonDetailActivity.SEASON_ITEM, new Gson().toJson(item));


                    Log.d("BEFORE INTENT", "item id before passed into intent " + item.getShowId() + " " + showId);
                    itemView.getContext().startActivity(intent);

                }
            });

        }
    }
}
