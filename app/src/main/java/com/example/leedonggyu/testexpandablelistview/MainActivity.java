package com.example.leedonggyu.testexpandablelistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ArrayList<String> mGroupList = null;
    private ArrayList<ArrayList<String>> mChildList = null;
    private ArrayList<String> mChildListContent = null;
    private ExpandableListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setLayout();

        mGroupList = new ArrayList<String>();
        mChildList = new ArrayList<ArrayList<String>>();
        mChildListContent = new ArrayList<String>();

        mGroupList.add("가위");
        mGroupList.add("바위");
        mGroupList.add("보");

        mChildListContent.add("1");
        mChildListContent.add("2");
        mChildListContent.add("3");

        mChildList.add(mChildListContent);
        mChildList.add(mChildListContent);
        mChildList.add(mChildListContent);

        mListView.setAdapter(new BaseExpandableAdapter(this, mGroupList, mChildList));

        mListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(getApplicationContext(), "g click = " + groupPosition, Toast.LENGTH_SHORT).show();
                return false;
            }
        });


        mListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), "c click = " + childPosition,
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        mListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(), "g Collapse = " + groupPosition,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(), "g Expand = " + groupPosition,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setLayout(){
        mListView = (ExpandableListView)findViewById(R.id.elv_list);
    }
}