package com.ukraine.beiandrii.randomusersandroid.view.activity.main.impl;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.ukraine.beiandrii.randomusersandroid.R;
import com.ukraine.beiandrii.randomusersandroid.view.consts.FragmentConsts;
import com.ukraine.beiandrii.randomusersandroid.view.fragment.userslist.impl.UsersListFragmentImpl;

public class MainActivityImpl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
