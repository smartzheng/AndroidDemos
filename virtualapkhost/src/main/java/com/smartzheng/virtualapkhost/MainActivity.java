package com.smartzheng.virtualapkhost;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.didi.virtualapk.PluginManager;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startPlugin(View view) {
        String pluginPath = Environment.getExternalStorageDirectory().getAbsolutePath().concat("/plugin.apk");
        File plugin = new File(pluginPath);
        try {
            PluginManager.getInstance(this).loadPlugin(plugin);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Given "com.didi.virtualapk.demo" is the package name of plugin APK,
        // and there is an activity called `MainActivity`.
        Intent intent = new Intent();
        intent.setClassName("com.smartzheng.virtualapkplugin", "com.smartzheng.virtualapkplugin.MainActivity");
        startActivity(intent);
    }
}
