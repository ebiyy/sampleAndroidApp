//
//  cartActivity.java
//  EC-sample
//
//  Created by Trial: Yusuke Ebinuma on 2019/08/09.
//  Copyright © 2019 Repro CRE. All rights reserved.
//

package com.company.ecsample.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.company.ecsample.R;

import io.repro.android.Repro;
import io.repro.android.tracking.ViewContentProperties;


public class cartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blank_page);
        setTitle("Cart");

        /**
         * Track content viewing using the standard event trackinng.
         *
         * Refer to the documentation for more detail information.
         * (JP) https://docs.repro.io/ja/dev/sdk/tracking.html#id3
         * (EN) https://docs.repro.io/en/dev/sdk/tracking.html#id3
         */
        ViewContentProperties properties = new ViewContentProperties();
        Repro.trackViewContent("CartView", properties);

        SharedPreferences sharedPref = getSharedPreferences("DataSave", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("LOGGED_IN", false);
        editor.apply();
    }
}
