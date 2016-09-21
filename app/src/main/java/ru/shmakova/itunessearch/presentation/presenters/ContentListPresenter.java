package ru.shmakova.itunessearch.presentation.presenters;

import java.util.List;

import javax.inject.Inject;

import ru.shmakova.itunessearch.data.itunes.ItunesAppleService;
import ru.shmakova.itunessearch.data.itunes.models.Content;
import ru.shmakova.itunessearch.presentation.views.ContentListView;
import rx.Observable;


/**
 * Created by shmakova on 19.09.16.
 */

public class ContentListPresenter extends BaseRxPresenter<ContentListView, List<Content>> {

    private final ItunesAppleService itunesAppleService;
    private String currentTerm = "";

    @Inject
    public ContentListPresenter(ItunesAppleService itunesAppleService) {
        this.itunesAppleService = itunesAppleService;
    }

    public void loadContent(String term, boolean pullToRefresh) {
        currentTerm = term;
        Observable<List<Content>> observable =
                itunesAppleService
                        .getContent(term)
                        .map(contentResponse -> contentResponse.contentList());
        subscribe(observable, pullToRefresh);
    }

    public void loadContent(boolean pullToRefresh) {
        loadContent(currentTerm, pullToRefresh);
    }

    protected void onNext(List<Content> data) {
        if (isViewAttached()) {
            if (data.isEmpty()) {
                getView().showEmptyView();
            } else {
                getView().hideEmptyView();
            }

            getView().setData(data);
        }
    }
}
