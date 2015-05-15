package com.android.MPIS;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class PatientActivity extends FragmentActivity{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient);
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
		//unpack bundle
		String fName = getIntent().getStringExtra("firstName");
		String lName = getIntent().getStringExtra("lastName");
		String address = getIntent().getStringExtra("address");
		String city = getIntent().getStringExtra("city");
		String state = getIntent().getStringExtra("state");
		String phoneNumber = getIntent().getStringExtra("phoneNumber");
		String insurance = getIntent().getStringExtra("insurance");
		String gender = getIntent().getStringExtra("gender");
		String race = getIntent().getStringExtra("race");
		String weight = getIntent().getStringExtra("weight");
		String height = getIntent().getStringExtra("height");
		Bundle bundle = new Bundle();
		bundle.putString("firstName", fName);
		bundle.putString("lastName", lName);
		bundle.putString("address", address);
		bundle.putString("city", city);
		bundle.putString("state", state);
		bundle.putString("phoneNumber", phoneNumber);
		bundle.putString("insurance", insurance);
		bundle.putString("gender", gender);
		bundle.putString("race", race);
		bundle.putString("weight", weight);
		bundle.putString("height", height);
		if (fragment == null) {
			fragment = new PatientFragment();
			fragment.setArguments(bundle);
			fm.beginTransaction()
			.add(R.id.fragmentContainer, fragment)
			.commit();
		}
	
	}
	
}
