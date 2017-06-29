package com.ukraine.beiandrii.randomusersandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by psihey on 28.06.17.
 */

public class UserJson implements Parcelable {

    private List<UserModel> results;
    private InfoModel info;

    public List<UserModel> getResult() {
        return results;
    }

    public void setResult(List<UserModel> result) {
        this.results = result;
    }

    public InfoModel getInfo() {
        return info;
    }

    public void setInfo(InfoModel info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "UserJson{" +
                "results=" + results +
                ", info=" + info +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.results);
        dest.writeParcelable(this.info, flags);
    }

    public UserJson() {
    }

    protected UserJson(Parcel in) {
        this.results = in.createTypedArrayList(UserModel.CREATOR);
        this.info = in.readParcelable(InfoModel.class.getClassLoader());
    }

    public static final Parcelable.Creator<UserJson> CREATOR = new Parcelable.Creator<UserJson>() {
        @Override
        public UserJson createFromParcel(Parcel source) {
            return new UserJson(source);
        }

        @Override
        public UserJson[] newArray(int size) {
            return new UserJson[size];
        }
    };
}
