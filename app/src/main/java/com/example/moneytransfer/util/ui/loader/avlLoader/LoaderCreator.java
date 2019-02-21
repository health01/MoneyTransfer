package com.example.moneytransfer.util.ui.loader.avlLoader;



/**
 * Created by sai on 28/9/2017.
 */
public final class LoaderCreator {

    //Indicator is a Drawable implements Animatable
//    private static final WeakHashMap<String, Indicator> LOADING_MAP = new WeakHashMap<>();
//
//    static AVLoadingIndicatorView create(String type, Context context) {
//        final AVLoadingIndicatorView avLoadingIndicatorView = new AVLoadingIndicatorView(context);
//        if (LOADING_MAP.get(type) == null) {
//            final Indicator indicator = getIndicator(type);
//            LOADING_MAP.put(type, indicator);
//            avLoadingIndicatorView.setIndicator(LOADING_MAP.get(type));
//        }
//        return avLoadingIndicatorView;
//    }
//
//    private static Indicator getIndicator(String name) {
//        if (name == null || name.isEmpty()) {
//            return null;
//        }
//
//        final StringBuilder drawableClassName = new StringBuilder();
//        if (!name.contains(".")) {
//            final String defaultPackageName = AVLoadingIndicatorView.class.getPackage().getName();
//            drawableClassName.append(defaultPackageName)
//                    .append(".indicators")
//                    .append(".");
//        }
//        drawableClassName.append(name);
//
//        try {
//            Class<?> drawableClass = Class.forName(drawableClassName.toString());
//            return (Indicator) drawableClass.newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
