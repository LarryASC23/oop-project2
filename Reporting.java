import java.io.*;
import java.util.*;

public class Reporting {

    public static void generateReport(ArrayList<Patient> patientArrayList,User loggedUser) throws IOException{
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter filename to save report (blank.txt):");
        String fileName = scnr.nextLine();

        System.out.println("Select report type:");
        System.out.println("1. List of Patients, sorted ascending by id");
        System.out.println("2. List of Patients, sorted ascending by name");
        System.out.println("3. List of all emails, sorted ascending alphabetically");
        System.out.println("4. All the logged in user's information/attributes");
        int choice = scnr.nextInt();

        System.out.println("Writing to file...");
        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        if (choice == 1){ //should already be sorted
            for (int i = 0; i < patientArrayList.size(); i++) {
                Patient p = patientArrayList.get(i);
                printWriter.println(p.getID() + "," + p.getName() + "," + p.getEmail());
            }
        }

        else if (choice == 2){ //bubble sort
            for (int i = 0; i < patientArrayList.size() - 1; i++) {
                for (int j = 0; j < patientArrayList.size() - 1; j++) {
                    if (patientArrayList.get(j).getName().compareToIgnoreCase(patientArrayList.get(j + 1).getName()) > 0) {
                        Patient temp = patientArrayList.get(j);
                        patientArrayList.set(j, patientArrayList.get(j + 1));
                        patientArrayList.set(j + 1, temp);
                    }
                }
            }
            for (int i = 0; i < patientArrayList.size(); i++) {
                Patient p = patientArrayList.get(i);
                printWriter.println(p.getID() + "," + p.getName() + "," + p.getEmail());
            }
        }

        else if (choice == 3){ //bubble sort
            ArrayList<String> emails = new ArrayList<>();
            for (int i = 0; i < patientArrayList.size(); i++) {
                emails.add(patientArrayList.get(i).getEmail());
            }
            for (int i = 0; i < emails.size() - 1; i++) {
                for (int j = 0; j < emails.size() - 1; j++) {
                    if (emails.get(j).compareToIgnoreCase(emails.get(j + 1)) > 0) {
                        String temp = emails.get(j);
                        emails.set(j, emails.get(j + 1));
                        emails.set(j + 1, temp);
                    }
                }
            }
            for (int i = 0; i < emails.size(); i++) {
                printWriter.println(emails.get(i));
            }
        }

        else if (choice == 4){
            printWriter.println(loggedUser.toString()); 
        }

        System.out.println("Successfully finished writing to " + fileName);
        fileWriter.close();
        printWriter.close();
        scnr.close();
    }
}
