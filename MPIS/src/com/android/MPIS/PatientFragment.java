package com.android.MPIS;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
		Bundle bundle = this.getArguments();
		setFields(bundle);
	
		
		return v;
	}
	public void setFields(Bundle bundle){
		
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
