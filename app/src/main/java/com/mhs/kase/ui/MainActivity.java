package com.mhs.kase.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.mhs.kase.R;
import com.mhs.kase.ui.fragment.DompetFragment;
import com.mhs.kase.ui.fragment.HistoryFragment;
import com.mhs.kase.ui.fragment.HomeFragment;
import com.mhs.kase.ui.fragment.MemberFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private FrameLayout frameFragment;
    private BottomNavigationView bottomNavigation;
    private Toolbar toolbar;

    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    private AppBarLayout appbar;
    private NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.tx_terbuka, R.string.tx_tertutup);
        //this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

//        navView.setNavigationItemSelectedListener(this);
        navView.getMenu().getItem(0).setChecked(true);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_fragment, new HomeFragment());
        ft.commit();

        initClick();
    }

    private void initView() {
        frameFragment = (FrameLayout) findViewById(R.id.frame_fragment);
        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        appbar = (AppBarLayout) findViewById(R.id.appbar);
        navView = (NavigationView) findViewById(R.id.nav_view);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        if (menuItem.getItemId() == R.id.page_1) {
            fragment = new HomeFragment();
            tampilkanFragment(fragment);
            return true;
        } else if (menuItem.getItemId() == R.id.page_2) {
            fragment = new HistoryFragment();
            tampilkanFragment(fragment);
            return true;
        } else if (menuItem.getItemId() == R.id.page_3) {
            fragment = new DompetFragment();
            tampilkanFragment(fragment);
            return true;
        } else {
            fragment = new MemberFragment();
            tampilkanFragment(fragment);
            return true;
        }
    }

    private void initClick() {
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Toast.makeText(MainActivity.this, menuItem.getItemId() + "", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private boolean tampilkanFragment(Fragment value) {
        // Memulai transaksi
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // mengganti isi container dengan fragment baru
        ft.replace(R.id.frame_fragment, value);
        // atau ft.add(R.id.your_placeholder, new FooFragment());
        // mulai melakukan hal di atas (jika belum di commit maka proses di atas belum dimulai)
        ft.commit();

        return false;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }
    }
}
