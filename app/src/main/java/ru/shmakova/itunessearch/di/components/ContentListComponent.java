package ru.shmakova.itunessearch.di.components;

import android.support.annotation.NonNull;

import dagger.Subcomponent;
import ru.shmakova.itunessearch.di.modules.ContentListModule;
import ru.shmakova.itunessearch.di.scopes.PerFragment;
import ru.shmakova.itunessearch.presentation.presenters.ContentListPresenter;
import ru.shmakova.itunessearch.ui.fragments.ContentListFragment;

/**
 * Created by shmakova on 21.09.16.
 */

@PerFragment
@Subcomponent(modules = ContentListModule.class)
public interface ContentListComponent {
    void inject(@NonNull ContentListFragment contentListFragment);

    ContentListPresenter presenter();
}
