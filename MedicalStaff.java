public class MedicalStaff extends User{
    private String department;

    public MedicalStaff(int id, String username, String password, String name, String email, String department) {
        super(id, username, password, name, email);
        this.department = department;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\nUsername: " + username + "\nPassword: " + password + "\nName: " + name + "\nEmail: " + email + "\nDepartment: " + department;
    }
}