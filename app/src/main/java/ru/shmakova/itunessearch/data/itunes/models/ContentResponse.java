package ru.shmakova.itunessearch.data.itunes.models;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shmakova on 20.09.16.
 */

@AutoValue
public abstract class ContentResponse {
    @SerializedName("resultCount")
    public abstract int resultCount();

    @SerializedName("results")
    public abstract List<Content> contentList();

    public static ContentResponse create(int resultCount, List<Content> contentList) {
        return new AutoValue_ContentResponse(resultCount, contentList);
    }

    public static TypeAdapter<ContentResponse> typeAdapter(Gson gson) {
        return new AutoValue_ContentResponse.GsonTypeAdapter(gson);
    }
}
