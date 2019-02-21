package com.example.moneytransfer.util.storage;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

//import com.google.gson.Gson;
import com.example.moneytransfer.util.app.AppController;
import com.google.gson.Gson;

public class KstPreferencesHelper {

    private static final SharedPreferences PREFERENCES =
            PreferenceManager.getDefaultSharedPreferences(AppController.INSTANCE.getApplication());

    private static final String APP_PREFERENCES_KEY = "profile";

    private static SharedPreferences getAppPreference() {
        return PREFERENCES;
    }

    public static void setAppProfile(String val) {
        getAppPreference()
                .edit()
                .putString(APP_PREFERENCES_KEY, val)
                .apply();
    }

    public static String getAppProfile() {
        return getAppPreference().getString(APP_PREFERENCES_KEY, null);
    }

    public static String getAppProfileJson() {
        final String profile = getAppProfile();
        return new Gson().toJson(profile);
    }

    public static void removeAppProfile() {
        getAppPreference()
                .edit()
                .remove(APP_PREFERENCES_KEY)
                .apply();
    }


    public static void clearAppPreferences() {
        getAppPreference()
                .edit()
                .clear()
                .apply();
    }

    public static void setAppFlag(String key, boolean flag) {
        getAppPreference()
                .edit()
                .putBoolean(key, flag)
                .apply();
    }

    public static boolean getAppFlag(String key) {
        return getAppPreference()
                .getBoolean(key, false);
    }

    public static void removeAppFlag(String key) {
        getAppPreference()
                .edit()
                .remove(key)
                .apply();
    }

    public static void addCustomAppProfile(String key, String val) {
        getAppPreference()
                .edit()
                .putString(key, val)
                .apply();
    }

    public static String getCustomAppProfile(String key) {
        return getAppPreference().getString(key, "");
    }
}
