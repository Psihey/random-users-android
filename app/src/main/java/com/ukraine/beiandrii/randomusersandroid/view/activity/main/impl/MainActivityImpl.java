package com.ukraine.beiandrii.randomusersandroid.view.activity.main.impl;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ukraine.beiandrii.randomusersandroid.R;
import com.ukraine.beiandrii.randomusersandroid.view.consts.FragmentConsts;
import com.ukraine.beiandrii.randomusersandroid.view.fragment.userslist.impl.UsersListFragmentImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivityImpl extends AppCompatActivity {
    @BindView(R.id.toolbar_main_activity)
    Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolBar);
        startUsersListFragment();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void startUsersListFragment() {
        FragmentManager fragManager = getSupportFragmentManager();
        UsersListFragmentImpl usersListFragment = new UsersListFragmentImpl();
        fragManager
                .beginTransaction()
                .replace(R.id.corLay_container_main_activity,
                        usersListFragment,
                        FragmentConsts.TAG_USERS_LIST_FRAGMENT)
                .commit();
    }

}
