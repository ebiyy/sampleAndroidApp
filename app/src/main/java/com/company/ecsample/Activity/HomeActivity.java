//
//  HomeActivity.java
//  EC-sample
//
//  Created by Trial: Yusuke Ebinuma on 2019/08/09.
//  Copyright © 2019 Repro CRE. All rights reserved.
//

package com.company.ecsample.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.company.ecsample.MyApplication;
import com.company.ecsample.R;

import io.repro.android.Repro;
import io.repro.android.user.UserProfileGender;


public class HomeActivity extends AppCompatActivity {

    protected MyApplication MyApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        setTitle("home");

        MyApp = (MyApplication)this.getApplicationContext();

        ImageView image = findViewById(R.id.imgView);
        image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goDetailActivity();
            }
        });

        /**
         * Set the userID.
         * Tips: Basically, you should set userID after you login.
         * Set a unique string for each user.
         *
         * Refer to the documentation for more detail information.
         * (JP) https://docs.repro.io/ja/dev/sdk/user-id.html#id
         * (EN) https://docs.repro.io/en/dev/sdk/user-id.html#id
         *
         * The best time to set the user ID depends on the application's login function.
         * (JP) https://support.repro.io/ja/articles/3054620-%E3%83%A6%E3%83%BC%E3%82%B6%E3%83%BCid%E3%81%AE%E8%A8%AD%E5%AE%9A%E3%81%AE%E3%82%BF%E3%82%A4%E3%83%9F%E3%83%B3%E3%82%B0%E3%81%A8%E3%83%99%E3%82%B9%E3%83%88%E3%83%97%E3%83%A9%E3%82%AF%E3%83%86%E3%82%A3%E3%82%B9å
         */
        Repro.setUserID("xxxx");


        /**
         * Set the custom event tracking.
         *
         * Refer to the documentation for more detail information.
         * (JP) https://docs.repro.io/ja/dev/sdk/tracking.html#custom-event
         * (EN) https://docs.repro.io/en/dev/sdk/tracking.html#custom-event
         */
        Repro.track("home screen");


        /**
         * Set the standard user profile.
         *
         * Refer to the documentation for more detail information.
         * (JP) https://docs.repro.io/ja/dev/sdk/user-profile.html#id3
         * (EN) https://docs.repro.io/en/dev/sdk/user-profile.html#id3
         */
        Repro.setUserGender(UserProfileGender.MALE);


        /**
         * Set the custom user profile.
         *
         * Refer to the documentation for more detail information.
         * (JP) https://docs.repro.io/ja/dev/sdk/user-profile.html#custom-profile
         * (EN) https://docs.repro.io/ja/dev/sdk/user-profile.html#custom-profile
         */
        Repro.setStringUserProfile("Job", "Developer");
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyApp.showInAppMessage(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cart_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.cart:
                Intent i = new Intent();
                i.setClass(this, cartActivity.class);
                startActivity(i);
                break;
        }
        return false;
    }

    protected void goDetailActivity() {
        Intent intent = new Intent(this, detailActivity.class);
        startActivity(intent);
    }
}
