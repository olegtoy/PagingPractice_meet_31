package com.practice.olegtojgildin.paging;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDataSource extends PageKeyedDataSource<Integer, Hit> {

    private static final int FIRST_PAGE = 1;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Hit> callback) {

        RetrofitClient.getInsance()
                .getApi()
                .getImage(ApiParams.KEY, ApiParams.API_QUERY, ApiParams.LANG, ApiParams.API_IMAGE_TYPE, ApiParams.PAGE, ApiParams.API_IMAGES_PER_PAGE)
                .enqueue(new Callback<ResponsePixabay>() {
                    @Override
                    public void onResponse(Call<ResponsePixabay> call, Response<ResponsePixabay> response) {
                        if (response.body() != null) {
                            callback.onResult(response.body().getImageHits(), null, FIRST_PAGE + 1);
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponsePixabay> call, Throwable t) {
                        Log.d("fail", "onnFailure111");
                    }
                });

    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Hit> callback) {

        RetrofitClient.getInsance()
                .getApi()
                .getImage(ApiParams.KEY, ApiParams.API_QUERY, ApiParams.LANG, ApiParams.API_IMAGE_TYPE, ApiParams.PAGE, ApiParams.API_IMAGES_PER_PAGE)
                .enqueue(new Callback<ResponsePixabay>() {
                    @Override
                    public void onResponse(Call<ResponsePixabay> call, Response<ResponsePixabay> response) {


                        if (response.body() != null) {
                            Integer key = (params.key > 1) ? params.key - 1 : null;
                            callback.onResult(response.body().getImageHits(), key);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponsePixabay> call, Throwable t) {
                        Log.d("fail", "onnFailure222");

                    }
                });

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Hit> callback) {

        RetrofitClient.getInsance()
                .getApi()
                .getImage(ApiParams.KEY, ApiParams.API_QUERY, ApiParams.LANG, ApiParams.API_IMAGE_TYPE, ApiParams.PAGE, ApiParams.API_IMAGES_PER_PAGE)
                .enqueue(new Callback<ResponsePixabay>() {
                    @Override
                    public void onResponse(Call<ResponsePixabay> call, Response<ResponsePixabay> response) {
                        if (response.body() != null) {
                            Integer key = (params.key < response.body().getTotalHits()) ? params.key + 1 : null;
                            callback.onResult(response.body().getImageHits(), key);
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponsePixabay> call, Throwable t) {
                        Log.d("fail", "onnFailure");

                    }
                });


    }
}
