package com.android.MPIS;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AppFragment extends ListFragment{
	private ArrayList<Appointment> mAppointments;
	
	public ArrayList<Appointment> getAppointments() {
		return mAppointments;
	}

	public void setAppointments(ArrayList<Appointment> appointments) {
		mAppointments = appointments;
	}

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.appointment);
		mAppointments = AppHelper.get(getActivity()).getAppointments();
	
		ArrayAdapter<Appointment> adapter =
				new ArrayAdapter<Appointment>(getActivity(), android.R.layout.simple_list_item_1, mAppointments);
		setListAdapter(adapter);
	}
	@Override
	public void onListItemClick(ListView l, View v, int position, long id){
		Appointment app = (Appointment)(getListAdapter()).getItem(position);
	}
	
}
