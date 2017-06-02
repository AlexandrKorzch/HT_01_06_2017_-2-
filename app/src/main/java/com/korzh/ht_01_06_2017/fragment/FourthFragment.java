package com.korzh.ht_01_06_2017.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.korzh.ht_01_06_2017.R;
import com.korzh.ht_01_06_2017.callback.FourthFragmentClickCallback;


public class FourthFragment extends Fragment {


    public static FourthFragment newInstance() {
        return new FourthFragment();
    }

    private FourthFragmentClickCallback mCallBack;

    public FourthFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallBack = (FourthFragmentClickCallback) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("CallBack not FourthFragmentClickCallback");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallBack = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fourth, container, false);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallBack.clickFromFourthFragment();
            }
        });
        return rootView;
    }
}
