package com.onlinepatch.SmartShare.view;

import com.onlinepatch.SmartShare.fragment.EditableListFragment;
import com.onlinepatch.SmartShare.widget.EditableListAdapter;

public interface EditableListFragmentModelImpl<V extends EditableListAdapter.EditableViewHolder>
{
    void setLayoutClickListener(EditableListFragment.LayoutClickListener<V> clickListener);
}
