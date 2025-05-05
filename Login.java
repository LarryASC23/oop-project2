import java.io.*;
import java.util.*;
public class Login {
    Scanner scnr = new Scanner(System.in);

    public User loginCheck(String patientFile, String staffFile) throws IOException{
        ArrayList<Patient> patientArrayList = new ArrayList<Patient>();
        ArrayList<MedicalStaff> staffArrayList = new ArrayList<MedicalStaff>();

        BufferedReader patientReader = new BufferedReader(new FileReader(patientFile));
        String line = patientReader.readLine();
        
        while(line != null) {
            String[] parts = line.split(",");
            patientArrayList.add(new Patient(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4],parts[5]));
            line = patientReader.readLine();
        }
        patientReader.close();

        BufferedReader staffReader = new BufferedReader(new FileReader(staffFile));
        line = staffReader.readLine();
        while(line != null) {
            String[] parts = line.split(",");
            staffArrayList.add(new MedicalStaff(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4],parts[5]));
            line = staffReader.readLine();
        }
        staffReader.close();

        // login
        String username = null;
        String password = null;

        while(true){
            System.out.println("Please enter your username.");
            String tempUsername=scnr.next();
            System.out.println("Please enter your password.");
            String tempPassword=scnr.next();
            
            for(int i = 0; i < patientArrayList.size(); i++){
                if(patientArrayList.get(i).getUsername().equals(tempUsername) && patientArrayList.get(i).getPassword().equals(tempPassword)){
                    username = tempUsername; // yay!
                    password = tempPassword;
                    return patientArrayList.get(i);
                }
            }
            for(int i = 0; i < staffArrayList.size(); i++){
                if(staffArrayList.get(i).getUsername().equals(tempUsername) && staffArrayList.get(i).getPassword().equals(tempPassword)){
                    username = tempUsername; // yay!
                    password = tempPassword;
                    return staffArrayList.get(i);
                }
            }
            
            if(username == null || password == null ){
                System.out.println("No user with that username was found, please try again.");
                continue;
            }
            else{
                break;
            }
        }
        return null;
    }
}


/*
When the program starts:

Ask the user for their username and password.

Check if they exist in a patients file OR a medical staff file.

If found → create the correct object (Patient or MedicalStaff) and move on.

If not → tell them the login failed and ask again.
 */