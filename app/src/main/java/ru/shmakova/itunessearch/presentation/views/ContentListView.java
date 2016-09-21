package ru.shmakova.itunessearch.presentation.views;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

import java.util.List;

import ru.shmakova.itunessearch.data.itunes.models.Content;

/**
 * Created by shmakova on 19.09.16.
 */

public interface ContentListView extends MvpLceView<List<Content>> {
    void showEmptyView();

    void hideEmptyView();
}
