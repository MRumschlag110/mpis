package com.android.MPIS;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.android.MPIS.PatientChooserActivity.PatientAdapter;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class PatientActivity extends FragmentActivity{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient);
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
		//unpack bundle
		Bundle bundle = new Bundle();
		Long id = getIntent().getLongExtra("id", -1);
		if (id != -1) { 
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
		
		bundle.putLong("id", id);
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
		}
		if (fragment == null) {
			fragment = new PatientFragment();
			fragment.setArguments(bundle);
			fm.beginTransaction()
			.add(R.id.fragmentContainer, fragment)
			.commit();
		}
	
	}

	/*private void createPatient(Patient patient) {
		AsyncTask<Patient, Integer, Integer> createPatientTask = new AsyncTask<Patient, Integer, Integer>() {
			@Override
			protected Integer doInBackground(Patient... params) {
				Integer pId = 0;
				String line;
				StringBuffer jsonString = new StringBuffer();
				try {
					String templateUrl = "http://%s:8080/CS/service/patient";
                    String address = String.format(templateUrl, Constants.IP_ADDRESS);
                    
					URL url = new URL(address);
					HttpURLConnection connection = (HttpURLConnection) url
							.openConnection();
					connection.setRequestMethod("POST");
					connection.setRequestProperty("Accept", "application/json");
					connection.setRequestProperty("Content-Type",
							"application/json; charset=UTF-8");
					OutputStreamWriter writer = new OutputStreamWriter(
							connection.getOutputStream());
					writer.write(params.toString());
					writer.close();
					BufferedReader br = new BufferedReader(
							new InputStreamReader(connection.getInputStream()));
					while ((line = br.readLine()) != null) {
						jsonString.append(line);
					}
					br.close();
					connection.disconnect();
				} catch (Exception e) {
					throw new RuntimeException(e.getMessage());
				}
				return pId;
			}

			@Override
			protected void onPostExecute(Integer result) {
				super.onPostExecute(result);

			}
		};
		createPatientTask.execute(patient);

	}
*/}