import java.io.*;
import java.util.*;
public class Driver {
    public static void main(String[] args) {
        String patientFile = "/datasets/patient.csv";
        String staffFile = "/datasets/medicalstaff.csv";
        Login login = new Login(); //create manager
        login.loginCheck(patientFile,staffFile); //login 

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