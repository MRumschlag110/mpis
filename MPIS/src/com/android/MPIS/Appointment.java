package com.android.MPIS;

import java.util.Date;
import java.util.UUID;

public class Appointment {
	private long mId;
	private String patientFName;
	private String patientLName;
	private Date mDate;
	private String docFName;
	private String docLName;
	
	public Appointment(){
		mId = UUID.randomUUID().timestamp();
		mDate = new Date();
		
	}

	public long getId() {
		return mId;
	}

	public void setId(long id) {
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

	public Date getDate() {
		return mDate;
	}

	public void setDate(Date date) {
		mDate = date;
	}

	public String getDocFName() {
		return docFName;
	}

	public void setDocFName(String docFName) {
		this.docFName = docFName;
	}

	public String getDocLName() {
		return docLName;
	}

	public void setDocLName(String docLName) {
		this.docLName = docLName;
	}
	@Override
	public String toString() {
		return patientFName + " " + patientLName + "\n" + docFName + " " + docLName + "\n" + mDate;
	}
}
