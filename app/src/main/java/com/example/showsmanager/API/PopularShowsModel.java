package com.example.showsmanager.API;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PopularShowsModel {
    @SerializedName("results")
    private List<ResultShowsItem> results;


    public void setResults(List<ResultShowsItem> results) {
        this.results = results;
    }

    public List<ResultShowsItem> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return
                "NowPlayingModel{" +

                        ",results = '" + results + '\'' +

                        "}";
    }
}
