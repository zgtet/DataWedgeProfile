package com.zebra.datawedgeprofile.datawedgeprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    String profileName = "ROVER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createProfile();
    }

    private void createProfile() {
        Bundle bMain = new Bundle();
        bMain.putString("PROFILE_NAME", profileName);
        bMain.putString("PROFILE_ENABLED","true");
        bMain.putString("CONFIG_MODE","CREATE_IF_NOT_EXIST");


        Bundle bundleApp = new Bundle();
        bundleApp.putString("PACKAGE_NAME","com.zebra.datawedgeprofile.datawedgeprofile");
        bundleApp.putStringArray("ACTIVITY_LIST", new String[]{"*"});

        bMain.putParcelableArray("APP_LIST", new Bundle[]{
                bundleApp
        });

        Intent i = new Intent();
        i.setAction("com.symbol.datawedge.api.ACTION");
        i.putExtra("com.symbol.datawedge.api.SET_CONFIG", bMain);
        this.sendBroadcast(i);

    }
}
