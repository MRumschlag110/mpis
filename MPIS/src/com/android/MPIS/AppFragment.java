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
public class AppFragment extends Fragment {
	private Appointment mAppointment;
	private EditText mPatientFName;
	private EditText mPatientLName;
	private EditText mDate;
	private EditText mDoctorFName;
	private EditText mDoctorLName;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mAppointment = new Appointment();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.fragment_app, parent, false);
		mPatientFName = (EditText)v.findViewById(R.id.FirstName);
		mPatientFName.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count){
				mAppointment.setPatientFName(c.toString());
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
		mPatientLName = (EditText)v.findViewById(R.id.lastName);
		mPatientLName.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count){
				mAppointment.setPatientLName(c.toString());
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
		mDoctorFName = (EditText)v.findViewById(R.id.docFName);
		mDoctorFName.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count){
				mAppointment.setDocFName(c.toString());
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
		mDoctorLName = (EditText)v.findViewById(R.id.docLName);
		mDoctorLName.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count){
				mAppointment.setDocLName(c.toString());
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
		mDate = (EditText)v.findViewById(R.id.dateTime);
		mDate.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count){
				mAppointment.setDate(c.toString());
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
		
		mPatientFName.setText(bundle.getString("firstName", ""));
		mPatientLName.setText(bundle.getString("lastName", ""));
		mDoctorLName.setText(bundle.getString("gender", ""));
		mDoctorFName.setText(bundle.getString("address", ""));
		mDate.setText(bundle.getString("city", ""));
		}

}
