package com.mhs.kase.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;
import com.mhs.kase.R;

public class CatatanDetailActivity extends AppCompatActivity {

    private TextView tvTitle;
    private TextView tvDesc;
    private TextView tvTanggal;
    private TextView tvKeteranganDetail;
    private TextView tvHarga;
    private AppBarLayout appbar;
    private Toolbar toolbar;
    private TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catatan_detail);
        initView();
        getData(this.getIntent());

    }

    private void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvDesc = (TextView) findViewById(R.id.tv_desc);
        tvTanggal = (TextView) findViewById(R.id.tv_tanggal);
        tvKeteranganDetail = (TextView) findViewById(R.id.tv_keterangan_detail);
        tvHarga = (TextView) findViewById(R.id.tv_harga);
        appbar = (AppBarLayout) findViewById(R.id.appbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbarTitle = (TextView) findViewById(R.id.toolbar_title);

        toolbar.setNavigationIcon(R.drawable.ic_chevron_left);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getData(Intent i) {
        tvTitle.setText(i.getStringExtra("i_title"));
        tvKeteranganDetail.setText(i.getStringExtra("i_desc"));
        tvHarga.setText("Rp." + i.getIntExtra("i_price", 0));
    }
}
