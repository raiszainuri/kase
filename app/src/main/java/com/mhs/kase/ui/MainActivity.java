package com.mhs.kase.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mhs.kase.R;
import com.mhs.kase.ui.fragment.DompetFragment;
import com.mhs.kase.ui.fragment.HistoryFragment;
import com.mhs.kase.ui.fragment.HomeFragment;
import com.mhs.kase.ui.fragment.MemberFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private FrameLayout frameFragment;
    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_fragment, new HomeFragment());
        ft.commit();

        initClick();
    }

    private void initView() {
        frameFragment = (FrameLayout) findViewById(R.id.frame_fragment);
        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        if  (menuItem.getItemId() == R.id.page_1) {
            fragment = new HomeFragment();
            tampilkanFragment(fragment);
            return true;
        }else if(menuItem.getItemId() == R.id.page_2){
            fragment = new HistoryFragment();
            tampilkanFragment(fragment);
            return true;
        }else if(menuItem.getItemId() == R.id.page_3){
            fragment = new DompetFragment();
            tampilkanFragment(fragment);
            return true;
        }else{
            fragment = new MemberFragment();
            tampilkanFragment(fragment);
            return true;
        }
    }

    private void initClick() {

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
}
