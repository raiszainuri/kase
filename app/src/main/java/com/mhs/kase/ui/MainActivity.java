package com.mhs.kase.ui;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mhs.kase.R;
import com.mhs.kase.ui.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

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
    }

    private void initView() {
        frameFragment = (FrameLayout) findViewById(R.id.frame_fragment);
        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
    }

    private void initClick(){

    }
}
