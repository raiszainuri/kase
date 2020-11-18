package com.mhs.kase.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.mhs.kase.R;
import com.mhs.kase.adapter.CatatanAdapter;
import com.mhs.kase.anim.ProgressBarAnimation;
import com.mhs.kase.model.CatatanModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private Context ctx;

    private View view;
    private ScrollView sv;
    private ProgressBar progressBar;
    private TextView tvProgressBar;
    private TextView tv_progress_bar;
    private com.github.paolorotolo.expandableheightlistview.ExpandableHeightListView lvcatatan;

    private CatatanAdapter adapter;
    private List<CatatanModel> listModel = new ArrayList<>();

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

        adapter = new CatatanAdapter(getActivity(), listModel);
        adapter.notifyDataSetChanged();

        final ProgressBarAnimation anim = new ProgressBarAnimation(progressBar, 0, 70);
        anim.setDuration(2000);
        progressBar.startAnimation(anim);

        initData();

        return view;
    }

    private void initView() {
        sv = view.findViewById(R.id.sv);
        lvcatatan =  view.findViewById(R.id.lvcatatan);
        lvcatatan.setExpanded(true);
        progressBar =  view.findViewById(R.id.progressBar);
        tvProgressBar =  view.findViewById(R.id.tv_progress_bar);
        tv_progress_bar =  view.findViewById(R.id.tv_progress_bar);
    }

    private void initData(){
        int[] oke = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        for (int i = 0; i < 10; i++) {
            CatatanModel model = new CatatanModel();
            model.setIdcolor(oke[i]);
            listModel.add(model);
        }

        lvcatatan.setAdapter(adapter);
        sv.fullScroll(View.FOCUS_UP);
    }
}
