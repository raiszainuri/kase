package com.mhs.kase.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;
import com.mhs.kase.R;
import com.mhs.kase.utils.KaseApi;

import java.util.Map;

public class SettingActivity extends AppCompatActivity implements KaseApi {

    private AppBarLayout appbar;
    private Toolbar toolbar;
    private TextView toolbarTitle;
    private ImageView ivProfile;
    private TextView tvNama;
    private TextView tvUsername;
    private TextView tvName1;
    private TextView tvSetting1;
    private TextView tvName2;
    private TextView tvSetting2;
    private TextView tvName3;
    private TextView tvSetting3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
    }

    private void initView() {
        appbar = (AppBarLayout) findViewById(R.id.appbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        ivProfile = (ImageView) findViewById(R.id.iv_profile);
        tvNama = (TextView) findViewById(R.id.tv_nama);
        tvUsername = (TextView) findViewById(R.id.tv_username);
        tvName1 = (TextView) findViewById(R.id.tv_name_1);
        tvSetting1 = (TextView) findViewById(R.id.tv_setting_1);
        tvName2 = (TextView) findViewById(R.id.tv_name_2);
        tvSetting2 = (TextView) findViewById(R.id.tv_setting_2);
        tvName3 = (TextView) findViewById(R.id.tv_name_3);
        tvSetting3 = (TextView) findViewById(R.id.tv_setting_3);

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
