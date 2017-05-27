import java.util.Scanner;
public class Login {
    protected String username;
    protected String password;
    private Scanner scan = new Scanner(System.in);
    public Login (String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login() {
        System.out.print("Enter username to login: ");
        String username = scan.nextLine();
        System.out.print("Enter the password that is associated with this account: ");
        String password = scan.nextLine();
        if (this.username.equals(username) && this.password.equals(password)) { 
            return true;
        }
        else {
            return false;
        }
    }
}