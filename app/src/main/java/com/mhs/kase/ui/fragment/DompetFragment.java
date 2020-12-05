package com.mhs.kase.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mhs.kase.R;

public class DompetFragment extends Fragment {
    public DompetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_dompet, container, false);
        return inflater.inflate(R.layout.fragment_dompet, container, false);
    }

}
