package com.example.moneytransfer.util.ui.loader.avlLoader;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;


import java.util.ArrayList;

/**
 * Created by sai on 28/9/2017.
 */

public class KstLoader {

//    private static final int LOADER_SIZE_SCALE = 8;
//    private static final int LOADER_OFFSET_SCALE = 10;
//
//    private static final ArrayList<AppCompatDialog> LOADERS = new ArrayList<>();
//
//    private static final String DEFAULT_LOADER = LoaderStyle.BallClipRotatePulseIndicator.name();
//
//    public static void showLoading(Context context, Enum<LoaderStyle> type) {
//        showLoading(context, type.name());
//    }
//
//    public static void showLoading(Context context, String type) {
//
//        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);
//        //AVLoadingIndicatorView is a View
//        final AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreator.create(type, context);
//        dialog.setContentView(avLoadingIndicatorView);
//        dialog.setCanceledOnTouchOutside(false);
//
//        int deviceWidth = DimenUtil.getScreenWidth();
//        int deviceHeight = DimenUtil.getScreenHeight();
//
//        final Window dialogWindow = dialog.getWindow();
//
//        if (dialogWindow != null) {
//            final WindowManager.LayoutParams lp = dialogWindow.getAttributes();
//            lp.width = deviceWidth / LOADER_SIZE_SCALE;
//            lp.height = deviceHeight / LOADER_SIZE_SCALE;
//            lp.height = lp.height + deviceHeight / LOADER_OFFSET_SCALE;
//            lp.gravity = Gravity.CENTER_VERTICAL;
//        }
//        LOADERS.add(dialog);
//        dialog.show();
//    }
//
//    public static void showLoading(Context context) {
//        if (context != null) {
//            showLoading(context, DEFAULT_LOADER);
//        }
//    }
//
//    public static void stopLoading() {
//        for (AppCompatDialog dialog : LOADERS) {
//            if (dialog != null) {
//                if (dialog.isShowing()) {
//                    dialog.cancel();
//                }
//            }
//        }
//    }


}
