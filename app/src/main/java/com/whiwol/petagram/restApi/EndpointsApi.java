package com.whiwol.petagram.restApi;

import com.whiwol.petagram.restApi.model.FollowersResponse;
import com.whiwol.petagram.restApi.model.PerfilResponse;
import com.whiwol.petagram.restApi.model.SearchResponse;
import com.whiwol.petagram.restApi.model.TimelineResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Jmdra on 07/07/2016.
 */
public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER_ID)
    Call<PerfilResponse> getRecentMediaUserID(@Path("id") String id);

    @GET(ConstantesRestApi.URL_SEARCH_USER)
    Call<SearchResponse> getUsuarioBusqueda(@Query("q") String jack, @Query("access_token") String access_token);

    @GET(ConstantesRestApi.URL_USER_FOLLOWS)
    Call<FollowersResponse> getUsuarioFollows(@Query("access_token") String access_token);

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER_ID)
    Call<TimelineResponse> getRecentMediaTimeline(@Path("id") String id);

}
