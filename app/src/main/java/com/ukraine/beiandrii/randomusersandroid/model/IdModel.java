package com.ukraine.beiandrii.randomusersandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by psihey on 27.06.17.
 */

public class IdModel implements Parcelable {
    private String name;
    private String value;

    public IdModel(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.value);
    }

    protected IdModel(Parcel in) {
        this.name = in.readString();
        this.value = in.readString();
    }

    public static final Parcelable.Creator<IdModel> CREATOR = new Parcelable.Creator<IdModel>() {
        @Override
        public IdModel createFromParcel(Parcel source) {
            return new IdModel(source);
        }

        @Override
        public IdModel[] newArray(int size) {
            return new IdModel[size];
        }
    };

    @Override
    public String toString() {
        return "IdModel{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
