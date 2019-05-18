package com.example.showsmanager;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.showsmanager.API.ResultShowsItem;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowsAdapter extends RecyclerView.Adapter<ShowsAdapter.ShowViewHolder>  {
    private List<ResultShowsItem> list = new ArrayList<>();
    @NonNull
    @Override
    public ShowViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.show_item, viewGroup, false);
        return new ShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowViewHolder showViewHolder, int i) {
        showViewHolder.bind(list.get(i));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void replaceAll(List<ResultShowsItem> items) {
        list.clear();
        list = items;
        notifyDataSetChanged();
    }

    public class ShowViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.showImage)
        ImageView img_poster;

        @BindView(R.id.showTitle)
        TextView show_title;

        @BindView(R.id.show_first_aired)
        TextView show_first_aired;

        @BindView(R.id.showDescription)
        TextView show_overview;

        @BindView(R.id.showRating)
        TextView show_rating;


        @BindView(R.id.show_item)
        LinearLayout show_item;


        public ShowViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }



        public void bind(final ResultShowsItem item) {
            show_title.setText(item.getName());
            show_overview.setText(item.getOverview());
            show_first_aired.setText(item.getFirstAirDate());
            show_rating.setText(Double.toString(item.getVoteAverage()));
            Glide.with(itemView.getContext())
                    .load(BuildConfig.BASE_URL_IMG + "w154" + item.getPosterPath())
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.ic_launcher_background)
                            .centerCrop()
                    )
                    .into(img_poster);


            show_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
////                    intent.putExtra(DetailActivity.MOVIE_ITEM, new Gson().toJson(item));
////                    itemView.getContext().startActivity(intent);
                    Log.d("ITEM CLIECKED", "TV SHOW WAS CLICKED" + item.getName());
                }
            });


        }
    }
}
