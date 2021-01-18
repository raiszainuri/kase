package com.mhs.kase.view;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;
import com.mhs.kase.R;
import com.mhs.kase.utils.KaseApi;

import java.util.Map;

public class TambahMemberActivity extends AppCompatActivity implements KaseApi {

    private AppBarLayout appbar;
    private Toolbar toolbar;
    private TextView toolbarTitle;
    private LinearLayout btnTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_member);
        initView();
    }

    private void initView() {
        appbar = (AppBarLayout) findViewById(R.id.appbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        btnTambah = (LinearLayout) findViewById(R.id.btn_tambah);

        toolbar.setNavigationIcon(R.drawable.ic_chevron_left);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void executeUrl(String url, Map<String, String> params) {

    }
}
