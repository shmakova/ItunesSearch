package ru.shmakova.itunessearch.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import ru.shmakova.itunessearch.App;
import ru.shmakova.itunessearch.R;
import ru.shmakova.itunessearch.data.itunes.models.Content;
import ru.shmakova.itunessearch.di.components.ContentListComponent;
import ru.shmakova.itunessearch.di.modules.ContentListModule;
import ru.shmakova.itunessearch.presentation.presenters.ContentListPresenter;
import ru.shmakova.itunessearch.presentation.views.ContentListView;
import ru.shmakova.itunessearch.ui.adapters.ContentListAdapter;
import ru.shmakova.itunessearch.utils.ErrorMessageDeterminer;

/**
 * Created by shmakova on 19.09.16.
 */

public class ContentListFragment
        extends BaseLceFragment<SwipeRefreshLayout, List<Content>, ContentListView, ContentListPresenter>
        implements ContentListView, SwipeRefreshLayout.OnRefreshListener, FloatingSearchView.OnSearchListener {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.floating_search_view)
    FloatingSearchView floatingSearchView;
    @BindView(R.id.empty_favorites)
    View emptyView;

    @Inject
    ErrorMessageDeterminer errorMessageDeterminer;

    ContentListComponent contentListComponent;
    ContentListAdapter adapter;

    protected void injectDependencies() {
        contentListComponent =
                App.get(getContext()).applicationComponent().plus(new ContentListModule());
        contentListComponent.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        injectDependencies();
        return inflater.inflate(R.layout.fragment_content_list, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new ContentListAdapter(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        contentView.setOnRefreshListener(this);
        floatingSearchView.setOnSearchListener(this);
    }

    @Override
    public LceViewState<List<Content>, ContentListView> createViewState() {
        return new RetainingLceViewState<>();
    }

    @Override
    public List<Content> getData() {
        return adapter.getContentList();
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return errorMessageDeterminer.getErrorMessage(e, pullToRefresh);
    }

    @Override
    public ContentListPresenter createPresenter() {
        return contentListComponent.presenter();
    }

    @Override
    public void setData(List<Content> data) {
        adapter.setContentList(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        presenter.loadContent(pullToRefresh);
    }

    @Override
    public void onRefresh() {
        loadData(true);
    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {
        super.showError(e, pullToRefresh);
        contentView.setRefreshing(false);
        e.printStackTrace();
    }

    @Override
    public void showContent() {
        super.showContent();
        contentView.setRefreshing(false);
    }

    @Override
    public void showLoading(boolean pullToRefresh) {
        super.showLoading(pullToRefresh);
        if (pullToRefresh && !contentView.isRefreshing()) {
            contentView.post(() -> contentView.setRefreshing(true));
        }
    }

    @Override
    public void onSuggestionClicked(SearchSuggestion searchSuggestion) {
        // no suggestions
    }

    @Override
    public void onSearchAction(String currentQuery) {
        presenter.loadContent(currentQuery, true);
    }

    @Override
    public void showEmptyView() {
        contentView.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmptyView() {
        contentView.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
    }


}
