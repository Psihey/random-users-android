package com.ukraine.beiandrii.randomusersandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by psihey on 28.06.17.
 */

public class InfoModel implements Parcelable {

    private String seed;
    private Integer results;
    private Integer page;
    private String version;

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.seed);
        dest.writeValue(this.results);
        dest.writeValue(this.page);
        dest.writeString(this.version);
    }

    public InfoModel() {
    }

    protected InfoModel(Parcel in) {
        this.seed = in.readString();
        this.results = (Integer) in.readValue(Integer.class.getClassLoader());
        this.page = (Integer) in.readValue(Integer.class.getClassLoader());
        this.version = in.readString();
    }

    public static final Parcelable.Creator<InfoModel> CREATOR = new Parcelable.Creator<InfoModel>() {
        @Override
        public InfoModel createFromParcel(Parcel source) {
            return new InfoModel(source);
        }

        @Override
        public InfoModel[] newArray(int size) {
            return new InfoModel[size];
        }
    };
}
