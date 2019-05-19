package com.example.showsmanager;

import com.google.gson.annotations.SerializedName;

public class EpisodesModel {

    @SerializedName("air_date")
    private String air_date;

    @SerializedName("id")
    private int id;

    @SerializedName("episode_number")
    private int episodeNumber;

    @SerializedName("still_path")
    private String posterPath;


    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("overview")
    private String overview;

    @SerializedName("name")
    private String name;

    @SerializedName("show_id")
    private int showId;

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EpisodesModel{" +
                "air_date='" + air_date + '\'' +
                ", id=" + id +
                ", episodeNumber=" + episodeNumber +
                ", posterPath='" + posterPath + '\'' +
                ", overview='" + overview + '\'' +
                ", name='" + name + '\'' +
                ", showId=" + showId +
                '}';
    }
}
