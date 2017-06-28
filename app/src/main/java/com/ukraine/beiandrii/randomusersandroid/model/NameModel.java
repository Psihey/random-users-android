package com.ukraine.beiandrii.randomusersandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by psihey on 27.06.17.
 */

public class NameModel implements Parcelable {
    private String title;
    private String firstName;
    private String lastName;


    public NameModel(String title, String firstName, String lastName) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
    }

    protected NameModel(Parcel in) {
        this.title = in.readString();
        this.firstName = in.readString();
        this.lastName = in.readString();
    }

    public static final Parcelable.Creator<NameModel> CREATOR = new Parcelable.Creator<NameModel>() {
        @Override
        public NameModel createFromParcel(Parcel source) {
            return new NameModel(source);
        }

        @Override
        public NameModel[] newArray(int size) {
            return new NameModel[size];
        }
    };
}
