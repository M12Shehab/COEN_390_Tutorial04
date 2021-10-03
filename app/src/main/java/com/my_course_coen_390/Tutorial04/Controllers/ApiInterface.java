package com.my_course_coen_390.Tutorial04.Controllers;

import com.my_course_coen_390.Tutorial04.Models.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

// Convert JSON to Java
//https://www.jsonschema2pojo.org/

public interface ApiInterface {
//    @GET("data/2.5/weather")
//    Call<Weather> getWeather(@Query("q")String q, @Query("appid")String appid);

//    @GET("weather")
//    Call<ResponseBody> getWeather(@Query("q")String q, @Query("appid")String appid);
    @GET("data/2.5/weather")
    Call<Example> getWeather(@Query("q")String q, @Query("appid")String appid, @Query("units") String units);

}

