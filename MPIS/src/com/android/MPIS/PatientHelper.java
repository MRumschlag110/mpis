package com.android.MPIS;

import java.util.ArrayList;

import android.content.Context;


public class PatientHelper {
	private static PatientHelper sPatientHelper;
	private ArrayList<Patient> mPatients;
	
	private PatientHelper(Context appContext) {
		mPatients = new ArrayList<Patient>();
		for (int i = 0; i < 100; i++){
			Patient a = new Patient();
			a.setPatientFName(String.valueOf(i));
			a.setPatientLName(String.valueOf(i));
			mPatients.add(a);
		}
	}
	
	public ArrayList<Patient> getPatients(){
		return mPatients;
	}
	
	public Patient getPatients(long id){
		for (Patient c : mPatients){
			if (c.getId() == (id))
				return c;
		}
		return null;
	}
	public static PatientHelper get(Context c){
		if (sPatientHelper == null){
			sPatientHelper = new PatientHelper(c.getApplicationContext());
		}
		return sPatientHelper;
	}
}
