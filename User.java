public abstract class User {
    final int id; //final after declaration
    final String username; //final after declaration
    String password;
    String name;
    String email;

    public User(int id, String username, String password, String name, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public int getID(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String toString() {
        return "Id: " + id + "\nUsername: " + username + "\nPassword: " + password + "\nName: " + name + "\nEmail: " + email;
    }
}
