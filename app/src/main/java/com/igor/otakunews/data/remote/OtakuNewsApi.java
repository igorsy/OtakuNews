package com.igor.otakunews.data.remote;

import com.igor.otakunews.domain.News;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface OtakuNewsApi {
    @GET("news.json")
    Call<List<News>> getNews();}
