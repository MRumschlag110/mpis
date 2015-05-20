package com.android.MPIS;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class MPISActivity extends ActionBarActivity {
	private Button mPatientBtn;
	private Button mAppBtn;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_fragment);
       /** 
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            fragment = new selectionFragment();
            manager.beginTransaction()
                .add(R.id.fragmentContainer, fragment)
                .commit();
        }**/
        mPatientBtn = (Button)findViewById(R.id.patientInfoButton);
        mPatientBtn.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v){
        	
        		Intent i = new Intent(MPISActivity.this, PatientChooserActivity.class);
        		startActivity(i);
        		
        		}
        });       
        mAppBtn = (Button)findViewById(R.id.appointmentButton);
        mAppBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MPISActivity.this, AppChooserActivity.class);
				startActivity(i);
			}
		});

    }
	
	
}

