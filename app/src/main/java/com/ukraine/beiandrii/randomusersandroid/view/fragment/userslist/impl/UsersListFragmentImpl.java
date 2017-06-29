package com.ukraine.beiandrii.randomusersandroid.view.fragment.userslist.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ukraine.beiandrii.randomusersandroid.R;
import com.ukraine.beiandrii.randomusersandroid.model.UserModel;
import com.ukraine.beiandrii.randomusersandroid.view.adapter.UserListAdapter;
import com.ukraine.beiandrii.randomusersandroid.view.consts.FragmentConsts;
import com.ukraine.beiandrii.randomusersandroid.view.fragment.userprofile.impl.UserProfileFragmentImpl;
import com.ukraine.beiandrii.randomusersandroid.view.fragment.userslist.UsersListFragment;
import com.ukraine.beiandrii.randomusersandroid.view.fragment.userslist.UsersListFragmentPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by psihey on 28.06.17.
 */

public class UsersListFragmentImpl extends Fragment implements UsersListFragment {

    @BindView(R.id.recycler_view_users)
    RecyclerView mRecyclerViewUser;

    private UsersListFragmentPresenter mUsersListFragmentPresenter;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_users_list, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        mUsersListFragmentPresenter = new UsersListFragmentPresenterImpl();
        mUsersListFragmentPresenter.bindView(this);
        initRecyclerView();
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
        mUsersListFragmentPresenter.unbindView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    private void initRecyclerView() {
        mRecyclerViewUser.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerViewUser.setLayoutManager(linearLayoutManager);
        UserListAdapter userListAdapter = new UserListAdapter(getContext(),mUsersListFragmentPresenter.getUsersForAdapter(),this);
        mRecyclerViewUser.setAdapter(userListAdapter);
    }


    @Override
    public void getUserFromAdapter(UserModel userModel) {
        FragmentManager fragManager = getFragmentManager();
        UserProfileFragmentImpl userProfileFragment = UserProfileFragmentImpl.getInstance(userModel);
        fragManager
                .beginTransaction()
                .replace(R.id.corLay_container_main_activity,
                        userProfileFragment,
                        FragmentConsts.TAG_USER_PROFILE_FRAGMENT)
                .addToBackStack(FragmentConsts.TAG_USER_PROFILE_FRAGMENT)
                .commit();

    }
}
