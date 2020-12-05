package com.mhs.kase.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.paolorotolo.expandableheightlistview.ExpandableHeightListView;
import com.mhs.kase.R;
import com.mhs.kase.adapter.CatatanAdapter;
import com.mhs.kase.model.CatatanModel;

import java.util.ArrayList;
import java.util.List;

public class MemberDetailActivity extends AppCompatActivity {

    private ImageView ivProfile;
    private ScrollView sv;
    private View ivPlaceholder;
    private TextView tvNama;
    private TextView tvUsername;
    private TextView btnHubungi;
    private ExpandableHeightListView lvList;

    private CatatanAdapter adapter;
    private List<CatatanModel> listModel = new ArrayList<>();

    private String username,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_detail);

        username = this.getIntent().getStringExtra("i_username");
        name = this.getIntent().getStringExtra("i_name");

        initView();
        adapter = new CatatanAdapter(this, listModel);
        adapter.notifyDataSetChanged();

        initData();

        tvNama.setText(name);
        tvUsername.setText(username);
    }

    private void initView() {
        sv = (ScrollView)findViewById(R.id.sv);
        ivProfile = (ImageView) findViewById(R.id.iv_profile);
        ivPlaceholder = (View) findViewById(R.id.iv_placeholder);
        tvNama = (TextView) findViewById(R.id.tv_nama);
        tvUsername = (TextView) findViewById(R.id.tv_username);
        btnHubungi = (TextView) findViewById(R.id.btn_hubungi);
        lvList = (ExpandableHeightListView) findViewById(R.id.lv_list);
        lvList.setExpanded(true);
    }

    private void initData(){
        int[] oke = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        for (int i = 0; i < 10; i++) {
            CatatanModel model = new CatatanModel();
            model.setIdcolor(oke[i]);
            listModel.add(model);
        }

        lvList.setAdapter(adapter);
        sv.fullScroll(View.FOCUS_UP);
    }
}
