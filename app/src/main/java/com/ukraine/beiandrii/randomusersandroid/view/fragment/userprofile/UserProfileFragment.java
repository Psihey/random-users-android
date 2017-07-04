package com.ukraine.beiandrii.randomusersandroid.view.fragment.userprofile;

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

import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import com.ukraine.beiandrii.randomusersandroid.R;
import com.ukraine.beiandrii.randomusersandroid.model.UserModel;
import com.ukraine.beiandrii.randomusersandroid.view.consts.BundleKeysConst;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by psihey on 29.06.17.
 */

public class UserProfileFragment extends Fragment {
    @BindView(R.id.tv_telephone_mobile)
    TextView tvMobileNumber;
    @BindView(R.id.tv_telephone_home)
    TextView tvCellNumber;
    @BindView(R.id.iv_big_avatar_user_profile)
    ImageView ivAvatar;
    @BindView(R.id.toolbar_user_profile)
    Toolbar toolbarUserProfile;
    @BindView(R.id.fab_user_profile)
    FloatingActionButton floatingButton;
    @BindView(R.id.tv_email)
    TextView tvEmail;
    @BindView(R.id.tv_postal_code)
    TextView tvPostalCode;
    @BindView(R.id.tv_state)
    TextView tvState;
    @BindView(R.id.tv_city)
    TextView tvCity;
    @BindView(R.id.tv_street)
    TextView tvStreet;

    private Unbinder mUnbinder;
    private ActionBar mActionBarMain;
    private Window mWindow;

    public static UserProfileFragment getInstance(Parcelable parcelable) {
        UserProfileFragment userProfileFragment = new UserProfileFragment();
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
        if (!mActionBarMain.isShowing()) {
            mActionBarMain.show();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mWindow.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    private void setUpToolbar() {
        toolbarUserProfile.setNavigationIcon(R.drawable.ic_back_arrow);
        toolbarUserProfile.setNavigationOnClickListener(v -> getActivity().onBackPressed());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mWindow = getActivity().getWindow();
            mWindow.setStatusBarColor(Color.TRANSPARENT);
        }
        mActionBarMain = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (mActionBarMain.isShowing()) {
            mActionBarMain.hide();
        }
    }

    private void getParcelableDataAndSetInView() {
        UserModel userModel = getArguments().getParcelable(BundleKeysConst.BUNDLE_USER_MODEL);
        String firstName = userModel.getName().getFirst();
        String lastName = userModel.getName().getLast();
        tvMobileNumber.setText(userModel.getPhone());
        tvCellNumber.setText(userModel.getCell());
        tvEmail.setText(userModel.getEmail());
        tvPostalCode.setText(userModel.getLocation().getPostcode());
        tvState.setText(userModel.getLocation().getState());
        tvCity.setText(userModel.getLocation().getCity());
        tvStreet.setText(userModel.getLocation().getStreet());
        toolbarUserProfile.setTitle(firstName.substring(0, 1).toUpperCase() + firstName.substring(1)
                + " "
                + lastName.substring(0, 1).toUpperCase() + lastName.substring(1));


        Transformation transformation = new RoundedTransformationBuilder()
                .borderWidthDp(0)
                .cornerRadiusDp(40)
                .oval(true)
                .build();

        Picasso.with(getContext())
                .load(userModel.getPicture().getLarge())
                .fit()
                .transform(transformation)
                .into(ivAvatar);

    }

}
