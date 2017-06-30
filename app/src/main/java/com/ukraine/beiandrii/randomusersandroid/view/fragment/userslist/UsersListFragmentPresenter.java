package com.ukraine.beiandrii.randomusersandroid.view.fragment.userslist;

/**
 * Created by psihey on 28.06.17.
 */

public interface UsersListFragmentPresenter {

    /**
     * A method which binds a view to a presenter.
     */
    void bindView(UsersListFragment usersListFragment);

    /**
     * A method which unbinds a view to a presenter.
     */
    void unbindView();

    void getUsersFromServer();

}
