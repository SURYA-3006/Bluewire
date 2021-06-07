package com.onlinepatch.SmartShare.activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.material.navigation.NavigationView;
import com.onlinepatch.SmartShare.R;

public class ChatActivity extends AppCompatActivity {

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

                        Intent intent = new Intent(ChatActivity.this, HomeActivity.class);
                        startActivity(intent);
                        break;

                    case  R.id.nav_sharefiles:

                        Intent intent2 = new Intent(ChatActivity.this, ShareActivity.class);
                        startActivity(intent2);
                        break;
                    case  R.id.nav_chat:

                        Intent intent3 = new Intent(ChatActivity.this, ChatActivity.class);
                        startActivity(intent3);
                        break;
                    case  R.id.nav_exit:
                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);
                        break;
                    case R.id.share1:
                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        String shareBody = "Download app now. https://drive.google.com/drive/folders/1lKLIc5fD3SCj7eFtkiIR3oM28kOusBjO?usp=sharing"
                                + getApplicationContext().getPackageName();
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Share App");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                        startActivity(Intent.createChooser(sharingIntent, "Share via"));
                        break;
                    case R.id.about_me1:
                        aboutMyApp();
                        break;
                    case R.id.rate_us1:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms" +
                                "/d/1td8lZiv16ts1OsAbGDF6Kz9yHyV9QEQML9Wy75ayG3c/edit?usp=sharing" + getApplicationContext().getPackageName())));
                        break;

                }
                return false;
            }
        });
    }
    public void openServerChatActivity()
    {
        Intent intent = new Intent(ChatActivity.this,ServerActivity.class);
        startActivity(intent);
    }
    public void openClientChatActivity()
    {
        Intent intent = new Intent(ChatActivity.this,ClientActivity.class);
        startActivity(intent);
    }
    private void aboutMyApp() {

        MaterialDialog.Builder bulder = new MaterialDialog.Builder(this)
                .customView(R.layout.about, true)
                .backgroundColor(getResources().getColor(R.color.grey))
                .titleColorRes(android.R.color.white);
        MaterialDialog materialDialog = bulder.build();

        TextView versionCode = (TextView) materialDialog.findViewById(R.id.version_code);
        TextView versionName = (TextView) materialDialog.findViewById(R.id.version_name);
        versionCode.setText(String.valueOf("Developers :   Suryakant Prusty\nBiswajit Swain\nTushar Sharma"));
        versionName.setText(String.valueOf("\nBluewire application focuses on facilitating easy transfer of data" +
                " and share information through message functionality."));
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