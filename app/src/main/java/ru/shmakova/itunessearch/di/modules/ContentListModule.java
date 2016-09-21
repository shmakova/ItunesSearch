package ru.shmakova.itunessearch.di.modules;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;
import ru.shmakova.itunessearch.data.itunes.ItunesAppleService;
import ru.shmakova.itunessearch.presentation.presenters.ContentListPresenter;

/**
 * Created by shmakova on 21.09.16.
 */


@Module
public class ContentListModule {
    @Provides
    @NonNull
    public ContentListPresenter provideSchoolsPresenter(@NonNull ItunesAppleService itunesAppleService) {
        return new ContentListPresenter(itunesAppleService);
    }
}
