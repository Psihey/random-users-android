package com.ukraine.beiandrii.randomusersandroid.view.fragment.userprofile.impl;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.ukraine.beiandrii.randomusersandroid.R;
import com.ukraine.beiandrii.randomusersandroid.model.UserModel;
import com.ukraine.beiandrii.randomusersandroid.view.consts.BundleKeysConst;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by psihey on 29.06.17.
 */

public class UserProfileFragmentImpl extends Fragment {
    @BindView(R.id.tv_mobile_number)
    TextView tvMobileNumber;
    @BindView(R.id.tv_cell_number)
    TextView tvCellNumber;
    @BindView(R.id.iv_big_avatar_user_profile)
    ImageView ivAvatar;

    private Unbinder mUnbinder;
    private ActionBar mActionBarMain;

    public static UserProfileFragmentImpl getInstance(Parcelable parcelable) {
        UserProfileFragmentImpl userProfileFragment = new UserProfileFragmentImpl();
        Bundle bundle = new Bundle();
        bundle.putParcelable(BundleKeysConst.BUNDLE_USER_MODEL, parcelable);
        userProfileFragment.setArguments(bundle);
        return userProfileFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rooView = inflater.inflate(R.layout.fragment_user_profile, container, false);
        mUnbinder = ButterKnife.bind(this, rooView);
        setUpToolbar();
        getParcelableDataAndSetInView();
        return rooView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        if(!mActionBarMain.isShowing()){
            mActionBarMain.show();
        }
    }

    private void setUpToolbar() {
       mActionBarMain = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (mActionBarMain.isShowing()){
            mActionBarMain.hide();
        }
    }

    private void getParcelableDataAndSetInView() {
        UserModel userModel = getArguments().getParcelable(BundleKeysConst.BUNDLE_USER_MODEL);
        System.out.println(userModel);
        tvMobileNumber.setText(userModel.getPhone());
        tvCellNumber.setText(userModel.getCell());

        Picasso.with(getContext())
                .load(userModel.getPicture().getLarge())
                .into(ivAvatar);
    }

}
