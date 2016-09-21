package ru.shmakova.itunessearch.ui.adapters;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hannesdorfmann.annotatedadapter.annotation.ViewField;
import com.hannesdorfmann.annotatedadapter.annotation.ViewType;
import com.hannesdorfmann.annotatedadapter.support.recyclerview.SupportAnnotatedAdapter;

import java.util.List;

import javax.inject.Inject;

import ru.shmakova.itunessearch.R;
import ru.shmakova.itunessearch.data.itunes.models.Content;

/**
 * Created by shmakova on 20.09.16.
 */

public class ContentListAdapter extends SupportAnnotatedAdapter implements ContentListAdapterBinder {
    private List<Content> contentList;

    @ViewType(
            layout = R.layout.item_content,
            views = {
                    @ViewField(id = R.id.cover_small, name = "cover_small", type = ImageView.class),
                    @ViewField(id = R.id.name, name = "name", type = TextView.class),
                    @ViewField(id = R.id.album, name = "album", type = TextView.class)
            }
    )
    public final int row = 0;

    @Inject
    public ContentListAdapter(Context context) {
        super(context);
    }

    @Override
    public int getItemCount() {
        return contentList == null ? 0 : contentList.size();
    }

    public List<Content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }

    @Override
    public void bindViewHolder(ContentListAdapterHolders.RowViewHolder vh, int position) {
        Content content = contentList.get(position);

        vh.name.setText(content.artistName());
        vh.album.setText(content.collectionName());

        Glide.with(vh.cover_small.getContext())
                .load(content.artworkUrl100())
                .placeholder(R.color.grey)
                .error(R.color.grey)
                .into(vh.cover_small);
    }
}
