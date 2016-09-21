package ru.shmakova.itunessearch.data.itunes;

import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.shmakova.itunessearch.data.itunes.models.ContentResponse;
import rx.Observable;
import rx.Single;

/**
 * Created by shmakova on 20.09.16.
 */

public interface ItunesAppleService {
    String BASE_URL = "https://itunes.apple.com/";

    @GET("search")
    Observable<ContentResponse> getContent(@Query("term") String term);
}
