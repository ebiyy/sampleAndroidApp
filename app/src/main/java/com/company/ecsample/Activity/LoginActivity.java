//
//  LoginActivity.java
//  EC-sample
//
//  Created by Trial: Yusuke Ebinuma on 2019/08/09.
//  Copyright © 2019 Repro CRE. All rights reserved.
//

package com.company.ecsample.Activity;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.company.ecsample.R;

import io.repro.android.Repro;



public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.login_screen);
        setTitle("Login Screen");

        checkLogged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.login_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.products:

                /**
                 *  Track click login menu event using custom event tracking.
                 *
                 *  Refer to the documentation for more detail information.
                 *  (JP) https://docs.repro.io/ja/dev/sdk/tracking.html#custom-event
                 *  (EN) https://docs.repro.io/en/dev/sdk/tracking.html#custom-event
                 */
                Repro.track("Click login");


                SharedPreferences sharedPref = getSharedPreferences("DataSave", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean("LOGGED_IN", true);
                editor.apply();

                Intent i = new Intent();
                i.setClass(this, HomeActivity.class);
                startActivity(i);
                finish();
                break;
        }
        return false;
    }

    protected void checkLogged() {
        SharedPreferences sharedPref = getSharedPreferences("DataSave", MODE_PRIVATE);
        boolean isLogin = sharedPref.getBoolean("LOGGED_IN",false );
        if (isLogin) {
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("LOGGED", true);
            startActivity(intent);
            finish();
        }
    }
}
