package com.android.MPIS;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class AppointmentsActivity extends FragmentActivity{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment);
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
		//unpack bundle
		String fName = getIntent().getStringExtra("firstName");
		String lName = getIntent().getStringExtra("lastName");
		String docFName = getIntent().getStringExtra("docFName");
		String docLName = getIntent().getStringExtra("docLName");
		String date = getIntent().getStringExtra("date");
		Bundle bundle = new Bundle();
		bundle.putString("firstName", fName);
		bundle.putString("lastName", lName);
		bundle.putString("docFName", docFName);
		bundle.putString("docLName", docLName);
		bundle.putString("date", date);
		if (fragment == null) {
			fragment = new AppFragment();
			fragment.setArguments(bundle);
			fm.beginTransaction()
			.add(R.id.fragmentContainer, fragment)
			.commit();
		}
	
	}
	
}
