package com.android.MPIS;

import java.util.ArrayList;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import android.support.v4.view.ViewPager;

public class PatientPagerActivity extends FragmentActivity {
    ViewPager mViewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.viewPager);
        setContentView(mViewPager);

        final ArrayList<Patient> patients = PatientHelper.get(this).getPatients();
        
        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public int getCount() {
                return patients.size();
            }
            @Override
            public Fragment getItem(int pos) {
                long crimeId =  patients.get(pos).getId();
                return patientInfoFragment.newInstance(crimeId);
            }
        }); 

        long patientId = (long)getIntent().getLongExtra(patientInfoFragment.EXTRA_PATIENT_ID, 0);
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == patientId) {
                mViewPager.setCurrentItem(i);
                break;
            } 
        }
    }
}
