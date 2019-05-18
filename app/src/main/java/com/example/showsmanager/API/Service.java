package com.example.showsmanager.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {
//    @GET("/tv/{tv_id}/season/{season_number}")
//    Call<SeasonShowModel> getDetailSeasonFromShow(@Path("tv_id") String tv_id, @Path("season_number") String season_number, @Query("language") String language);
//
//    @GET("tv/{tv_id}")
//    Call<ModelDetail> getDetailShow(@Path("tv_id") String tv_id, @Query("language") String language);

    @GET("tv/popular")
    Call<PopularShowsModel> getPopularShows(@Query("api_key") String apiKey);

//    @GET("search/tv")
//    Call<SearchModel> getSearchShow(@Query("query") String query, @Query("language") String language);
}
