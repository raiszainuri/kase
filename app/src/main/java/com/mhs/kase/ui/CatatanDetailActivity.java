package com.mhs.kase.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mhs.kase.R;

public class CatatanDetailActivity extends AppCompatActivity {

    private TextView tvTitle;
    private TextView tvDesc;
    private TextView tvTanggal;
    private TextView tvKeteranganDetail;
    private TextView tvHarga;

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
    }

    private void getData(Intent i) {
        tvTitle.setText(i.getStringExtra("i_title"));
        tvKeteranganDetail.setText(i.getStringExtra("i_desc"));
        tvHarga.setText("Rp." + i.getIntExtra("i_price",0));
    }
}
