package com.mhs.kase.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.fragment.app.Fragment;

import com.github.paolorotolo.expandableheightlistview.ExpandableHeightListView;
import com.mhs.kase.R;
import com.mhs.kase.adapter.CatatanAdapter;
import com.mhs.kase.model.CatatanModel;
import com.mhs.kase.ui.CatatanDetailActivity;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.OnItemClickListener;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.ArrayList;
import java.util.List;


public class HistoryFragment extends Fragment {


    private ScrollView sv;
    private LinearLayout btnFilter;
    private ExpandableHeightListView lvHistory;

    private CatatanAdapter adapter;
    private List<CatatanModel> listModel = new ArrayList<>();

    private View view;

    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_catatan, container, false);

        initView();
        adapter = new CatatanAdapter(getActivity(), listModel);
        adapter.notifyDataSetChanged();
        initData();
        initClick();

        return
                view;
    }

    private void showDialog() {
        DialogPlus dialog = DialogPlus.newDialog(getActivity())
                .setHeader(R.layout.header_dialog)
                .setContentHolder(new ViewHolder(R.layout.dialog_filter_catatan))
                .setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                    }
                })
                .setExpanded(false)  // This will enable the expand feature, (similar to android L share dialog)
                .create();
        dialog.show();
    }


    private void initView() {
        sv = (ScrollView) view.findViewById(R.id.sv);
        btnFilter = (LinearLayout) view.findViewById(R.id.btn_filter);
        lvHistory = (ExpandableHeightListView) view.findViewById(R.id.lv_history);
        lvHistory.setExpanded(true);
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

        lvHistory.setAdapter(adapter);
        sv.fullScroll(View.FOCUS_UP);
    }

    private void initClick() {
        lvHistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }
}
