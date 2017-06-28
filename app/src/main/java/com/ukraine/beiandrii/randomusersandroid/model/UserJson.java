package com.ukraine.beiandrii.randomusersandroid.model;

import java.util.List;

/**
 * Created by psihey on 28.06.17.
 */

public class UserJson {

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
}
