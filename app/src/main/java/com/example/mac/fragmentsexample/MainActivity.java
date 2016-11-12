package com.example.mac.fragmentsexample;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;


/*Goal is to understand the mechanics of creating Fragments */
/*Lets assume we have a section for Basic details - which includes firstName, lastName, dateOfBirth and gender */
/*and we have another section for professional details -
which includes companyName, employeeId, department and designation  */

/*we will have two activities in our app  */
/*If it is a phone, only basic details will be shown on the main activity and for professional details
* another activity will be shown when user clicks on Show more details btn */

/*If it is a tablet/device with screen larger than 7 inches, both the sections will be shown on the same
 * activity. The Show more details Btn will not be shown for large screens */

/*so, first create a Fragment for Basic Details and Professional Details */


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //every layout has the ViewGroup android.R.id.content as its parent
        ViewGroup view = (ViewGroup) findViewById(android.R.id.content);


        //we added the BasicDetailsFragment - this will be added to normal as well as large devices
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        BasicDetailsFragment basicDetailsFragment = new BasicDetailsFragment();
        fragmentTransaction.add(R.id.basicdetails, basicDetailsFragment);

        //the professional details fragment will be added only to larger screens
        if (findViewById(R.id.activity_main).getTag().equals("large")) {
            Log.d("Debug", "Seems to be a larger screen");

            ProfessionalDetailsFragment professionalDetailsFragment = new ProfessionalDetailsFragment();
            fragmentTransaction.add(R.id.professionaldetails, professionalDetailsFragment);

        }

        fragmentTransaction.commit();


    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
