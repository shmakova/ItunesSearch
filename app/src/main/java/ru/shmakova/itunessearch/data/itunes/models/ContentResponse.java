package ru.shmakova.itunessearch.data.itunes.models;

import com.google.auto.value.AutoValue;

import java.util.List;

/**
 * Created by shmakova on 20.09.16.
 */

@AutoValue
public abstract class ContentResponse {
    public abstract int resultCount();

    public abstract List<Content> contentList();

    public static ContentResponse create(int resultCount, List<Content> contentList) {
        return new AutoValue_ContentResponse(resultCount, contentList);
    }
}
