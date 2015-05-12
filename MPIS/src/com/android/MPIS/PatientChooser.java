package com.android.MPIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;



public class PatientChooser extends ListActivity{
	private ArrayList<Patient> mPatients = new ArrayList<Patient>() ;
	
	PatientAdapter adapter;
	Patient[] patients;
	
	public ArrayList<Patient> getPatients() {
		return mPatients;
	}

	public void setAppointments(ArrayList<Patient> patients) {
		mPatients = patients;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		Patient foo = new Patient();
		foo.setPatientFName("Matt");
		foo.setPatientLName("Rum");
		mPatients.add(foo);
		String whatever = foo.toString();
				
		
		
		setContentView(R.layout.patient_listview);
		patients = new Patient[mPatients.size()];
		for(int i = 0; i < mPatients.size(); i++)
		{
			//Get the first profile out of each array list
			patients[i] = (mPatients.get(i));
		}
		
		
		doSearch();		
		
	}
	
	 


/*
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//getActivity().setTitle(R.string.patient);
		setContentView(R.layout.patient_listview);
		mPatients = PatientHelper.get(getActivity()).getPatients();
	
		ArrayAdapter<Patient> adapter =
				new ArrayAdapter<Patient>(getActivity(), android.R.layout.simple_list_item_1, mPatients);
		setListAdapter(adapter);
		ListView lv = getListView();
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

				Patient c = ((PatientAdapter)getListAdapter()).getItem(position);

				Intent i = new Intent(getActivity(), PatientActivity.class);
		        i.putExtra(patientInfoFragment.EXTRA_PATIENT_ID, id);
		        startActivity(i);
		    }
		});
	}
*/	/**
    public void onListItemClick(ListView l, View v, int position, long id) {
    	ArrayAdapter<Patient> adapter =
				new ArrayAdapter<Patient>(getActivity(), android.R.layout.simple_list_item_1, mPatients);
        Patient c = adapter.getItem(position);
        // start an instance of CrimePagerActivity
        Intent i = new Intent(getActivity(), PatientActivity.class);
        i.putExtra(patientInfoFragment.EXTRA_PATIENT_ID, c.getId());
        startActivityForResult(i, 0);
    } **/
        public class PatientAdapter extends ArrayAdapter<Patient> {

	    LayoutInflater mInflater;
	    List<Patient> list;
	    public PatientAdapter(Context context, int resource, int textViewResourceId, Patient[] patients) {
	        super(context, resource, textViewResourceId, patients);
	    }

	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {

	    	final Patient p = (Patient)patients[position];
	        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        View row = inflater.inflate(R.layout.list_item_patient, parent, false);
	        TextView firstName =  (TextView) row.findViewById(R.id.patient_list_item_first_name);	        
	        TextView lastName = (TextView)row.findViewById(R.id.patient_list_item_last_name);
	        firstName.setText(p.getPatientFName());
	        lastName.setText(p.getPatientLName());
	        Log.i("ProfileID","Pre Retrieval");
	        Log.i("ProfileID",String.valueOf(p.getId()));
	        parent.setTag(p.getId());
	      
	           
	        return row;
	    }
	}
        private void doSearch() {
    		AsyncTask<String, Integer, ArrayList<Patient>> searchTask = new AsyncTask<String, Integer, ArrayList<Patient>>() {
                @Override
                protected ArrayList<Patient> doInBackground(
                        String... params) {
                    URL url;

                    StringBuilder sb = new StringBuilder();
                    ArrayList<Patient> patientList = new ArrayList<Patient>();
                    try {
                        // get URL content
                        String templateUrl = "http://%s:8080/CS/service/patient";
                        String address = String.format(templateUrl, "192.168.173.1");
                        Log.i("ipAddress", getGateway());
                        url = new URL(address);
                        URLConnection conn = url.openConnection();

                        // open the stream and put it into BufferedReader
                        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String inputLine;
                        while ((inputLine = br.readLine()) != null) {
                            sb.append(inputLine);
                            System.out.println(inputLine);
                        }
                        br.close();
                        patientList = Patient.parseJsonListList(sb.toString());
                        patients = new Patient[patientList.size()];
                        patients = patientList.toArray(patients);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                return patientList;
                }
                @Override
                protected void onPostExecute(ArrayList<Patient> result) {
                    super.onPostExecute(result);


            		setListAdapter(new PatientAdapter(PatientChooser.this, android.R.layout.simple_list_item_1, R.id.patient_list_item_first_name, patients));
            		
                    ListView lv = getListView();
                    lv.setOnItemClickListener(new OnItemClickListener() {
            			
                		
            			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            				Intent intent = new Intent(PatientChooser.this, PatientActivity.class);
            				Log.i("ID Value", String.valueOf(id));
            				int tempID = (int)id;
            				intent.putExtra("profileListID", tempID);
            				startActivity(intent);				
            		}});   

                }

            };
            searchTask.execute("go");
        }

        public String getGateway() { DhcpInfo d; WifiManager wifii; wifii= (WifiManager) getSystemService(Context.WIFI_SERVICE); d=wifii.getDhcpInfo(); int i = d.gateway; String gateway = ((i >> 24 ) & 0xFF ) + "." + ((i >> 16 ) & 0xFF) + "." + ((i >> 8 ) & 0xFF) + "." + ( i & 0xFF) ; return gateway;
        
        	}
        
}
