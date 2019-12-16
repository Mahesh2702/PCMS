package com.example.navredesign;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

//import com.example.navslider.scorecard.ScoreCardActivity;

import java.util.HashMap;
import java.util.List;


public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<GroupParentItem> listDataHeader;

    public ExpandableListAdapter(Context context, List<GroupParentItem> listDataHeader) {
        this.context = context;
        this.listDataHeader = listDataHeader;
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        System.out.println(this.listDataHeader.get(groupPosition).getName()+" "+this.listDataHeader.get(groupPosition).getChildList().size());
        return this.listDataHeader.get(groupPosition).getChildList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listDataHeader.get(groupPosition).getChildList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View contentView, ViewGroup parent) {
        GroupParentItem header = (GroupParentItem) getGroup(groupPosition);
        if (contentView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            contentView = infalInflater.inflate(R.layout.list_group, null);
        }
        TextView lblListHeader = (TextView) contentView.findViewById(R.id.lblListHeader);
        ImageView icon = (ImageView) contentView.findViewById(R.id.flgListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(header.getName());
        icon.setImageResource(header.getFlag());
        ImageView expndIcon = contentView.findViewById(R.id.listExpandIcon);
        ExpandableListView mExpandableListView = (ExpandableListView) parent;
        expndIcon.setImageResource(R.drawable.ic_arrow_drop_down_black_24dp);
//        if (getChildrenCount(groupPosition) == 0 ) {
//
//            mExpandableListView.setGroupIndicator(null);
//        } else{
//            mExpandableListView.setGroupIndicator(context.getResources().getDrawable(R.drawable.groupindicator_selector));
//        }

        // Checking if has child
        if (getChildrenCount(groupPosition)==0)
        {
            // set visibility invisible
            expndIcon.setVisibility(View.INVISIBLE);
        }
        else
        {
            if (mExpandableListView.isGroupExpanded(groupPosition)) {
                expndIcon.setImageResource(R.drawable.ic_arrow_drop_up_black_24dp);
            } else {
                expndIcon.setImageResource(R.drawable.ic_arrow_drop_down_black_24dp);
            }
            // set visibility visible
            expndIcon.setVisibility(View.VISIBLE);
        }

        //below code is to expand all groups by default
//        ExpandableListView mExpandableListView = (ExpandableListView) parent;
//        mExpandableListView.expandGroup(groupPosition);
        return contentView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childTitle = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }
        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);
        txtListChild.setText(childTitle);


        return convertView;
    }


    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
