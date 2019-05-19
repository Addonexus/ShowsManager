package com.example.showsmanager.API;

import com.example.showsmanager.SeasonsModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SeasonDetailsModel {

    @SerializedName("id")
    private int id;

    @SerializedName("air_date")
    private String airDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public double getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(double voteCount) {
        this.voteCount = voteCount;
    }

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("vote_count")
    private double voteCount;

    @SerializedName("results")
    private List<SeasonsModel> results;


    public void setResults(List<SeasonsModel> results) {
        this.results = results;
    }

    public List<SeasonsModel> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return
                "SeasonDetailsModel{" +

                        ",results = '" + results + '\'' +

                        "}";
    }



}
