package com.ukraine.beiandrii.randomusersandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by psihey on 27.06.17.
 */

public class LocationModel implements Parcelable {
    private String street;
    private String city;
    private String state;
    private long postcode;

    public LocationModel(String street, String city, String state, long postcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getPostcode() {
        return postcode;
    }

    public void setPostcode(long postcode) {
        this.postcode = postcode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.street);
        dest.writeString(this.city);
        dest.writeString(this.state);
        dest.writeLong(this.postcode);
    }

    protected LocationModel(Parcel in) {
        this.street = in.readString();
        this.city = in.readString();
        this.state = in.readString();
        this.postcode = in.readLong();
    }

    public static final Parcelable.Creator<LocationModel> CREATOR = new Parcelable.Creator<LocationModel>() {
        @Override
        public LocationModel createFromParcel(Parcel source) {
            return new LocationModel(source);
        }

        @Override
        public LocationModel[] newArray(int size) {
            return new LocationModel[size];
        }
    };
}
