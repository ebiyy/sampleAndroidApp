package io.repro.reprosample;

import android.app.Application;
import io.repro.android.Repro;


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Setup Repro
        Repro.setup(this, "");
    }
}