package com.korzh.ht_01_06_2017.activity;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.korzh.ht_01_06_2017.R;
import com.korzh.ht_01_06_2017.callback.FirstFragmentClickCallBack;
import com.korzh.ht_01_06_2017.fragment.FirstFragment;
import com.korzh.ht_01_06_2017.fragment.SecondFragment;

import static com.korzh.ht_01_06_2017.general.Const.COLOR_KEY;

public class MainActivity extends AppCompatActivity implements FirstFragmentClickCallBack {

    private SecondFragment mSecondFragment;
    private int mSecondFragmentColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null && savedInstanceState.containsKey(COLOR_KEY)) {
            mSecondFragmentColor = savedInstanceState.getInt(COLOR_KEY);
        }
        if (isPortraitOrientation()) {
            initPortraitScreen();
        } else {
            initLandscapScreen();
        }
    }

    private void initPortraitScreen() {
        showFragment(FirstFragment.newInstance(), R.id.container_portrait);
    }

    private void initLandscapScreen() {
        mSecondFragment = (SecondFragment) createSecondFragment(mSecondFragmentColor);
        showFragment(FirstFragment.newInstance(), R.id.container_left);
        showFragment(mSecondFragment, R.id.container_right);
    }

    private void showFragment(Fragment fragment, int containerId) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .commit();
    }

    @Override
    public void clickFromFirstFragment() {
        mSecondFragmentColor = Color.BLUE;
        if (mSecondFragment == null) {
            showFragment(createSecondFragment(mSecondFragmentColor), R.id.container_portrait);
        } else {
            mSecondFragment.changeBackgroundColor(mSecondFragmentColor);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COLOR_KEY, mSecondFragmentColor);
    }

    private Fragment createSecondFragment(int color) {
        return SecondFragment.newInstance(color);
    }

    private boolean isPortraitOrientation() {
        return getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
    }
}
