package com.ukraine.beiandrii.randomusersandroid.view.fragment.userprofile.impl;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
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
    @BindView(R.id.toolbar_user_profile)
    Toolbar toolbarUserProfile;
    @BindView(R.id.fab_user_profile)
    FloatingActionButton floatingButton;
    private Unbinder mUnbinder;
    private ActionBar mActionBarMain;
    private Window mWindow;

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
        mWindow.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
    }

    private void setUpToolbar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mWindow = getActivity().getWindow();
            mWindow.setStatusBarColor(Color.TRANSPARENT);
        }
       mActionBarMain = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (mActionBarMain.isShowing()){
            mActionBarMain.hide();
        }
    }

    private void getParcelableDataAndSetInView() {
        UserModel userModel = getArguments().getParcelable(BundleKeysConst.BUNDLE_USER_MODEL);
        System.out.println(userModel);
        String firstName = userModel.getName().getFirst();
        String lastName = userModel.getName().getLast();
        tvMobileNumber.setText(userModel.getPhone());
        tvCellNumber.setText(userModel.getCell());
        toolbarUserProfile.setTitle(firstName.substring(0,1).toUpperCase() + firstName.substring(1)
                + " "
                + lastName.substring(0,1).toUpperCase() + lastName.substring(1));
        if (userModel.getGender().equals("female")){
            System.out.println("Sd");
          floatingButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_female_symbol));
        }else {
            floatingButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_male_sign));
        }

        Picasso.with(getContext())
                .load(userModel.getPicture().getLarge())
                .into(ivAvatar);



    }

}
