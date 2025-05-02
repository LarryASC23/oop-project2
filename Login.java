import java.io.*;
import java.util.*;
public class Login {
    Scanner scnr = new Scanner(System.in);

    public void loadData(String patientFile, String staffFile) throws IOException{
        ArrayList<Patient> patients = new ArrayList<Patient>();
        ArrayList<MedicalStaff> staff = new ArrayList<MedicalStaff>();

        while(true){
            BufferedReader patientReader = new BufferedReader(new FileReader(patientFile));
            String line = patientReader.readLine();
            while(line != null) {
                String[] parts = line.split(",");
                patients.add(new Patient(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4],parts[5]));
                line = patientReader.readLine();
            }
            patientReader.close();
            break;
        }

        BufferedReader staffReader = new BufferedReader(new FileReader(staffFile));
        String line = staffReader.readLine();
        while(line != null) {
            String[] parts = line.split(",");
            staff.add(new MedicalStaff(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4],parts[5]));
            line = staffReader.readLine();
        }
        staffReader.close();
    }

    public String choice() {
        String fileName = "";
        while(true) {
            System.out.println("Signing in as a Patient or Medical Staff?");
            String choice = scnr.next();
            if(choice.equalsIgnoreCase("Patient")){
                fileName = "dataset/patient.csv";
                break;
            }
            else if(choice.equalsIgnoreCase("Medical Staff")){
                fileName = "dataset/medicalstaff.csv";
                break;
            }
            else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        return fileName;
    }

}


/*
When the program starts:

Ask the user for their username and password.

Check if they exist in a patients file OR a medical staff file.

If found → create the correct object (Patient or MedicalStaff) and move on.

If not → tell them the login failed and ask again.
 */