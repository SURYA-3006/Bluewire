package com.onlinepatch.SmartShare.view;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.onlinepatch.SmartShare.R;
import com.onlinepatch.SmartShare.adapter.ImageListAdapter;
import com.onlinepatch.SmartShare.adapter.GroupEditableListFragment;
import com.onlinepatch.SmartShare.widget.GroupEditableListAdapter;

import java.util.Map;

abstract public class GalleryGroupEditableListFragment<T extends GroupEditableListAdapter.GroupShareable, V extends GroupEditableListAdapter.GroupViewHolder, E extends GroupEditableListAdapter<T, V>>
        extends GroupEditableListFragment<T, V, E>
{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setDefaultGroupingCriteria(ImageListAdapter.MODE_GROUP_BY_DATE);
    }

    @Override
    public void onGroupingOptions(Map<String, Integer> options)
    {
        super.onGroupingOptions(options);

        options.put(getString(R.string.text_groupByNothing), ImageListAdapter.MODE_GROUP_BY_NOTHING);
        options.put(getString(R.string.text_groupByDate), ImageListAdapter.MODE_GROUP_BY_DATE);
        options.put(getString(R.string.text_groupByAlbum), ImageListAdapter.MODE_GROUP_BY_ALBUM);
    }
}
