package com.android.MPIS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
//This will handle patient information as a controller
public class PatientFragment extends Fragment {
	private Patient mPatient;
	private EditText mFirstName;
	private EditText mLastName;
	private EditText mAddress;
	private EditText mCity;
	private EditText mState;
	private EditText mGender;
	private EditText mRace;
	private EditText mHeight;
	private EditText mWeight;
	private EditText mInsurance;
	private EditText mPhoneNumber;
	private Button createBtn;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mPatient = new Patient();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.fragment_patient, parent, false);
		mFirstName = (EditText)v.findViewById(R.id.FirstName);
		mFirstName.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count){
				mPatient.setPatientFName(c.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		mLastName = (EditText)v.findViewById(R.id.lastName);
		mLastName.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count){
				mPatient.setPatientLName(c.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		mAddress = (EditText)v.findViewById(R.id.address);
		mAddress.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count){
				mPatient.setAddress(c.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		mCity = (EditText)v.findViewById(R.id.city);
		mCity.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count){
				mPatient.setCity(c.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		mState = (EditText)v.findViewById(R.id.state);
		mState.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count){
				mPatient.setState(c.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		mPhoneNumber = (EditText)v.findViewById(R.id.phoneNumber);
		mPhoneNumber.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count){
				mPatient.setPhoneNumber(c.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		mGender = (EditText)v.findViewById(R.id.gender);
		mGender.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count){
				mPatient.setGender(c.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		mRace = (EditText)v.findViewById(R.id.race);
		mRace.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count){
				mPatient.setRace(c.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		mWeight = (EditText)v.findViewById(R.id.weight);
		mWeight.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count){
				mPatient.setWeight(c.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		mHeight = (EditText)v.findViewById(R.id.height);
		mHeight.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count){
				mPatient.setHeight(c.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		mInsurance = (EditText)v.findViewById(R.id.insurance);
		mInsurance.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count){
				mPatient.setInsurance(c.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		createBtn = (Button)v.findViewById(R.id.update_patient_btn);
		createBtn.setOnClickListener(new OnClickListener() {
			

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				createPatient(new Patient(0, "a", "b", "c", "d", "e", "f", "gender", "race", "weight", "height", "insurance"));
				/*(long id, String patientFName, String patientLName,
						String address, String city, String state, String phoneNumber,
						String gender, String race, String weight, String height,
						String insurance)*/
			}
		});
		Bundle bundle = this.getArguments();
		setFields(bundle);
	
		
		return v;
	}
	public void setFields(Bundle bundle){
		if (bundle.getLong("id", -1) != -1) {
		mFirstName.setText(bundle.getString("firstName", ""));
		mLastName.setText(bundle.getString("lastName", ""));
		mGender.setText(bundle.getString("gender", ""));
		mAddress.setText(bundle.getString("address", ""));
		mCity.setText(bundle.getString("city", ""));
		mRace.setText(bundle.getString("race", ""));
		mInsurance.setText(bundle.getString("insurance", ""));
		mState.setText(bundle.getString("state", ""));
		mPhoneNumber.setText(bundle.getString("phoneNumber", ""));
		mWeight.setText(bundle.getString("weight", ""));
		mHeight.setText(bundle.getString("height", ""));
		}
	}
	private void createPatient(Patient patient) {
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
					
					//Find how to grab a single object from params
					writer.write(((Patient)params).toString());
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

}
