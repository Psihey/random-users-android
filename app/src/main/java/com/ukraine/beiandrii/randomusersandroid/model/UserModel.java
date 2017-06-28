package com.ukraine.beiandrii.randomusersandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by psihey on 27.06.17.
 */

public class UserModel implements Parcelable {
    private String gender;
    private String email;
    private String dob;
    private String registered;
    private String phone;
    private String cell;
    private String nat;
    private NameModel name;
    private LocationModel location;
    private LoginModel login;
    private IdModel id;
    private PictureModel picture;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    public NameModel getName() {
        return name;
    }

    public void setName(NameModel name) {
        this.name = name;
    }

    public LocationModel getLocation() {
        return location;
    }

    public void setLocation(LocationModel location) {
        this.location = location;
    }

    public LoginModel getLogin() {
        return login;
    }

    public void setLogin(LoginModel login) {
        this.login = login;
    }

    public IdModel getId() {
        return id;
    }

    public void setId(IdModel id) {
        this.id = id;
    }

    public PictureModel getPicture() {
        return picture;
    }

    public void setPicture(PictureModel picture) {
        this.picture = picture;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.gender);
        dest.writeString(this.email);
        dest.writeString(this.dob);
        dest.writeString(this.registered);
        dest.writeString(this.phone);
        dest.writeString(this.cell);
        dest.writeString(this.nat);
        dest.writeParcelable(this.name, flags);
        dest.writeParcelable(this.location, flags);
        dest.writeParcelable(this.login, flags);
        dest.writeParcelable(this.id, flags);
        dest.writeParcelable(this.picture, flags);
    }

    public UserModel() {
    }

    protected UserModel(Parcel in) {
        this.gender = in.readString();
        this.email = in.readString();
        this.dob = in.readString();
        this.registered = in.readString();
        this.phone = in.readString();
        this.cell = in.readString();
        this.nat = in.readString();
        this.name = in.readParcelable(NameModel.class.getClassLoader());
        this.location = in.readParcelable(LocationModel.class.getClassLoader());
        this.login = in.readParcelable(LoginModel.class.getClassLoader());
        this.id = in.readParcelable(IdModel.class.getClassLoader());
        this.picture = in.readParcelable(PictureModel.class.getClassLoader());
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel source) {
            return new UserModel(source);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    @Override
    public String toString() {
        return "UserModel{" +
                "gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                ", registered='" + registered + '\'' +
                ", phone='" + phone + '\'' +
                ", cell='" + cell + '\'' +
                ", nat='" + nat + '\'' +
                ", name=" + name +
                ", location=" + location +
                ", login=" + login +
                ", id=" + id +
                ", picture=" + picture +
                '}';
    }
}
