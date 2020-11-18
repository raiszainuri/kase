package com.mhs.kase.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.fragment.app.Fragment;

import com.github.paolorotolo.expandableheightlistview.ExpandableHeightListView;
import com.mhs.kase.R;
import com.mhs.kase.adapter.MemberAdapter;
import com.mhs.kase.model.CatatanModel;
import com.mhs.kase.model.MemberModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    private View view;
    private ScrollView sv;
    private Context ctx;

    private LinearLayout btnTambah;
    private ExpandableHeightListView lvMember;

    private MemberAdapter adapter;
    private List<MemberModel> listMember = new ArrayList<>();

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        ctx = getActivity();

        adapter = new MemberAdapter(ctx, listMember);
        adapter.notifyDataSetChanged();

        initView();
        initData();

        return view;
    }

    private void initView() {
        sv = (ScrollView)view.findViewById(R.id.sv);
        btnTambah = (LinearLayout) view.findViewById(R.id.btn_tambah);
        lvMember = (ExpandableHeightListView) view.findViewById(R.id.lv_member);
        lvMember.setExpanded(true);
    }

    private void initData() {
        int[] oke = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        for (int i = 0; i < 10; i++) {
            MemberModel model = new MemberModel();
            model.setIdcolor(oke[i]);
            model.setName("Nama");
            model.setUsername("@username");
            listMember.add(model);
        }

        lvMember.setAdapter(adapter);
        sv.fullScroll(View.FOCUS_UP);
    }
}
