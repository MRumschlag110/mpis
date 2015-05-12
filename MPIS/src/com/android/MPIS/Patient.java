package com.android.MPIS;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Patient {
	private long mId;
	private String patientFName;
	private String patientLName;
	private String mAddress;
	private String mCity;
	private String mState;
	private String mPhoneNumber;
	private String mGender;
	private String mRace;
	private String mWeight;
	private String mHeight;
	private String mInsurance;
	
	
	
	
	public Patient(long id, String patientFName, String patientLName,
			String address, String city, String state, String phoneNumber,
			String gender, String race, String weight, String height,
			String insurance) {
		super();
		mId = id;
		this.patientFName = patientFName;
		this.patientLName = patientLName;
		mAddress = address;
		mCity = city;
		mState = state;
		mPhoneNumber = phoneNumber;
		mGender = gender;
		mRace = race;
		mWeight = weight;
		mHeight = height;
		mInsurance = insurance;
	}

	public String getAddress() {
		return mAddress;
	}

	public void setAddress(String address) {
		mAddress = address;
	}

	public String getCity() {
		return mCity;
	}

	public void setCity(String city) {
		mCity = city;
	}

	public String getState() {
		return mState;
	}

	public void setState(String state) {
		mState = state;
	}

	public String getPhoneNumber() {
		return mPhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		mPhoneNumber = phoneNumber;
	}

	public String getGender() {
		return mGender;
	}

	public void setGender(String gender) {
		mGender = gender;
	}

	public String getRace() {
		return mRace;
	}

	public void setRace(String race) {
		mRace = race;
	}

	public String getWeight() {
		return mWeight;
	}

	public void setWeight(String weight) {
		mWeight = weight;
	}

	public String getHeight() {
		return mHeight;
	}

	public void setHeight(String height) {
		mHeight = height;
	}

	public String getInsurance() {
		return mInsurance;
	}

	public void setInsurance(String insurance) {
		mInsurance = insurance;
	}

	public Patient(){
		mId = new Date().getTime();
		
		
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


	
	
	public static Patient fromJson(String s) {
        return new Gson().fromJson(s, Patient.class);
    }

    public String toString() {
        return new Gson().toJson(this);
    }

    public static Object fromJson(String jsonString, Type type) {
        return new Gson().fromJson(jsonString, type);
    }

    public static ArrayList<Patient> parseJsonListList(String jsonString) {
        ArrayList<Patient> playersList = (ArrayList<Patient>) fromJson(jsonString,
                new TypeToken<ArrayList<Patient>>() {
                }.getType());
        return playersList;
    }

}
