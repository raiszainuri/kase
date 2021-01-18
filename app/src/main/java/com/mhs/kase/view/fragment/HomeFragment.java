package com.mhs.kase.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.github.paolorotolo.expandableheightlistview.ExpandableHeightListView;
import com.mhs.kase.R;
import com.mhs.kase.adapter.CatatanAdapter;
import com.mhs.kase.anim.ProgressBarAnimation;
import com.mhs.kase.model.CatatanModel;
import com.mhs.kase.utils.KaseApi;
import com.mhs.kase.view.CatatanDetailActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HomeFragment extends Fragment implements KaseApi {

    private Context ctx;

    private View view;
    private ScrollView sv;
    private ProgressBar progressBar;
    private TextView tvProgressBar;
    private ExpandableHeightListView lvcatatan;

    private CatatanAdapter adapter;
    private List<CatatanModel> listModel = new ArrayList<>();
    private TextView tvTotal;
    private LinearLayout llClickLaporan;
    private TextView tvTitle;
    private TextView tvSubtitle;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        ctx = getActivity();

        initView();

        final ProgressBarAnimation anim = new ProgressBarAnimation(progressBar, 0, 70);
        anim.setDuration(2000);
        progressBar.startAnimation(anim);

        adapter = new CatatanAdapter(getActivity(), listModel);
        lvcatatan.setAdapter(adapter);

        initData();
        initClick();

        return view;
    }

    private void initView() {
        sv = view.findViewById(R.id.sv);
        lvcatatan = view.findViewById(R.id.lvcatatan);
        progressBar = view.findViewById(R.id.progressBar);
        tvProgressBar = view.findViewById(R.id.tv_progress_bar);

        lvcatatan.setExpanded(true);
        tvTotal = view.findViewById(R.id.tv_total);
        llClickLaporan = view.findViewById(R.id.ll_click_laporan);
        tvTitle = view.findViewById(R.id.tv_title);
        tvSubtitle = view.findViewById(R.id.tv_subtitle);
    }

    private void initData() {
        int[] oke = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        for (int i = 0; i < 10; i++) {
            CatatanModel model = new CatatanModel();
            model.setIdcolor(oke[i]);
            model.setBiaya(2000);
            model.setNama("Uang Title");
            model.setKeterangan("Ini keterangan ~");
            listModel.add(model);
        }
        //adapter.notifyDataSetChanged();
        lakukan ll = new lakukan();
        //ll.lakukanlagi();
    }

    @Override
    public void executeUrl(String url, Map<String, String> params) {

    }

    public class lakukan {
        /*public void lakukanlagi() {
            int[] oke = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
            try {
                JSONArray jArray = apiUrl.executeUrl("");
                JSONObject obj;
                for (int i = 0; i < 10; i++) {
                    obj = jArray.getJSONObject(i);
                    CatatanModel model = new CatatanModel();
                    model.setIdcolor(oke[i]);
                    model.setBiaya(obj.getInt(""));
                    model.setNama(obj.getString(""));
                    model.setKeterangan(obj.getString(""));
                    listModel.add(model);
                }
            } catch (Exception ex) {

            }
        }*/
    }

    private void retrieveData() {
        /*int[] oke = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        try {
            JSONArray jArray = apiUrl.executeUrl("");
            JSONObject obj;
            for (int i = 0; i < 10; i++) {
                obj = jArray.getJSONObject(i);
                CatatanModel model = new CatatanModel();
                model.setIdcolor(oke[i]);
                model.setBiaya(obj.getInt(""));
                model.setNama(obj.getString(""));
                model.setKeterangan(obj.getString(""));
                listModel.add(model);
            }
        } catch (Exception ex) {

        }*/
    }

    private void initClick() {
        lvcatatan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CatatanModel cm = listModel.get(position);
                Intent i = new Intent(getActivity(), CatatanDetailActivity.class);
                i.putExtra("i_title", cm.getNama());
                i.putExtra("i_desc", cm.getKeterangan());
                i.putExtra("i_price", cm.getBiaya());
                startActivity(i);
            }
        });
    }
}