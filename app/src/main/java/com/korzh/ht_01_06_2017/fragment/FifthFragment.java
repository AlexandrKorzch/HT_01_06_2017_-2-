package com.korzh.ht_01_06_2017.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.korzh.ht_01_06_2017.R;

public class FifthFragment extends Fragment {

    public static FifthFragment newInstance() {
        return new FifthFragment();
    }

    public FifthFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fifth, container, false);
    }
}
