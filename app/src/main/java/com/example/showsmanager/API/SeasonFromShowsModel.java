package com.example.showsmanager.API;

import com.example.showsmanager.SeasonsModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SeasonFromShowsModel {

    @SerializedName("id")
    private int id;

    @SerializedName("air_date")
    private String airDate;

    @SerializedName("poster_path")
    private String posterPath;

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
                "SeasonFromShowsModel{" +

                        ",results = '" + results + '\'' +

                        "}";
    }



}
