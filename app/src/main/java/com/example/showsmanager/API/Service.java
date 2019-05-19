package com.example.showsmanager.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Service {
//    @GET("/tv/{tv_id}/season/{season_number}")
//    Call<SeasonShowModel> getDetailSeasonFromShow(@Path("tv_id") String tv_id, @Path("season_number") String season_number, @Query("language") String language);
//
//    @GET("tv/{tv_id}")
//    Call<ModelDetail> getDetailShow(@Path("tv_id") String tv_id, @Query("language") String language);


    //serive call to the API to get all of the most popular tv shows currently in the database
    @GET("tv/popular")
    Call<PopularShowsModel> getPopularShows(@Query("api_key") String apiKey);

    //service call to the API to get the show details of the specific show if provided
    @GET("tv/{tv_id}")
    Call<ShowsDetailsModel> getDetailsAboutShow(@Path("tv_id") String tv_id);

    @GET("tv/{tv_id}/season/{season_number}")
    Call<SeasonDetailsModel> getSeasonDetailsFromShow(@Path("tv_id") String tv_id,@Path("season_number") String season_number,@Query("api_key") String apiKey);



//    @GET("search/tv")
//    Call<SearchModel> getSearchShow(@Query("query") String query, @Query("language") String language);
}
