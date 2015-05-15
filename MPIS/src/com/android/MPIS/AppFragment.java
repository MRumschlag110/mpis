package com.android.MPIS;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AppFragment extends Fragment {
	public static final String EXTRA_APPOINTMENT_ID = "APPOINTMENT.APP_ID";
	
	 public static AppFragment newInstance(long appointmentId) {
	        Bundle args = new Bundle();
	        args.putSerializable(EXTRA_APPOINTMENT_ID, appointmentId);

	        AppFragment fragment = new AppFragment();
	        fragment.setArguments(args);

	        return fragment;
	    }
	 
	 public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
		}
	 public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
			View v = inflater.inflate(R.layout.list_item_app, parent, false);
			
	
			return v;
		}
}
