public class Patient extends User{
    private String treatment_notes;

    public Patient(int id, String username, String password, String name, String email, String treatment_notes) {
        super(id, username, password, name, email);
        this.treatment_notes = treatment_notes;
    }

    public String getTreatmentNotes(){
        return treatment_notes;
    }

    public void setTreatmentNotes(String newNotes){
        treatment_notes = newNotes;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\nUsername: " + username + "\nPassword: " + password + "\nName: " + name + "\nEmail: " + email + "\nTreatment Notes: " + treatment_notes;
    }
}