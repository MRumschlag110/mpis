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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.app.ActionBar;


public class AppChooserActivity extends ListActivity{
	private ArrayList<Appointment> mAppointments = new ArrayList<Appointment>() ;
	
	AppAdapter adapter;
	Appointment[] appointments;
	
	public ArrayList<Appointment> getAppointments() {
		return mAppointments;
	}

	public void setAppointments(ArrayList<Appointment> appointments) {
		mAppointments = appointments;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);
		appointments = new Appointment[mAppointments.size()];
		for(int i = 0; i < mAppointments.size(); i++)
		{
			//Get the first profile out of each array list
			appointments[i] = (mAppointments.get(i));
		}
		
		
		doSearch();		
		
	}
	
	
    /*public boolean onCreateOptionsMenu(Menu menu) {
      
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.patient_options, menu);
        MenuItem addPatient = menu.findItem(R.id.menu_item_add_patient);
        return super.onCreateOptionsMenu(menu);
        
    }
*/
        public class AppAdapter extends ArrayAdapter<Appointment> {

	    LayoutInflater mInflater;
	    List<Appointment> list;
	    public AppAdapter(Context context, int resource, int textViewResourceId, Appointment[] appointments) {
	        super(context, resource, textViewResourceId, appointments);
	    }

	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {

	    	final Appointment a = (Appointment)appointments[position];
	        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        View row = inflater.inflate(R.layout.list_item_app, parent, false);
	        TextView firstName =  (TextView) row.findViewById(R.id.app_list_item_first_name);	        
	        TextView lastName = (TextView)row.findViewById(R.id.app_list_item_last_name);
	        firstName.setText(a.getPatientFName());
	        lastName.setText(a.getPatientLName());
	        TextView docFName = (TextView)row.findViewById(R.id.app_list_item_doc_first_name);
	        docFName.setText(a.getDocFName());
	        TextView docLName = (TextView)row.findViewById(R.id.app_list_item_doc_last_name);
	        docLName.setText(a.getDocLName());
	        TextView date = (TextView)row.findViewById(R.id.app_list_item_date);
	        date.setText(a.getDate());
	        Log.i("ProfileID","Pre Retrieval");
	        Log.i("ProfileID",String.valueOf(a.getId()));
	        parent.setTag(a.getId());
	      
	        return row;
	    }
	}
        private void doSearch() {
    		AsyncTask<String, Integer, ArrayList<Appointment>> searchTask = new AsyncTask<String, Integer, ArrayList<Appointment>>() {
                @Override
                protected ArrayList<Appointment> doInBackground(
                        String... params) {
                    URL url;

                    StringBuilder sb = new StringBuilder();
                    ArrayList<Appointment> appList = new ArrayList<Appointment>();
                    try {
                        // get URL content
                    	//template URL needs changed still
                        String templateUrl = "http://%s:8080/CS/service/appointment";
                        String address = String.format(templateUrl, Constants.IP_ADDRESS);
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
                        appList = Appointment.parseJsonListList(sb.toString());
                        appointments = new Appointment[appList.size()];
                        appointments = appList.toArray(appointments);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                return appList;
                }
                @Override
                protected void onPostExecute(ArrayList<Appointment> result) {
                    super.onPostExecute(result);


            		setListAdapter(new AppAdapter(AppChooserActivity.this, android.R.layout.list_content, R.layout.list_item_app, appointments));
            		
                    ListView lv = getListView();
                    lv.setOnItemClickListener(new OnItemClickListener() {
            			
                		
            			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            				Intent intent = new Intent(AppChooserActivity.this, AppointmentsActivity.class);
            				Log.i("ID Value", String.valueOf(id));
            				int tempID = (int)id;
            				intent.putExtra("profileListID", tempID);
            				Appointment appointment = (Appointment)parent.getItemAtPosition(position);
            				
            				//create bundle to pass data along
            				Bundle bundle = new Bundle();
            				bundle.putString("firstName", appointment.getPatientFName());
            				bundle.putString("lastName", appointment.getPatientLName());
            				bundle.putString("address", appointment.getDocFName());
            				bundle.putString("city", appointment.getDocLName());
            				bundle.putString("state", appointment.getDate());
            				intent.putExtras(bundle);
            				startActivity(intent);				
            				
                       		}});   

                }

            };
            searchTask.execute("go");
        }

        public String getGateway() { DhcpInfo d; WifiManager wifii; wifii= (WifiManager) getSystemService(Context.WIFI_SERVICE); d=wifii.getDhcpInfo(); int i = d.gateway; String gateway = ((i >> 24 ) & 0xFF ) + "." + ((i >> 16 ) & 0xFF) + "." + ((i >> 8 ) & 0xFF) + "." + ( i & 0xFF) ; return gateway;
        
        	}
}
