package com.namMysuruData;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {


    private DrawerLayout mdrawerLayout;
    private NavigationView mnavigationView;
    private Toolbar mtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer_layout);
        intializeViews();
        /**
         * If we use this toolbar after the addHamburgerSymbol() navigation click won t work.Check what is the issue..
         */
        useToolbar();
        addHamburgerSymbol();

    }
    private void intializeViews(){
        mdrawerLayout=findViewById(R.id.drawerlayout);
        mnavigationView=(NavigationView)findViewById(R.id.navigation_view);
        mtoolbar=(Toolbar)findViewById(R.id.mainActivity_toolbar);
    }
    private void addHamburgerSymbol(){
        ActionBarDrawerToggle loc_actionBarDrawerToggle=new ActionBarDrawerToggle(
                this,
                mdrawerLayout,
                mtoolbar,
                R.string.close_navigation_Drawer,
                R.string.open_navigation_Drawer
                );
        mdrawerLayout.addDrawerListener(loc_actionBarDrawerToggle);
        loc_actionBarDrawerToggle.syncState();
    }
    private void useToolbar(){
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
