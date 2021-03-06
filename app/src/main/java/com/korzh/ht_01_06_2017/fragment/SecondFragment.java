package com.korzh.ht_01_06_2017.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.korzh.ht_01_06_2017.R;
import com.korzh.ht_01_06_2017.callback.SecondFragmentClickCallBack;


public class SecondFragment extends Fragment {

    private SecondFragmentClickCallBack mCallBack;

    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    public SecondFragment() {
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallBack = (SecondFragmentClickCallBack) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("CallBack not SecondFragmentClickCallBack");
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
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallBack.clickFromSecondFragment();
            }
        });
        return rootView;
    }
}
