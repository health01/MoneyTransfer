package com.example.moneytransfer.util.network.callback;

import android.content.Context;
import android.os.Handler;


import com.example.moneytransfer.util.app.ConfigKeys;
import com.example.moneytransfer.util.app.AppController;
import com.example.moneytransfer.util.log.KstLogger;
import com.example.moneytransfer.util.network.RestCreator;
import com.example.moneytransfer.util.ui.loader.avlLoader.KstLoader;
import com.example.moneytransfer.util.ui.loader.avlLoader.LoaderStyle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sai on 2017/9/27.
 */

public class RequestCallbacks implements Callback<String> {
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final LoaderStyle LOADER_STYLE;
    private static final Handler HANDLER = AppController.INSTANCE.getHandler();
    private static Context context = AppController.INSTANCE.getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    private final long delayed = AppController.INSTANCE.getConfiguration(ConfigKeys.LOADER_DELAYED);

    public RequestCallbacks(IRequest request, ISuccess success, IFailure failure, IError error, LoaderStyle style) {
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.LOADER_STYLE = style;


/*        if (!NetworkUtils.isConnected()) {
            if (this.ERROR != null) {

                BasicResponseModel br = new BasicResponseModel();
                br.setCode(ErrorType.NETWORK_FAILED.getValue());
                this.ERROR.onError(ErrorType.NETWORK_FAILED.getValue(), br.toString());
//                this.SUCCESS.onSuccess(br.toString());
                RestCreator.getParams().clear();
                KstLogger.d("請求錯誤Nework", !NetworkUtils.isConnected());
            }
        }*/


    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        KstLogger.d("原始數據", response + "\n body = " + response.body());

        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (SUCCESS != null) {
                    SUCCESS.onSuccess(response.body());

                }
            }
        } else {
            if (ERROR != null) {
                ERROR.onError(response.code(), response.message());
            }
        }

        onRequestFinish();
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if (FAILURE != null) {
            FAILURE.onFailure(t);
        }
        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }

        KstLogger.d("請求錯誤", t.getMessage());
        onRequestFinish();
    }

    private void onRequestFinish() {

        stopAvlLoader();

        RestCreator.getParams().clear();

    }

    private void stopAvlLoader() {
        if (LOADER_STYLE != null) {

            HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                    RestCreator.getParams().clear();
//                    KstLoader.stopLoading();
                }
            }, delayed);
        }
    }
}



