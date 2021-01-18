package com.mhs.kase.view.fragment;


import android.content.Context;
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
import com.mhs.kase.adapter.MemberAdapter;
import com.mhs.kase.model.MemberModel;
import com.mhs.kase.utils.KaseApi;
import com.mhs.kase.view.MemberDetailActivity;
import com.mhs.kase.view.TambahMemberActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class MemberFragment extends Fragment implements KaseApi {


    private View view;
    private ScrollView sv;
    private Context ctx;

    private LinearLayout btnTambah;
    private ExpandableHeightListView lvMember;

    private MemberAdapter adapter;
    private List<MemberModel> listMember = new ArrayList<>();

    public MemberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_member, container, false);
        ctx = getActivity();

        initView();

        adapter = new MemberAdapter(ctx, listMember);
        lvMember.setAdapter(adapter);

        initData();
        initClick();

        return view;
    }

    private void initView() {
        sv = (ScrollView) view.findViewById(R.id.sv);
        btnTambah = (LinearLayout) view.findViewById(R.id.btn_tambah);
        lvMember = (ExpandableHeightListView) view.findViewById(R.id.lv_member);

        lvMember.setExpanded(true);
    }

    private void initClick(){
        lvMember.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MemberModel cm = listMember.get(position);
                Intent i = new Intent(ctx, MemberDetailActivity.class);
                i.putExtra("i_name", cm.getName());
                i.putExtra("i_username", cm.getUsername());
                startActivity(i);
            }
        });

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ctx, TambahMemberActivity.class));
            }
        });
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
        //adapter.notifyDataSetChanged();
    }

    @Override
    public void executeUrl(String url, Map<String, String> params) {

    }
}