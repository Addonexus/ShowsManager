package com.example.showsmanager;

import com.google.gson.annotations.SerializedName;

public class SeasonsModel {

    @SerializedName("air_date")
    private String air_date;

    @SerializedName("id")
    private int id;

    @SerializedName("episode_count")
    private int episodeCount;

    @SerializedName("season_number")
    private int seasonNumber;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("overview")
    private String overview;

    @SerializedName("name")
    private String name;

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEpisodeCount() {
        return episodeCount;
    }

    public void setEpisodeCount(int episodeCount) {
        this.episodeCount = episodeCount;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
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
        return "SeasonsModel{" +
                "air_date='" + air_date + '\'' +
                ", id=" + id +
                ", episodeCount=" + episodeCount +
                ", seasonNumber=" + seasonNumber +
                ", posterPath='" + posterPath + '\'' +
                ", overview='" + overview + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
