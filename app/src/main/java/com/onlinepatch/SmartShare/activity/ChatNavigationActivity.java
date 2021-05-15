package com.onlinepatch.SmartShare.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.afollestad.materialdialogs.MaterialDialog;
import com.onlinepatch.SmartShare.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class ChatNavigationActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    private Button btn_serv,btn_cli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_navigation);

        btn_serv=findViewById(R.id.btn_serv);
        btn_cli=findViewById(R.id.btn_cli);
        btn_serv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openServerChatActivity();
            }
        });

        btn_cli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openClientChatActivity();
            }
        });

        setUpToolbar();
        navigationView = (NavigationView) findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case  R.id.nav_home:

                        Intent intent = new Intent(ChatNavigationActivity.this, HomeNavigationActivity.class);
                        startActivity(intent);
                        break;

                    case  R.id.nav_sharefiles:

                        Intent intent2 = new Intent(ChatNavigationActivity.this, MainActivity.class);
                        startActivity(intent2);
                        break;
                    case  R.id.nav_chat:

                        Intent intent3 = new Intent(ChatNavigationActivity.this, ChatNavigationActivity.class);
                        startActivity(intent3);
                        break;
                    /*case  R.id.about_me:
                        aboutMyApp();
                        break;*/
                    case  R.id.nav_exit:
                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);
                        break;

                }
                return false;
            }
        });
    }
    public void openServerChatActivity()
    {
        Intent intent = new Intent(ChatNavigationActivity.this,ServerActivity.class);
        startActivity(intent);
    }
    public void openClientChatActivity()
    {
        Intent intent = new Intent(ChatNavigationActivity.this,ClientActivity.class);
        startActivity(intent);
    }
    private void aboutMyApp() {

        MaterialDialog.Builder bulder = new MaterialDialog.Builder(this)
                .title(R.string.app_name)
                .customView(R.layout.about, true)
                .backgroundColor(getResources().getColor(R.color.colorPrimaryDark))
                .titleColorRes(android.R.color.white);


        MaterialDialog materialDialog = bulder.build();

        TextView versionCode = (TextView) materialDialog.findViewById(R.id.version_code);
        TextView versionName = (TextView) materialDialog.findViewById(R.id.version_name);
        versionCode.setText(String.valueOf("Version Code : 1" ));
        versionName.setText(String.valueOf("Version Name : 1.0" ));

        materialDialog.show();
    }
    public void setUpToolbar() {
        drawerLayout = findViewById(R.id.drawerLayout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }
}