package com.whiwol.petagram.restApi;

import com.whiwol.petagram.Cuenta;

/**
 * Created by Jmdra on 07/07/2016.
 */
public final class ConstantesRestApi {
    //https://api.instagram.com/v1/
    public static final String VERSION                     = "/v1/";
    public static final String ROOT_URL                    = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN                = "3505167991.e73f581.fca132de72c5481e9cfe4592b3720843";
    public static final String KEY_ACCESS_TOKEN            = "?access_token=";

    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN
    public static final String KEY_GET_RECENT_MEDIA_USER   = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER   = KEY_GET_RECENT_MEDIA_USER+KEY_ACCESS_TOKEN+ACCESS_TOKEN;

    //https://api.instagram.com/v1/users/{user-id}/media/recent/?access_token=ACCESS-TOKEN
    public static final String KEY_GET_RECENT_MEDIA_USER_ID = "users/{id}/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER_ID = KEY_GET_RECENT_MEDIA_USER_ID + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    public static final String KEY_SEARCH_USER = "users/search";
    public static final String URL_SEARCH_USER = KEY_SEARCH_USER;

    //https://api.instagram.com/v1/users/self/follows?access_token=3505167991.e73f581.fca132de72c5481e9cfe4592b3720843
    public static final String KEY_USER_FOLLOWS = "users/self/follows";
    public static final String URL_USER_FOLLOWS = KEY_USER_FOLLOWS;




}
