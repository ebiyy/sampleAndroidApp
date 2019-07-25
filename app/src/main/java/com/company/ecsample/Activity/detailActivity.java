//
//  detailActivity.java
//  EC-sample
//
//  Created by Trial: Yusuke Ebinuma on 2019/08/09.
//  Copyright © 2019 Repro CRE. All rights reserved.
//

package com.company.ecsample.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.company.ecsample.R;

import io.repro.android.Repro;
import io.repro.android.tracking.ViewContentProperties;


public class detailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail_screen);
        setTitle("ProductDetail");

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                /**
                 * Track click goToWebview button event using custom event tracking.
                 *
                 * Refer to the documentation for more detail information.
                 * (JP) https://docs.repro.io/ja/dev/sdk/tracking.html#custom-event
                 * (EN) https://docs.repro.io/en/dev/sdk/tracking.html#custom-event
                 */
                Repro.track("Click goToWebview");


                Intent intent = new Intent(getApplication(), WebviewActivity.class);
                startActivity(intent);
            }
        });

        /**
         * Track content viewing using the standard event trackinng.
         *
         * Refer to the documentation for more detail information.
         * (JP) https://docs.repro.io/ja/dev/sdk/tracking.html#id3
         * (EN) https://docs.repro.io/en/dev/sdk/tracking.html#id3
         */
        ViewContentProperties properties = new ViewContentProperties();
        Repro.trackViewContent("ProductDetailView", properties);
    }

}
