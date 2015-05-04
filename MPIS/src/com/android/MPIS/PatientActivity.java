package com.android.MPIS;

import java.util.UUID;

import android.support.v4.app.Fragment;

public class PatientActivity extends SingleFragmentActivity {
	@Override
    protected Fragment createFragment() {
        UUID patientId = (UUID)getIntent()
            .getSerializableExtra(patientInfoFragment.EXTRA_PATIENT_ID);
        return patientInfoFragment.newInstance(patientId);
    }
	
}
