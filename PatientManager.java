import java.io.*;
import java.util.*;
public class PatientManager {
    private User loggedUser;
    private ArrayList<Patient> patientArrayList;
    private String patientFileName;

    public PatientManager(User loggedUser, ArrayList<Patient> patientArrayList, String patientFileName){
        this.loggedUser = loggedUser;
        this.patientArrayList = patientArrayList;
        this.patientFileName = patientFileName;
    }

    public void viewProfile(){
        loggedUser.toString();
    }


    public Patient patientSearch(int id){
        Patient foundPatient;

        if(loggedUser instanceof MedicalStaff){

        }

        return foundPatient;
    }

    public void patientEdit(Patient curPatient){

    }
}

/*
After successful login, create a PatientManager object.

What PatientManager stores:

The current user (who logged in).

An ArrayList of all Patients (load from the patients file).

What PatientManager can do:

View current user’s profile.

If Medical Staff:

Search for a Patient by id (Binary Search) and view their profile.

Edit a Patient’s profile (except id and username).

Save all changes back to the file.

If Patient:

Only view and edit their own profile.
*/