import java.io.*;
import java.util.*;
public class Driver {
    public static void main(String[] args) {
        String patientFile = "/datasets/patient.csv";
        String staffFile = "/datasets/medicalstaff.csv";

        Login login = new Login(); //login 
        User loggedUser = login.loginCheck(patientFile,staffFile);

        ArrayList<Patient> patientArrayList =  new ArrayList<>(); //patient list to be stored in manager
        PatientManager manager = new PatientManager(loggedUser, patientArrayList, patientFile);

    }

    public ArrayList<Patient> patientArray(String patientFile) throws IOException{
        ArrayList<Patient> patientArrayList = new ArrayList<>();
        BufferedReader patientReader = new BufferedReader(new FileReader(patientFile));
        String line = patientReader.readLine();
        
        while(line != null) {
            String[] parts = line.split(",");
            patientArrayList.add(new Patient(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4],parts[5]));
            line = patientReader.readLine();
        }
        patientReader.close();
        return patientArrayList;
    }
}

/*
You are being asked to:

Create a class hierarchy (User, Patient, MedicalStaff).

Implement file reading (for login and loading patients).

Implement basic login authentication.

Allow viewing and editing of patient profiles.

Implement sorting and binary search (YOU must write the sorting and searching yourself, no Java Collections sort() or anything automatic!).

Save changes back to the file when editing happens.

Allow report generation.

Driver (main method) to glue everything together and handle menus.

 */