package com.android.MPIS;

import java.util.UUID;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class patientInfoFragment extends Fragment{
	public static final String EXTRA_PATIENT_ID = "patientInfo.PATIENT_ID";
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setHasOptionsMenu(true);
	}
	
	@SuppressLint("NewApi")
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.patients, parent, false);
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            //getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
			((ActionBarActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);


		}
		
		return v;
	}
	 public static patientInfoFragment newInstance(UUID patientId) {
	        Bundle args = new Bundle();
	        args.putSerializable(EXTRA_PATIENT_ID, patientId);

	        patientInfoFragment fragment = new patientInfoFragment();
	        fragment.setArguments(args);

	        return fragment;
	    }
}
