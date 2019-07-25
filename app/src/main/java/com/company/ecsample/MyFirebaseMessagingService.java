//
//  MyFirebaseMessagingService.java
//  EC-sample
//
//  Created by Trial: Yusuke Ebinuma on 2019/08/09.
//  Copyright © 2019 Repro CRE. All rights reserved.
//

package com.company.ecsample;

import com.google.firebase.messaging.FirebaseMessagingService;

import io.repro.android.Repro;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onNewToken(String token) {

        /**
         * Push notification setup
         * You need a FCM setting to send push notifications
         * Refer to the documentation for more detail information.
         * (JP) https://docs.repro.io/ja/dev/sdk/push-notification/setup-android.html
         * (EN) https://docs.repro.io/en/dev/sdk/push-notification/setup-android.html
         */
        Repro.setPushRegistrationID(token);
    }

}