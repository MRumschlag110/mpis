package com.android.MPIS;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class PatientChooser extends ListFragment{
	private ArrayList<Patient> mPatients;
	
	public ArrayList<Patient> getPatients() {
		return mPatients;
	}

	public void setAppointments(ArrayList<Patient> patients) {
		mPatients = patients;
	}

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.patient);
		mPatients = PatientHelper.get(getActivity()).getPatients();
	
		ArrayAdapter<Patient> adapter =
				new ArrayAdapter<Patient>(getActivity(), android.R.layout.simple_list_item_1, mPatients);
		setListAdapter(adapter);
	}
	/**
    public void onListItemClick(ListView l, View v, int position, long id) {
    	ArrayAdapter<Patient> adapter =
				new ArrayAdapter<Patient>(getActivity(), android.R.layout.simple_list_item_1, mPatients);
        Patient c = adapter.getItem(position);
        // start an instance of CrimePagerActivity
        Intent i = new Intent(getActivity(), PatientActivity.class);
        i.putExtra(patientInfoFragment.EXTRA_PATIENT_ID, c.getId());
        startActivityForResult(i, 0);
    } **/
    private class PatientAdapter extends ArrayAdapter<Patient> {
        public PatientAdapter(ArrayList<Patient> crimes) {
            super(getActivity(), android.R.layout.simple_list_item_1, mPatients);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // if we weren't given a view, inflate one
            if (null == convertView) {
                convertView = getActivity().getLayoutInflater()
                    .inflate(R.layout.patients, null);
            }

            // configure the view for this Crime
            Patient c = getItem(position);

            TextView titleTextView =
                (TextView)convertView.findViewById(R.id.patient_list_item_first_name);
            titleTextView.setText(c.getPatientFName());
            TextView lastName =
                (TextView)convertView.findViewById(R.id.patient_list_item_last_name);
            lastName.setText(c.getPatientLName().toString());
               

            return convertView;
        }
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        // get the Crime from the adapter
        Patient c = ((PatientAdapter)getListAdapter()).getItem(position);
        // start an instance of CrimePagerActivity
        Intent i = new Intent(getActivity(), PatientPagerActivity.class);
        i.putExtra(patientInfoFragment.EXTRA_PATIENT_ID, c.getId());
        startActivityForResult(i, 0);
    }
}
