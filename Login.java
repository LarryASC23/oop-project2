import java.io.*;
import java.util.*;
public class Login {
    Scanner scnr = new Scanner(System.in);

    public String choice() {
        System.out.println("Signing in as a Patient or Medical Staff?");
        String choice = scnr.next();
        String fileName = "";
        while(true) {
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

    public void loadData(String filename, String filename2) throws IOException{
        ArrayList<Patient> patients = new ArrayList<Patient>();
        ArrayList<MedicalStaff> staff = new ArrayList<MedicalStaff>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while(line != null) {

            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}


/*
When the program starts:

Ask the user for their username and password.

Check if they exist in a patients file OR a medical staff file.

If found → create the correct object (Patient or MedicalStaff) and move on.

If not → tell them the login failed and ask again.
 */