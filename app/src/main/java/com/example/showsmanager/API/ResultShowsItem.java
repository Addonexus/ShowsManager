package com.example.showsmanager.API;

import android.database.Cursor;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultShowsItem {

    @SerializedName("name")
    private String name;

    @SerializedName("original_name")
    private String originaName;

    @SerializedName("popularity")
    private double popularity;

//    @SerializedName("origin_country")
//    private String originCountry;
//
//    @SerializedName("original_language")
//    private String originalLanguage;

    @SerializedName("vote_count")
    private double voteCount;

    @SerializedName("vote_average")
    private double voteAverage;

    @SerializedName("genre_ids")
    private List<Integer> genreIds;

    @SerializedName("first_air_date")
    private String firstAirDate;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("overview")
    private String overview;

    @SerializedName("id")
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginaName() {
        return originaName;
    }

    public void setOriginaName(String originaName) {
        this.originaName = originaName;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

//    public String getOriginCountry() {
//        return originCountry;
//    }
//
//    public void setOriginCountry(String originCountry) {
//        this.originCountry = originCountry;
//    }
//
//    public String getOriginalLanguage() {
//        return originalLanguage;
//    }
//
//    public void setOriginalLanguage(String originalLanguage) {
//        this.originalLanguage = originalLanguage;
//    }

    public double getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(double voteCount) {
        this.voteCount = voteCount;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ResultShowsItem() {
    }


    @Override
    public String toString() {
        return "ResultShowsItem{" +
                "name='" + name + '\'' +
                ", originaName='" + originaName + '\'' +
                ", popularity=" + popularity +
//                ", originCountry='" + originCountry + '\'' +
//                ", originalLanguage='" + originalLanguage + '\'' +
                ", voteCount=" + voteCount +
                ", voteAverage=" + voteAverage +
                ", genreIds=" + genreIds +
                ", firstAirDate='" + firstAirDate + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", backdropPath='" + backdropPath + '\'' +
                ", overview='" + overview + '\'' +
                ", id=" + id +
                '}';
    }
}
