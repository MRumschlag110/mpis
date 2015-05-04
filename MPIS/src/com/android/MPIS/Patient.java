package com.android.MPIS;

import java.util.Date;
import java.util.UUID;

public class Patient {
	private UUID mId;
	private String patientFName;
	private String patientLName;
	
	public Patient(){
		mId = UUID.randomUUID();
		
		
	}

	public UUID getId() {
		return mId;
	}

	public void setId(UUID id) {
		mId = id;
	}

	public String getPatientFName() {
		return patientFName;
	}

	public void setPatientFName(String patientFName) {
		this.patientFName = patientFName;
	}

	public String getPatientLName() {
		return patientLName;
	}

	public void setPatientLName(String patientLName) {
		this.patientLName = patientLName;
	}


	
	@Override
	public String toString() {
		return patientFName + " " + patientLName;
	}
}
