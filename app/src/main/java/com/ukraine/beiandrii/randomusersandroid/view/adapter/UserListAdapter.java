package com.ukraine.beiandrii.randomusersandroid.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.ukraine.beiandrii.randomusersandroid.R;
import com.ukraine.beiandrii.randomusersandroid.model.UserModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by psihey on 28.06.17.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private Context mContext;
    private List<UserModel> mUsers;

    public UserListAdapter(Context context, List<UserModel> users) {
        this.mContext = context;
        this.mUsers = users;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new UserViewHolder(view);
    }

    //TODO Implement photo at error or bad connection with Picasso
    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        Picasso.with(mContext)
                .load(mUsers.get(position).getPicture().getThumbnail())
                .into(holder.ivAvatar);
        holder.tvUserName.setText(mUsers.get(position).getName().getFirst());
        holder.tvUserState.setText(mUsers.get(position).getLocation().getState());
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

        public UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
