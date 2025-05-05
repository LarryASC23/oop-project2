import java.io.*;
import java.util.*;
public class Driver {
    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);
        String patientFile = "/datasets/patient.csv";
        String staffFile = "/datasets/medicalstaff.csv";

        Login login = new Login(); //login 
        User loggedUser = login.loginCheck(patientFile,staffFile);

        ArrayList<Patient> patientArrayList =  new ArrayList<>(); //patient list to be stored in manager
        patientArrayList = patientArrayMaker(patientFile);

        PatientManager manager = new PatientManager(loggedUser, patientArrayList, patientFile);

        while(true){
            System.out.println("What would you like to do (only enter corresponding integer)");
            System.out.println("0. Exit");
            System.out.println("1. View Profile");
            if(loggedUser instanceof MedicalStaff){
                System.out.println("2. Patient Lookup by ID");
                System.out.println("3. Edit Patient Information");
                System.out.println("4. Generate ")
            }
            else{
                System.out.println("2. Edit my information");
            }

            int action = scnr.nextInt();

            if(action == 0){
                break;
            }
            else if(action == 1){
                manager.viewProfile();
            }
            else if (action == 2 && loggedUser instanceof MedicalStaff){
                // patient lookup
                System.out.println("Enter the ID of the patient you are looking for.");
                int idToFind = scnr.nextInt();
                Patient binaryPatient = manager.patientBinarySearch(idToFind);
                if(binaryPatient == null){
                    System.out.println("No patient found");
                }
                else{
                    System.out.println(binaryPatient);
                }
            }
            else if (action == 2 && loggedUser instanceof Patient){
                // edit patients own stuff
            }
            else if (action == 3 && loggedUser instanceof MedicalStaff){
                // edit select patient info 
            }

        }
    }

    public static ArrayList<Patient> patientArrayMaker(String patientFile) throws IOException{
        // attaching file to arraylist (basically)
        ArrayList<Patient> patientArrayList = new ArrayList<>();
        BufferedReader patientReader = new BufferedReader(new FileReader(patientFile));
        String line = patientReader.readLine();
        
        while(line != null) {
            String[] parts = line.split(",");
            patientArrayList.add(new Patient(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4],parts[5]));
            line = patientReader.readLine();
        }
        patientReader.close();

        // sorting arraylist using bubble sort

        for(int i = 0; i < patientArrayList.size() - 1; i++){
            for(int j = 0; j < patientArrayList.size() - 1; j++){
                if(patientArrayList.get(j).getID() > patientArrayList.get(j + 1).getID()){
                    Patient temp = patientArrayList.get(j);
                    patientArrayList.set(j, patientArrayList.get(j + 1));
                    patientArrayList.set(j + 1, temp);
                }
            }
        }

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