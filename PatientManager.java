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
        System.out.println(loggedUser.toString());
    }


    public Patient patientBinarySearch(int id){ //binary sort 

        if(loggedUser instanceof MedicalStaff){
            int start = 0;
            int end = patientArrayList.size() - 1;

            while(start<=end){
                int mid = start + (end-start) / 2;
                int patientMidVal = patientArrayList.get(mid).getID();

                if (id < patientMidVal){
                    end = mid - 1;
                }
                else if (id > patientMidVal){
                    start = mid + 1;
                }
                else{
                    Patient sortPatient = patientArrayList.get(mid);
                    return sortPatient;
                }
            }
        }

        else{
            System.out.println("Only medical staff can search for patients, sorry.");
            return null;
        }
        return null;
    }

    public void patientEdit(Patient curPatient){
        Scanner scnr = new Scanner(System.in);
        System.out.println("What would you like to edit?");
        System.out.println("Options include: password, name, email, and treatment notes");
        String choice = scnr.next();

        System.out.println("")
        
        scnr.close();
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