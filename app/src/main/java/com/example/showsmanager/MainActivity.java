package com.example.showsmanager;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        TabLayout.OnTabSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.side_nav_view)
    NavigationView navigationView;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.main_list_viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        setupDrawer();
        setupTab();

//        selectNav(0);
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    private void setupDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open_message, R.string.navigation_drawer_close_message);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setupTab() {
        viewPager.setAdapter(new TabPager(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("Popular Shows");
        tabLayout.getTabAt(1).setText("Top Rated Shows");
        tabLayout.getTabAt(2).setText("Watch List");
        tabLayout.getTabAt(3).setText("Watched List");
        tabLayout.setOnTabSelectedListener(this);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.nav_popular_shows) selectTab(0);
        if (id == R.id.nav_top_rated_shows) selectTab(1);
        if (id == R.id.nav_watchlist) selectTab(2);
        if (id == R.id.nav_watchedlist) selectTab(3);


        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    private void selectNav(int navNumber) {
        navigationView.getMenu().getItem(navNumber).setChecked(true);
    }
    private void selectTab(int tabNumber) {
        tabLayout.getTabAt(tabNumber).select();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        selectNav(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
