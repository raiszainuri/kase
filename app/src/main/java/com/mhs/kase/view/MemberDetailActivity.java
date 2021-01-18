package com.mhs.kase.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.github.paolorotolo.expandableheightlistview.ExpandableHeightListView;
import com.google.android.material.appbar.AppBarLayout;
import com.mhs.kase.R;
import com.mhs.kase.adapter.CatatanAdapter;
import com.mhs.kase.model.CatatanModel;
import com.mhs.kase.utils.KaseApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MemberDetailActivity extends AppCompatActivity implements KaseApi {

    private ImageView ivProfile;
    private ScrollView sv;
    private View ivPlaceholder;
    private TextView tvNama;
    private TextView tvUsername;
    private TextView btnHubungi;
    private ExpandableHeightListView lvList;

    private CatatanAdapter adapter;
    private List<CatatanModel> listModel = new ArrayList<>();

    private String username, name;
    private AppBarLayout appbar;
    private Toolbar toolbar;
    private TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_detail);

        username = this.getIntent().getStringExtra("i_username");
        name = this.getIntent().getStringExtra("i_name");

        initView();

        adapter = new CatatanAdapter(this, listModel);
        lvList.setAdapter(adapter);

        initData();

        tvNama.setText(name);
        tvUsername.setText(username);
    }

    private void initView() {
        sv = (ScrollView) findViewById(R.id.sv);
        ivProfile = (ImageView) findViewById(R.id.iv_profile);
        ivPlaceholder = (View) findViewById(R.id.iv_placeholder);
        tvNama = (TextView) findViewById(R.id.tv_nama);
        tvUsername = (TextView) findViewById(R.id.tv_username);
        btnHubungi = (TextView) findViewById(R.id.btn_hubungi);
        lvList = (ExpandableHeightListView) findViewById(R.id.lv_list);
        appbar = (AppBarLayout) findViewById(R.id.appbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbarTitle = (TextView) findViewById(R.id.toolbar_title);

        lvList.setExpanded(true);
        toolbar.setNavigationIcon(R.drawable.ic_chevron_left);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initData() {
        int[] oke = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        for (int i = 0; i < 10; i++) {
            CatatanModel model = new CatatanModel();
            model.setIdcolor(oke[i]);
            listModel.add(model);
        }
        //adapter.notifyDataSetChanged();
    }

    @Override
    public void executeUrl(String url, Map<String, String> params) {

    }
}