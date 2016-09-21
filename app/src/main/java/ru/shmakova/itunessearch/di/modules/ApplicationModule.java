package ru.shmakova.itunessearch.di.modules;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.shmakova.itunessearch.utils.ErrorMessageDeterminer;

/**
 * Created by shmakova on 20.09.16.
 */

@Module
public class ApplicationModule {
    @NonNull
    private final Application application;

    public ApplicationModule(@NonNull Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public ErrorMessageDeterminer providesErrorMessageDeterminer() {
        return new ErrorMessageDeterminer();
    }

    @Provides
    @NonNull
    @Singleton
    public Application provideApp() {
        return application;
    }
}
