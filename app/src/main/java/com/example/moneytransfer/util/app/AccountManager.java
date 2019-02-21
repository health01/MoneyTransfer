package com.example.moneytransfer.util.app;


import com.example.moneytransfer.util.storage.KstPreferencesHelper;

/**
 * Created by Sai on 2017/12/5.
 */

public class AccountManager {
    private enum SignTag {
        SIGN_TAG,
        ID,
        TOKEN,
        AUTH,
        USER_DETAIL,
        MASTER_VER
    }

    //set SignState
    public static void setSignState(boolean state) {
        KstPreferencesHelper.setAppFlag(SignTag.SIGN_TAG.name(), state);
    }

    public static boolean isSignIn() {
        return KstPreferencesHelper.getAppFlag(SignTag.SIGN_TAG.name());
    }


    //setAuth
    public static void setAuth(String token) {
        KstPreferencesHelper.addCustomAppProfile(SignTag.AUTH.name(), token);
    }

    //setAuth
    public static String getAuth() {
//        KstPreferencesHelper.addCustomAppProfile(SignTag.TOKEN.name(), token);
        return KstPreferencesHelper.getCustomAppProfile(SignTag.AUTH.name());
    }


    //setAuth
    public static void setUserId(String id) {
        KstPreferencesHelper.addCustomAppProfile(SignTag.ID.name(), id);
    }

    //get user id
    public static String getUserId() {
        return KstPreferencesHelper.getCustomAppProfile(SignTag.ID.name());
    }

    //setUserDetail
    public static String getUserDetail() {
        return KstPreferencesHelper.getCustomAppProfile(SignTag.USER_DETAIL.name());
        //   var userinfoJson : String = SessionManager.instance.getPreferences(ChunWoConfig.KEY_User_Detail, String::class.java) as String
        //   var userinfo = Gson().fromJson(userinfoJson, UserModel::class.java)
    }

    //setUserDetail
    public static void setUserDetail(String userInfo) {
        KstPreferencesHelper.addCustomAppProfile(SignTag.USER_DETAIL.name(), userInfo);
    }


    //setMasterVersion
    public static String getMasterVersion() {
        return KstPreferencesHelper.getCustomAppProfile(SignTag.MASTER_VER.name());
    }

    //setMasterVersion
    public static void setMasterVersion(String masterVer) {
        KstPreferencesHelper.addCustomAppProfile(SignTag.MASTER_VER.name(), masterVer);
    }

    //clearAll
    public static void clearAll() {
        KstPreferencesHelper.clearAppPreferences();
    }

    public static void logoutWithClear() {
        KstPreferencesHelper.setAppFlag(SignTag.SIGN_TAG.name(), false);
        KstPreferencesHelper.removeAppFlag(SignTag.TOKEN.name());
    }




}
