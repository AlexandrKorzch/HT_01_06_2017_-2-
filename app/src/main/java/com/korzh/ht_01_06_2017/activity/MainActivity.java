package com.korzh.ht_01_06_2017.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.korzh.ht_01_06_2017.R;
import com.korzh.ht_01_06_2017.callback.MainInterface;
import com.korzh.ht_01_06_2017.fragment.FifthFragment;
import com.korzh.ht_01_06_2017.fragment.FirstFragment;
import com.korzh.ht_01_06_2017.fragment.FourthFragment;
import com.korzh.ht_01_06_2017.fragment.SecondFragment;
import com.korzh.ht_01_06_2017.fragment.ThirdFragment;

import static com.korzh.ht_01_06_2017.general.Const.FIFTH;
import static com.korzh.ht_01_06_2017.general.Const.FIRST;
import static com.korzh.ht_01_06_2017.general.Const.FOURTH;
import static com.korzh.ht_01_06_2017.general.Const.FRAGMENT_POSITION;
import static com.korzh.ht_01_06_2017.general.Const.SECOND;
import static com.korzh.ht_01_06_2017.general.Const.THIRD;

public class MainActivity extends AppCompatActivity implements MainInterface {

    private int mFragmentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null && savedInstanceState.containsKey(FRAGMENT_POSITION)){
            mFragmentPosition = savedInstanceState.getInt(FRAGMENT_POSITION);
        }
        showFragment();
    }

    private void showFragment() {
        Fragment fragment = getFragment(mFragmentPosition);
        String fragmentTag = fragment.getClass().getSimpleName();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(fragmentManager.findFragmentByTag(fragmentTag) == null){
            fragmentTransaction
                    .replace(R.id.container, fragment, fragmentTag)
                    .addToBackStack(fragmentTag);
        }else{
            fragmentTransaction
                    .replace(R.id.container, fragment);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void clickFromFirstFragment() {
        mFragmentPosition = SECOND;
        showFragment();
    }

    @Override
    public void clickFromSecondFragment() {
        mFragmentPosition = THIRD;
        showFragment();
    }

    @Override
    public void clickFromThirdFragment() {
        mFragmentPosition = FOURTH;
        showFragment();
    }

    @Override
    public void clickFromFourthFragment() {
        mFragmentPosition = FIFTH;
        showFragment();
    }

    private Fragment getFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case FIRST:
                fragment = FirstFragment.newInstance();
                break;
            case SECOND:
                fragment = SecondFragment.newInstance();
                break;
            case THIRD:
                fragment = ThirdFragment.newInstance();
                break;
            case FOURTH:
                fragment = FourthFragment.newInstance();
                break;
            case FIFTH:
                fragment = FifthFragment.newInstance();
        }
        return fragment;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(FRAGMENT_POSITION, mFragmentPosition);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
            super.onBackPressed();
        }
    }
}
