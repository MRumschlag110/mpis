package com.android.MPIS;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;

public class AppHelper {
	private static AppHelper sAppHelper;
	private ArrayList<Appointment> mAppointments;
	private ArrayList<String> mDoctors;
	private Context mAppContext;
	
	private AppHelper(Context appContext) {
		mAppContext = appContext;
		mAppointments = new ArrayList<Appointment>();
		for (int i = 0; i < 100; i++){
			Appointment a = new Appointment();
			a.setDocFName(String.valueOf(i));
			a.setDocLName(String.valueOf(i));
			a.setPatientFName(String.valueOf(i));
			a.setPatientLName(String.valueOf(i));
			mAppointments.add(a);
		}
	}
	
	public ArrayList<Appointment> getAppointments(){
		return mAppointments;
	}
	
	public Appointment getAppointment(UUID id){
		for (Appointment c : mAppointments){
			if (c.getId().equals(id))
				return c;
		}
		return null;
	}
	public static AppHelper get(Context c){
		if (sAppHelper == null){
			sAppHelper = new AppHelper(c.getApplicationContext());
		}
		return sAppHelper;
	}
}
