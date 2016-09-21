package ru.shmakova.itunessearch.data.itunes.models;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by shmakova on 19.09.16.
 */

@AutoValue
public abstract class Content {
    @SerializedName("wrapperType")
    public abstract String wrapperType();

    @SerializedName("kind")
    public abstract String kind();

    @SerializedName("artistId")
    public abstract int artistId();

    @SerializedName("collectionId")
    public abstract int collectionId();

    @SerializedName("trackId")
    public abstract int trackId();

    @SerializedName("artistName")
    public abstract String artistName();

    @SerializedName("collectionName")
    public abstract String collectionName();

    @SerializedName("trackName")
    public abstract String trackName();

    @SerializedName("collectionCensoredName")
    public abstract String collectionCensoredName();

    @SerializedName("trackCensoredName")
    public abstract String trackCensoredName();

    @SerializedName("artistViewUrl")
    public abstract String artistViewUrl();

    @SerializedName("collectionViewUrl")
    public abstract String collectionViewUrl();

    @SerializedName("trackViewUrl")
    public abstract String trackViewUrl();

    @SerializedName("previewUrl")
    public abstract String previewUrl();

    @SerializedName("artworkUrl30")
    public abstract String artworkUrl30();

    @SerializedName("artworkUrl60")
    public abstract String artworkUrl60();

    @SerializedName("artworkUrl100")
    public abstract String artworkUrl100();

    @SerializedName("collectionPrice")
    public abstract float collectionPrice();

    @SerializedName("trackPrice")
    public abstract float trackPrice();

    @SerializedName("releaseDate")
    public abstract String releaseDate();

    @SerializedName("collectionExplicitness")
    public abstract String collectionExplicitness();

    @SerializedName("trackExplicitness")
    public abstract String trackExplicitness();

    @SerializedName("discCount")
    public abstract int discCount();

    @SerializedName("discNumber")
    public abstract int discNumber();

    @SerializedName("trackCount")
    public abstract int trackCount();

    @SerializedName("trackNumber")
    public abstract int trackNumber();

    @SerializedName("trackTimeMillis")
    public abstract int trackTimeMillis();

    @SerializedName("country")
    public abstract String country();

    @SerializedName("currency")
    public abstract String currency();

    @SerializedName("primaryGenreName")
    public abstract String primaryGenreName();

    @SerializedName("isStreamable")
    public abstract boolean isStreamable();

    public static Builder builder() {
        return new AutoValue_Content.Builder();
    }

    public static TypeAdapter<Content> typeAdapter(Gson gson) {
        return new AutoValue_Content.GsonTypeAdapter(gson);
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder wrapperType(String wrapperType);

        public abstract Builder kind(String kind);

        public abstract Builder artistId(int artistId);

        public abstract Builder collectionId(int collectionId);

        public abstract Builder trackId(int trackId);

        public abstract Builder artistName(String artistName);

        public abstract Builder collectionName(String collectionName);

        public abstract Builder trackName(String trackName);

        public abstract Builder collectionCensoredName(String collectionCensoredName);

        public abstract Builder trackCensoredName(String trackCensoredName);

        public abstract Builder artistViewUrl(String artistViewUrl);

        public abstract Builder collectionViewUrl(String collectionViewUrl);

        public abstract Builder trackViewUrl(String trackViewUrl);

        public abstract Builder previewUrl(String previewUrl);

        public abstract Builder artworkUrl30(String artworkUrl30);

        public abstract Builder artworkUrl60(String artworkUrl60);

        public abstract Builder artworkUrl100(String artworkUrl100);

        public abstract Builder collectionPrice(float collectionPrice);

        public abstract Builder trackPrice(float trackPrice);

        public abstract Builder releaseDate(String releaseDate);

        public abstract Builder collectionExplicitness(String collectionExplicitness);

        public abstract Builder trackExplicitness(String trackExplicitness);

        public abstract Builder discCount(int discCount);

        public abstract Builder discNumber(int discNumber);

        public abstract Builder trackCount(int trackCount);

        public abstract Builder trackNumber(int trackNumber);

        public abstract Builder trackTimeMillis(int trackTimeMillis);

        public abstract Builder country(String country);

        public abstract Builder currency(String currency);

        public abstract Builder primaryGenreName(String primaryGenreName);

        public abstract Builder isStreamable(boolean isStreamable);

        public abstract Content build();
    }
}
