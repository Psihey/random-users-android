package com.ukraine.beiandrii.randomusersandroid.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.ukraine.beiandrii.randomusersandroid.R;
import com.ukraine.beiandrii.randomusersandroid.model.UserModel;
import com.ukraine.beiandrii.randomusersandroid.view.fragment.userslist.UsersListFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by psihey on 28.06.17.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private Context mContext;
    private List<UserModel> mUsers;
    private UsersListFragment mUserListFragment;

    public UserListAdapter(Context context, List<UserModel> users, UsersListFragment usersListFragment) {
        this.mContext = context;
        this.mUsers = users;
        this.mUserListFragment = usersListFragment;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new UserViewHolder(view);
    }

    //TODO Implement photo at error or bad connection with Picasso
    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        String firstName = mUsers.get(position).getName().getFirst();
        String lastName = mUsers.get(position).getName().getLast();
        String state = mUsers.get(position).getLocation().getState();

        Picasso.with(mContext)
                .load(mUsers.get(position).getPicture().getThumbnail())
                .into(holder.ivAvatar);
        holder.tvUserName.setText(firstName.substring(0,1).toUpperCase() + firstName.substring(1)
                + " "
                + lastName.substring(0,1).toUpperCase() + lastName.substring(1));
        holder.tvUserState.setText(state.substring(0,1).toUpperCase() + state.substring(1));

        holder.relativeLayout.setOnClickListener(view -> mUserListFragment.openUserProfileFragment(mUsers.get(position)));
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_item_user_avatar)
        ImageView ivAvatar;
        @BindView(R.id.tv_item_user_name)
        TextView tvUserName;
        @BindView(R.id.tv_item_user_state)
        TextView tvUserState;
        @BindView(R.id.layout_item_user)
        RelativeLayout relativeLayout;

        public UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
