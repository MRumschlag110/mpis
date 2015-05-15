package com.android.MPIS;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
	
	public static Patient fromJson(String s) {
        return new Gson().fromJson(s, Patient.class);
    }

    public String toString() {
        return new Gson().toJson(this);
    }

    public static Object fromJson(String jsonString, Type type) {
        return new Gson().fromJson(jsonString, type);
    }

    public static ArrayList<Appointment> parseJsonListList(String jsonString) {
        ArrayList<Appointment> appList = (ArrayList<Appointment>) fromJson(jsonString,
                new TypeToken<ArrayList<Appointment>>() {
                }.getType());
        return appList;
    }

}
