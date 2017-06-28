package com.ukraine.beiandrii.randomusersandroid.view.activity.main.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ukraine.beiandrii.randomusersandroid.R;
import com.ukraine.beiandrii.randomusersandroid.model.UserJson;
import com.ukraine.beiandrii.randomusersandroid.model.UserModel;
import com.ukraine.beiandrii.randomusersandroid.service.RetrofitProvider;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityImpl extends AppCompatActivity implements  Callback<UserJson> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO this is test connection to server,wii be improve and migrate  to presenter
        Call<UserJson>userJsonCall = RetrofitProvider.getRetrofit().getUsersByGender(100,"male");
        System.out.println(userJsonCall);
        userJsonCall.enqueue(this);
    }


    @Override
    public void onResponse(Call<UserJson>call, Response<UserJson> response) {
        System.out.println(response.body());
        List<UserJson> dfdfd=new ArrayList<>();
        dfdfd.add(response.body());
        System.out.println(dfdfd.size());
        for (UserJson sd : dfdfd){
            for (UserModel sas : sd.getResult()){
                System.out.println(sas);
            }
        }

    }

    @Override
    public void onFailure(Call<UserJson> call, Throwable t) {
      t.printStackTrace();

    }
}
