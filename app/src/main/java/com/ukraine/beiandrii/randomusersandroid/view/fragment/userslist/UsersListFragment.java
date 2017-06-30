package com.ukraine.beiandrii.randomusersandroid.view.fragment.userslist;

import com.ukraine.beiandrii.randomusersandroid.model.UserModel;

import java.util.List;

/**
 * Created by psihey on 28.06.17.
 */

public interface UsersListFragment {

    void openUserProfileFragment(UserModel userModel);

    void initRecyclerView(List<UserModel> userModel);

    void showDialogError();

}
