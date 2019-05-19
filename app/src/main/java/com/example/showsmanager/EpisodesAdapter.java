package com.example.showsmanager;

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

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

class EpisodesAdapter  extends RecyclerView.Adapter<EpisodesAdapter.EpisodeViewHolder> {
    private List<EpisodesModel> list = new ArrayList<>();
    @Override
    public EpisodeViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.episode_item, viewGroup, false);
        return new EpisodeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EpisodeViewHolder holder, int position) {

        holder.bind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void replaceAll(List<EpisodesModel> items) {
        list.clear();
        list = items;
        notifyDataSetChanged();
    }

    public class EpisodeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.episode_image)
        ImageView episodeImage;

        @BindView(R.id.episode_title)
        TextView episodeTitle;

        @BindView(R.id.episode_first_aired)
        TextView episodeFirstAired;
        @BindView(R.id.episode_rating)
        TextView episodeRating;

        @BindView(R.id.episode_number)
        TextView episodeNumber;

        @BindView(R.id.episode_description)
        TextView episodeDescription;

        @BindView(R.id.episode_item)
        LinearLayout episodeItem;



        public EpisodeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final EpisodesModel item) {
            Log.d("EPISODE BIND", "bind: TRYING TO BIND STINGS");
            episodeTitle.setText(item.getName());
            episodeDescription.setText(item.getOverview());

            DecimalFormat df = new DecimalFormat("#.#");

            episodeRating.setText(String.valueOf(df.format(item.getVoteAverage())));
            episodeNumber.setText(String.valueOf(item.getEpisodeNumber()));

            episodeFirstAired.setText(String.valueOf(item.getAir_date()));
            Log.d("IMAGE URL", BuildConfig.BASE_URL_IMG +"w185" + item.getPosterPath());
            Glide.with(itemView.getContext())
                    .load(BuildConfig.BASE_URL_IMG + "w185" + item.getPosterPath())
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.image_not_avaliable)
                            .centerCrop()
                    )
                    .into(episodeImage);


            episodeItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
////                    intent.putExtra(DetailActivity.MOVIE_ITEM, new Gson().toJson(item));
////                    itemView.getContext().startActivity(intent);
                    Log.d("ITEM CLIECKED", "Season Episode WAS CLICKED " + item.getName());
//                    Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
//                    intent.putExtra(DetailActivity.SHOW_ITEM, new Gson().toJson(item));
//                    itemView.getContext().startActivity(intent);

                }
            });

        }
    }
}
