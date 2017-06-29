package com.ukraine.beiandrii.randomusersandroid.view.fragment.userprofile.impl;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.ukraine.beiandrii.randomusersandroid.R;
import com.ukraine.beiandrii.randomusersandroid.model.UserModel;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    public static UserProfileFragmentImpl getInstance(Parcelable parcelable){
        UserProfileFragmentImpl userProfileFragment = new UserProfileFragmentImpl();
        Bundle bundle = new Bundle();
        bundle.putParcelable("sa",parcelable);
        userProfileFragment.setArguments(bundle);
        return userProfileFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rooView = inflater.inflate(R.layout.fragment_user_profile,container,false);
        ButterKnife.bind(this,rooView);
        UserModel userModel = getArguments().getParcelable("sa");
        System.out.println(userModel);
        tvMobileNumber.setText(userModel.getPhone());
        tvCellNumber.setText(userModel.getCell());

        Picasso.with(getContext())
                .load(userModel.getPicture().getLarge())
                .into(ivAvatar);
        return rooView;
    }
}
