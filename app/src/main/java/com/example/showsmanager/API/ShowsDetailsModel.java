package com.example.showsmanager.API;

import com.google.gson.annotations.SerializedName;

public class ShowsDetailsModel {
    @SerializedName("id")
    private int id;

    @SerializedName("first_air_date")
    private String firstAirDate;

    @SerializedName("last_air_date")
    private String lastAirDate;

    @SerializedName("number_of_episodes")
    private int totalEpisodes;

    @SerializedName("number_of_seasons")
    private int totalSeasons;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public String getLastAirDate() {
        return lastAirDate;
    }

    public void setLastAirDate(String lastAirDate) {
        this.lastAirDate = lastAirDate;
    }

    public int getTotalEpisodes() {
        return totalEpisodes;
    }

    public void setTotalEpisodes(int totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
    }

    public int getTotalSeasons() {
        return totalSeasons;
    }

    public void setTotalSeasons(int totalSeasons) {
        this.totalSeasons = totalSeasons;
    }

    @Override
    public String toString() {
        return "ShowsDetailsModel{" +
                "id=" + id +
                ", firstAirDate='" + firstAirDate + '\'' +
                ", lastAirDate='" + lastAirDate + '\'' +
                ", totalEpisodes=" + totalEpisodes +
                ", totalSeasons=" + totalSeasons +
                '}';
    }
}
