package com.mhs.kase.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.mhs.kase.R;
import com.mhs.kase.adapter.CatatanAdapter;
import com.mhs.kase.anim.ProgressBarAnimation;
import com.mhs.kase.model.CatatanModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private ProgressBar progressBar;
    private TextView tv_progress_bar;
    private View view;
    private Context ctx;
    private int awal = 0, akhir = 70;
    private TextView tvProgressBar;
    private ListView lvcatatan;

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

        final ProgressBarAnimation anim = new ProgressBarAnimation(progressBar, 0, 70);
        anim.setDuration(2000);
        progressBar.startAnimation(anim);

        adapter = new CatatanAdapter(getActivity(),listModel);
        adapter.notifyDataSetChanged();

        int[] oke = {1,2,3,4,5,1,2,3,4,5};
        for (int i = 0; i < 10; i++){
            CatatanModel model = new CatatanModel();
            model.setIdcolor(oke[i]);
            listModel.add(model);
        }

        lvcatatan.setAdapter(adapter);

        return view;
    }

    private void initView() {
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        tv_progress_bar = (TextView) view.findViewById(R.id.tv_progress_bar);
        tvProgressBar = (TextView) view.findViewById(R.id.tv_progress_bar);
        lvcatatan = (ListView) view.findViewById(R.id.lvcatatan);
    }
}
