package com.ukraine.beiandrii.randomusersandroid.view.fragment.userslist.impl;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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

import java.util.List;

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
    private Unbinder mUnbinder;
    private ProgressDialog mProgressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_users_list, container, false);
        mUnbinder = ButterKnife.bind(this, rootView);
        mUsersListFragmentPresenter = new UsersListFragmentPresenterImpl();
        mUsersListFragmentPresenter.bindView(this);

        initProgressDialog();
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        setUpToolbar();
    }

    @Override
    public void onStop() {
        super.onStop();
        mUsersListFragmentPresenter.unbindView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    @Override
    public void openUserProfileFragment(UserModel userModel) {
        FragmentManager fragManager = getFragmentManager();
        UserProfileFragmentImpl userProfileFragment = UserProfileFragmentImpl.getInstance(userModel);
        fragManager
                .beginTransaction()
                .hide(this)
                .add(R.id.corLay_container_main_activity,
                        userProfileFragment,
                        FragmentConsts.TAG_USER_PROFILE_FRAGMENT)
                .addToBackStack(FragmentConsts.TAG_USER_PROFILE_FRAGMENT)
                .commit();
    }

    @Override
    public void initRecyclerView(List<UserModel> userModel) {
        mProgressDialog.cancel();
        mRecyclerViewUser.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerViewUser.setLayoutManager(linearLayoutManager);
        UserListAdapter userListAdapter = new UserListAdapter(getContext(),userModel,this);
        mRecyclerViewUser.setAdapter(userListAdapter);
    }

    @Override
    public void showDialogError() {
        mProgressDialog.cancel();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Oops ,something going in wrong way");
        builder.setIcon(R.drawable.ic_aspect_ratio_black_24dp);
        builder.setMessage("Please check your internet connection");
        builder.setPositiveButton("Retry", (dialog, which) -> {
            mProgressDialog.show();
           mUsersListFragmentPresenter.getUsersFromServer();
        });
        builder.setNegativeButton("Close",(dialog, which) -> {
           getActivity().onBackPressed();
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void setUpToolbar() {
        ActionBar mainActivityToolbar =((AppCompatActivity) getActivity()).getSupportActionBar();
        if (!mainActivityToolbar.isShowing()){
            mainActivityToolbar.show();
        }
    }

    private void initProgressDialog() {
        mProgressDialog = new ProgressDialog(getContext());
        mProgressDialog.setMessage("Please wait some seconds! fetching data from the server");
        mProgressDialog.setTitle("Inform Dialog");
        mProgressDialog.setIcon(R.drawable.ic_public_black_24dp);
        mProgressDialog.show();
    }

}
