package com.dever.qiubaiwork;

import com.dever.qiubaiwork.entity.Item;
import com.dever.qiubaiwork.entity.ItemInfo;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by admin on 2015/12/29.
 */
public interface QsService {
    @GET("article/list/{type}")
    Call<Item> getList(@Path("type")String type,@Query("page")int page);

    @GET("article/{id}")
    Call<ItemInfo> getInfo(@Path("id")String id);
}
