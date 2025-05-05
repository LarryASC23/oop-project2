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

    public void patientEdit(Patient curPatient) throws IOException{
        Scanner scnr = new Scanner(System.in);
        while(true){
            System.out.println("What would you like to edit?");
            System.out.println("Options include: password, name, email, treatment notes.");
            System.out.println("Once you are done editing, type \"exit\"");
            String choice = scnr.nextLine();

            System.out.println("What would you like to change that to?");
            String value = scnr.nextLine();
            
            if (choice.equalsIgnoreCase("password")) {
                curPatient.password = value;
            } 
            else if (choice.equalsIgnoreCase("name")) {
                curPatient.name = value;
            } 
            else if (choice.equalsIgnoreCase("email")) {
                curPatient.email = value;
            } 
            else if (choice.equalsIgnoreCase("treatment_notes")) {
                curPatient.setTreatmentNotes(value);
            }
            else if (choice.equalsIgnoreCase("exit")) {
                break;
            }
        }

        scnr.close();

        // write all patients to file (thus should include edited patient)
        System.out.println("Writing to file...");
        FileWriter fileWriter = new FileWriter(patientFileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for (int i = 0; i < patientArrayList.size(); i++) {
            Patient p = patientArrayList.get(i);
            printWriter.println(p.getID() + "," + p.getUsername() + "," + p.getPassword() + "," + p.getName() + "," + p.getEmail() + "," + p.getTreatmentNotes());
        }
    
        printWriter.close();
        fileWriter.close();
        System.out.println("Successfully wrote to file.");
        
    }
}