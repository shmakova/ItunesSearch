package ru.shmakova.itunessearch.data.itunes;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import ru.shmakova.itunessearch.data.itunes.models.Content;
import ru.shmakova.itunessearch.data.itunes.models.ContentResponse;

/**
 * Created by shmakova on 21.09.16.
 */

public class AutoValueGsonTypeAdapterFactory implements TypeAdapterFactory {

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        Class<? super T> rawType = type.getRawType();

        if (rawType.equals(ContentResponse.class)) {
            return (TypeAdapter<T>) ContentResponse.typeAdapter(gson);
        } else if (rawType.equals(Content.class)) {
            return (TypeAdapter<T>) Content.typeAdapter(gson);
        }

        return null;
    }
}