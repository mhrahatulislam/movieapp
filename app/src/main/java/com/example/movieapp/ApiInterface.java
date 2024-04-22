package com.example.movieapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("movies")
    Call<List<ModelClass>>getPost();
}
