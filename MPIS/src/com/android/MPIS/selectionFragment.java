package com.android.MPIS;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class selectionFragment extends Fragment {
	private Button mPatientBtn; 
	@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	       // setHasOptionsMenu(true);
	        //setRetainInstance(true);
	        
	       
	 }
/**	
	 public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		 View v = inflater.inflate(R.layout.selection_fragment, parent, false);
		 
		 mPatientBtn = (Button) v.findViewById(R.id.patientInfoButton);
	        mPatientBtn.setOnClickListener(new View.OnClickListener(){
	        	@Override
	        	public void onClick(View v){
	        		Intent i = new Intent(, PatientsActivity.class);
	        		startActivity(i);
	        	}
	        });
		 return v;
	 }
	
	 public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
			super.onCreateOptionsMenu(menu);
			inflater.inflate(R.menu.mpi, menu);
		}
	 @Override
	 public boolean onOptionsItemSelected(MenuItem item){
		 
		 switch (item.getItemId()){
		 case R.id.menu_item_patientInfo:
		/**	patientInfoFragment patients = new patientInfoFragment();
			 getFragmentManager().beginTransaction()
	         .replace(R.id.fragmentContainer, patients).commit();
			
			
			 break;
		 default:
				 return super.onOptionsItemSelected(item);
		 }
		 return true;
	 }
	 **/
}
