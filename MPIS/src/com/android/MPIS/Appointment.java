package com.android.MPIS;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Appointment {
	private long mId;
	private String mPatientFName;
	private String mPatientLName;
	private String mDate;
	private String mDocFName;
	private String mDocLName;
	
	public String getDate() {
		return mDate;
	}

	
	
	public Appointment(){
	//	mId = UUID.randomUUID().timestamp();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		mDate = df.format(new Date()).toString();
		
		
	}

	public long getId() {
		return mId;
	}

	public void setId(long id) {
		mId = id;
	}

	public String getPatientFName() {
		return mPatientFName;
	}

	public void setPatientFName(String patientFName) {
		this.mPatientFName = patientFName;
	}

	public String getPatientLName() {
		return mPatientLName;
	}

	public void setPatientLName(String patientLName) {
		this.mPatientLName = patientLName;
	}

	/*public Date getDate() {
		return mDate;
	}
*/
	public void setDate(String date) {
		mDate = date;
	}

	public String getDocFName() {
		return mDocFName;
	}

	public void setDocFName(String docFName) {
		this.mDocFName = docFName;
	}

	public String getDocLName() {
		return mDocLName;
	}

	public void setDocLName(String docLName) {
		this.mDocLName = docLName;
	}
	
	public static Appointment fromJson(String s) {
        return new Gson().fromJson(s, Appointment.class);
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

    public Appointment(long id, String mPatientFName, String mPatientLName,
			String mDate, String mDocFName, String mDocLName) {
		super();
		mId = id;
		this.mPatientFName = mPatientFName;
		this.mPatientLName = mPatientLName;
		this.mDate = mDate;
		this.mDocFName = mDocFName;
		this.mDocLName = mDocLName;
		
		}
}
