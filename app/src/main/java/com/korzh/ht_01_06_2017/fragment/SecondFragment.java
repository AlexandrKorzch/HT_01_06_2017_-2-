package com.korzh.ht_01_06_2017.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.korzh.ht_01_06_2017.R;

import static com.korzh.ht_01_06_2017.general.Const.COLOR_KEY;


public class SecondFragment extends Fragment {

    private View mRootView;
    private int mColor;

    public static SecondFragment newInstance(int color) {
        Bundle bundle = new Bundle();
        bundle.putInt(COLOR_KEY, color);
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);
        return secondFragment;
    }

    public SecondFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey(COLOR_KEY)) {
            mColor = bundle.getInt(COLOR_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_second, container, false);
        if (mColor != 0) {
            changeBackgroundColor(mColor);
        }
        return mRootView;
    }

    public void changeBackgroundColor(int color) {
        mColor = color;
        mRootView.setBackgroundColor(mColor);
    }
}
