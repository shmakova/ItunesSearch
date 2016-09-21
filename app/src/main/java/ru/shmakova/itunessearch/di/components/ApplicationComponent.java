package ru.shmakova.itunessearch.di.components;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Component;
import ru.shmakova.itunessearch.di.modules.ApplicationModule;
import ru.shmakova.itunessearch.di.modules.ContentListModule;
import ru.shmakova.itunessearch.di.modules.NetworkModule;
import ru.shmakova.itunessearch.ui.activities.MainActivity;

/**
 * Created by shmakova on 20.09.16.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        NetworkModule.class
})
public interface ApplicationComponent {
    @NonNull
    ContentListComponent plus(ContentListModule module);

    void inject(@NonNull MainActivity mainActivity);
}
