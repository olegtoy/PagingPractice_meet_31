package com.practice.olegtojgildin.paging;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PixableApi {

    @GET("api/")
    Call<ResponsePixabay> getImage(
            @Query("key") String key,
            @Query("q") String q,
            @Query("lang") String lang,
            @Query("image_type") String image_type,
            @Query("page") long page,
            @Query("per_page") int pageSize
    );
}
