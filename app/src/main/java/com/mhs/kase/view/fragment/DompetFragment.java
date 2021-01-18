package com.mhs.kase.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;
import com.mhs.kase.R;
import com.mhs.kase.utils.KaseApi;

import java.util.Map;

public class DompetFragment extends Fragment implements KaseApi {
    private TabLayout tblayout;
    private LinearLayout btnTambah;
    private View view;

    public DompetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_dompet, container, false);
        view = inflater.inflate(R.layout.fragment_dompet, container, false);
        initView();
        tblayout.setTabTextColors(getResources().getColor(R.color.t_dark), getResources().getColor(R.color.white));
        tblayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.white));
        return view; 
    }

    private void initView() {
        tblayout = (TabLayout) view.findViewById(R.id.tblayout);
        btnTambah = (LinearLayout) view.findViewById(R.id.btn_tambah);
    }

    @Override
    public void executeUrl(String url, Map<String, String> params) {

    }
}
